def buildService(String imageName, String tag, String service) {
	echo "Building ${imageName} with tag ${tag}"
	def customImage = docker.build(\""${imageName}"\", \"./"${service}"/Dockerfile\")
}