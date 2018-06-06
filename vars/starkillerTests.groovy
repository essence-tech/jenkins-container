def call(Map config) {
	dir ("${params.REQUESTED_ACTION}") {
	sh "make ${config.test}"
}
	// return sh(script: "make BDD_TESTS", returnStdout: true)
}