def buildImage(Map config,Closure body) {
	def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
		docker.image("${config.image}").inside("${DOCKER_SOCK_VOLUME} ${JENKINS_HOME}${SECRETS_DIR} -u root") {
			sh 'docker ps'
  	}
}