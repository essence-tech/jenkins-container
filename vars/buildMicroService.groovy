def buildMicroService(imageName, String tag = 'latest', service ) {
	def customImage = docker.build("${imageName}":"${tag}", "./${service}/Dockerfile")
}