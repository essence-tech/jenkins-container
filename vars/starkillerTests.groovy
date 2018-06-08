//This is the main logic to run the test.
// def runTest(serviceName='') {
// 	def service = "${params.microserviceOption}"
// 	if(serviceName?.trim()) {
//     service = "${serviceName}"
// 	}
// 	dir ("${service}") {
// 		sh "ls && make ${config.test}"
// 	}
// }
def runTest(serviceName, testName) {
	dir ("${serviceName}") {
		sh "make ${testName}"
	}
}

def runAll() {
	//Make a list of strings
	String[] ms = microServicesList.split(',')
	ms.each {
		runTest("${it}", bdd_tests)
		//sh "cd ${it} && make tests"
		//runTest(test:'bdd_tests', True)
	}
}