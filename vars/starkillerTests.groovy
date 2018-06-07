def runTest(Map config) {
	dir ("${params.microserviceOption}") {
	sh " ls && make ${config.test}"
	}
}

def runAll(Map config) {
	sh "echo Running all tests && make ${config.test}"
	}