def buildServiceImage(body) {
		def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
		docker.image("${config.image}").inside("${DOCKER_SOCK_VOLUME} -v ${JENKINS_HOME}${SECRETS_DIR}:${JENKINS_HOME}${SECRETS_DIR} -u root") {
			starkillerGoogleOptions.activateServiceAccountGc()
			buildImage("${config.registryRegion}/${PROJECTNAME}/${params.microServiceOption}:${env.BUILD_NUMBER}","${config.dockerfile}")
      pushImageGcr("${params.microServiceOption}-${env.BUILD_NUMBER}")
  	}
}

def buildImage(imageName, dockerfile) {
    def testImage = docker.build("${imageName}", "-f ${params.microServiceOption}/${dockerfile} .")
}

def pushImageGcr(imageName) {
    sh "gcloud docker -- push eu.gcr.io/${env.PROJECTNAME}/${params.microServiceOption}:${env.BUILD_NUMBER}"
}