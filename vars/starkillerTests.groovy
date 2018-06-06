def call(Map config) {
	dir ("${params.microserviceOption}") {
	sh "make ${config.test}"
	}
}