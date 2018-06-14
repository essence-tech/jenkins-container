def buildImage(Closure body) {
	body()
	docker.image('docker').inside("${DOCKER_SOCK_VOLUME} ${JENKINS_HOME}${SECRETS_DIR} -u root") {
		sh 'docker ps'
  }
}