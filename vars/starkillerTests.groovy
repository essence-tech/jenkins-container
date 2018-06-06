def call(Map config) {
	dir ("${params.REQUESTED_ACTION}")
	return sh(script: "make BDD_TESTS", returnStdout: true)
}