def buildService(String imageName, String tag, String service) {
	echo "${imageName} ${tag}"
	def customImage = docker.build("${imageName}":"${tag}", "./${service}/Dockerfile")
}