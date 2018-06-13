def deployService(service, target = '') {
	//k8s
	dir ("${serviceName}") {
	  kubectl apply -f "${service}.yaml"
  }
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
    sh "gcloud docker -- push eu.gcr.io/${env.PROJECTNAME}/${params.microServiceOption}:${env.BUILD_NUMBER}"
}