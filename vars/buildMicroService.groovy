def buildService(String imageName, String tag, String service) {
	echo "Building ${imageName} with tag ${tag} "
	sh 'docker build -t "${imageName}":"${tag}" -f "${service}"/Dockerfile'
}