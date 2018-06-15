def activateServiceAccountGc(){
	sh 'gcloud auth activate-service-account --key-file=${JENKINS_HOME}${SECRETS_DIR}${SERVICE_ACCOUNT_FILE}'
		}

def deactivateServiceAccount(serviceAccountEmail){
	sh "gcloud auth revoke ${serviceAccountEmail}"
}

def  authDockerGc() {
  sh 'gcloud auth configure-docker'
}

def pullDockerImages(gcrRegion, imageName) {
	sh "gcloud docker -- pull ${gcrRegion}/${PROJECTNAME}/build-containers/${imageName}"
	return "${gcrRegion}/${PROJECTNAME}/build-containers/${imageName}"
}

def pushImage(imageName) {
    sh "gcloud docker -- push eu.gcr.io/${env.PROJECTNAME}/${params.microServiceOption}:${env.BUILD_NUMBER}"
}