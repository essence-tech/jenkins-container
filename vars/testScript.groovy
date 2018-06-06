// vars/testScript.groovy
def call(Map config) {
    // evaluate the body block, and collect configuration into the object
    sh "echo ${config.gitTag} is with ${config.gitCommit}"
  }