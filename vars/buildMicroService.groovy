def buildService(String imageName, String tag, String service) {
	echo "Building ${imageName} with tag ${tag}"
	sh 'docker build -t "${env.imageName}":"${env.tag}" -f "${env.service}"/Dockerfile'
}