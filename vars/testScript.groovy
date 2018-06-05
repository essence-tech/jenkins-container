// vars/testScript.groovy
def call(Closure body) {
    node {
        sh 'echo "this is the ls"'
        sh 'ls'
    }
}