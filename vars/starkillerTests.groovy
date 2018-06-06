def call(Map config) {
	dir ("${params.REQUESTED_ACTION}") {
	sh "make ${config.test}"
	}
}