def buildImage(Closure body) {
	body()
	docker.image('eu.gcr.io/starkiller-184118/build-containers/build-image-alpine').inside("${DOCKER_SOCK_VOLUME} ${JENKINS_HOME}${SECRETS_DIR} -u root") {
		sh 'docker ps'
  }
}