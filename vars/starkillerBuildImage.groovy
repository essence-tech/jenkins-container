def buildImage(Closure body, Map config) {
	body()
	docker.image("${config.image}").inside("${DOCKER_SOCK_VOLUME} ${JENKINS_HOME}${SECRETS_DIR} -u root") {
		sh 'docker ps'

}