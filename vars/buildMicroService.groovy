def buildMicroService(imageName, String tag = 'latest') {
	echo "${imageName} ${tag}"
	//def customImage = docker.build("${imageName}":"${tag}", "./${service}/Dockerfile")
}