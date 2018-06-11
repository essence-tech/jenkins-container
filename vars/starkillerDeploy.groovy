def deployService(service, target = '') {
	//k8s
	dir ("${serviceName}") {
	  kubectl apply -f "${service}.yaml"
  }
}

def buildImage(imageName, dockerfile) {
    def testImage = docker.build("${imageName}", "-f /${params.microServiceOption}/${dockerfile} .")

    // testImage.inside {
    //     sh 'make test'
    // }
}