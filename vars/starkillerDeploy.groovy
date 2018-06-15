def deployServiceK8s(service, target = '') {
	//k8s
	dir ("${serviceName}") {
	  kubectl apply -f "${service}.yaml"
  }
}