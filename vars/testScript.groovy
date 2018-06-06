// vars/testScript.groovy
def call() {
    lsb = sh(returnStdout: true, script: 'ls')
}