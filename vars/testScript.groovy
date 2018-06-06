// vars/testScript.groovy
def call(body) {
    // evaluate the body block, and collect configuration into the object
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    sh "echo ${config.gitTag} is with ${config.gitCommit}"
  }