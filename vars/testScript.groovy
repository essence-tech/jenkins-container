// vars/testScript.groovy
def call(Closure body) {
    node {
        body()
    }
}