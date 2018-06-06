def buildTest() {
	dir ("${params.REQUESTED_ACTION}") {
	sh "make BDD_TESTS"
}
	// return sh(script: "make BDD_TESTS", returnStdout: true)
}