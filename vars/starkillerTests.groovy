/*
Maintainer: Michel Laporte
2Sixty Essence
*/

//Default Test Logic. Do NOT change
def runTest(serviceName='', testName) {
	dir ("${serviceName}") {
		sh "make ${testName}"
	}
}
//All Tests to run. This will be default for deploy and tests
def runAll() {
	String[] ms = microServicesList.split(',')
	ms.each {
		runTest("${it}", 'tests')
	}
}
//This is the tests to run based on selection from parameter 'microServiceOption'
def runMicroServiceTest(testName) {
	runTest("${params.microServiceOption}", "${testName}")
}