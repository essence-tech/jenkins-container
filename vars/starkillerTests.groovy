def call(Map config) {
	dir ("${params.microserviceOption}") {
	sh "cd frontend/ && make ${config.test}"
	}
}