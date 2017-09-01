JENKINS_DATA_VOLUME = jenkins_data
IMAGE_NAME = 2sixty/jenkins
CONTAINER_NAME = jenko

.PHONY: usage
usage:
	@echo "Available commands: "
	@echo
	@echo "\t run - run the container"
	@echo "\t remove - remove the image"
	@echo "\t remove_volume - remove the persistent data volume for the container"

.PHONY: run
run:
	@- docker rm -f $(CONTAINER_NAME)
	@$(MAKE) _rm_container
	@$(MAKE) _setup_volume
	@if ! docker images | grep $(IMAGE_NAME); then \
	    $(MAKE) _build; \
        fi
	@docker run -p 8080:8080 -p 50000:50000 \
		-v $(JENKINS_DATA_VOLUME):/var/jenkins_home \
		-v ~/.ssh/id_rsa:/home/jenkins/.ssh/ \
		--name $(CONTAINER_NAME) $(IMAGE_NAME)
	@echo "Jenko is up and running"

.PHONY: remove
remove:
	@if docker images | grep $(IMAGE_NAME); then \
            $(MAKE) _rm_container; \
	    docker rmi -f $(IMAGE_NAME) || exit 1; \
	    echo "Jenkins image removed"; \
        else \
            echo "No image to remove"; \
        fi

.PHONY: _create_volume
_create_volume:
	@docker volume create --name $(JENKINS_DATA_VOLUME)
	@echo "Jenkins data volume created"

.PHONY: remove_volume
remove_volume:
	@if docker volume ls | grep $(JENKINS_DATA_VOLUME); then \
  	    $(MAKE) _rm_container; \
	    docker volume rm $(JENKINS_DATA_VOLUME) || exit 1; \
	    echo "Jenkins data volume removed" ; \
	else \
	    echo "No volume to remove"; \
        fi

.PHONY: _setup_volume
_setup_volume:
	@if ! docker volume ls | grep $(JENKINS_DATA_VOLUME); then \
            $(MAKE) _create_volume; \
	fi

.PHONY: _build
_build:
	docker build -t $(IMAGE_NAME) .

.PHONY: _rm_container
_rm_container:
	@if docker ps | grep $(CONTAINER_NAME); then \
	    $(MAKE) _stop_container; \
	    docker rm $(CONTAINER_NAME); \
        fi

.PHONY: _stop_container
_stop_container:
	@docker stop $(CONTAINER_NAME)
