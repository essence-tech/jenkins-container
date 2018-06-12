def deployService(service, target = '') {
	//k8s
	dir ("${serviceName}") {
	  kubectl apply -f "${service}.yaml"
  }
}

def activate_service_account_gc(){
   		sh 'gcloud auth activate-service-account --key-file=${JENKINS_HOME}${SECRETS_DIR}${SERVICE_ACCOUNT_FILE}'
		}

def buildImage(imageName, dockerfile) {
    def testImage = docker.build("${imageName}", "-f ${params.microServiceOption}/${dockerfile} .")
}

def buildImageAndTest(imageName, dockerfile) {
    def testImage = docker.build("${imageName}", "-f ${params.microServiceOption}/${dockerfile} .")

    testImage.inside {
        sh 'make test'
    }
}

def pushImageGcr(imageName) {
    activate_service_account_gc()
		sh
		'''
		docker tag "${imageName}"" eu.gcr.io/"${PROJECTNAME}"/"${params.microServiceOption}":"${env.BUILD_NUMBER}"
		gcloud docker -- push eu.gcr.io/"${PROJECTNAME}"/"${params.microServiceOption}":"${env.BUILD_NUMBER}"
		'''
}