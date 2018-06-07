def runTest(Map config) {
	def service = "${params.microserviceOption}"
	dir ("${service}") {
		sh "ls && make ${config.test}"
	}
}

def runAll() {
	//Make a list of strings
	String[] ms = microServicesList.split(',')
	ms.each {
		sh "cd ${it} && make bdd_tests"
		//runTest(test:'bdd_tests')
	}
}