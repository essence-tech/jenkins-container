def runTest(serviceName='', testName) {
	dir ("${serviceName}") {
		sh "make ${testName}"
	}
}

def runAll() {
	//Make a list of strings
	String[] ms = microServicesList.split(',')
	ms.each {
		runTest("${it}", 'tests')
	}
}

def runMicroServiceTest(testName) {
	runTest("${params.microserviceOption}", "${testName}")
}