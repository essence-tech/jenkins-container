def buildService(String imageName, String tag) {
	echo "${imageName} ${tag}"
	//def customImage = docker.build("${imageName}":"${tag}", "./${service}/Dockerfile")
}