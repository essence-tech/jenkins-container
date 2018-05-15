def buildMicroService(imageName) {
	echo "${imageName}" //"${tag}" "${service}"
	//def customImage = docker.build("${imageName}":"${tag}", "./${service}/Dockerfile")
}