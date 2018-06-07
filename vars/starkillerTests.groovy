// def runTest(Map config) {
// 	dir ("${params.microserviceOption}") {
// 	sh " ls && make ${config.test}"
// 	}
// }

// def runAll(Map config) {
// 	sh "echo running all tests && make ${config.test}"
// 	}
// }
def runTest(Map config) {
	def service = "${params.microserviceOption}"
	dir ("${service}") {
		sh "ls && make ${config.test}"
	}
}

def runAll() {
	//def microServicesList = "[frontend]"
	println microServicesList.getClass()
	microServicesList.each {
	runTest(test:'bdd_tests')
	}
}