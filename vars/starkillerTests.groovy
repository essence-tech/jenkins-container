def runTest(Map config) {
	def service = "${params.microserviceOption}"
	dir ("${service}") {
		sh "ls && make ${config.test}"
	}
}

def runAll() {
	//Make a list of strings
	def ms = microServicesList.split(',')
	ms.each {
		//runTest(test:'bdd_tests')
		dir ("${ms}") {
			sh "ls && make bdd_tests"
		}
	}
}