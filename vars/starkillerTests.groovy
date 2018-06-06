def call(args) {
	dir ("${params.REQUESTED_ACTION}")
	return sh(script: "make ${arg1}", returnStdout: true)
}