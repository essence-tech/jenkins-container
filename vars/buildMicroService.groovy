def buildMicroService(imageName, String tag = 'latest', service ) {
	echo "${imageName}" "${tag}" "${service}"
	//def customImage = docker.build("${imageName}":"${tag}", "./${service}/Dockerfile")
}