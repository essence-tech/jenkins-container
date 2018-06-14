def buildImage(Map config,Closure body) {
	body()
	docker.image("${config.image}").inside("${DOCKER_SOCK_VOLUME} ${JENKINS_HOME}${SECRETS_DIR} -u root") {
		sh 'docker ps'
  }
}