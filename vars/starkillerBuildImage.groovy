def buildImage(Closure body, image) {
	body()
	docker.image("${image}").inside("${DOCKER_SOCK_VOLUME} ${JENKINS_HOME}${SECRETS_DIR} -u root") {
		sh 'docker ps'
  }
}