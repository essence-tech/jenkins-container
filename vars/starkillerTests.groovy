def call(Map config) {
	dir ("${params.microserviceOption}") {
	sh " ls && make ${config.test}"
	}
}