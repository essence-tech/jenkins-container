def call(body) {

        def config = [:]
        body.resolveStrategy = Closure.DELEGATE_FIRST
        body.delegate = config
        body()

        node {
            // Clean workspace
            deleteDir()

            try {
                stage ('checkout') {
                	checkout scm
                }
                 stage ('testbdd') {
                 		dir ('frontend')
                 		buildBddTests()
                }
                // stage ('Tests') {
                //     parallel 'static': {
                //     		sh 'cd "${config.microService}/ "'
                //         buildStaticTests()
                //     },
                //     'unit': {
                //     		sh 'cd "${config.microService}"'
                //         buildUnitTests()
                //     },
                //     'integration': {
                //     		sh 'cd "${config.microService}"'
                //         buildBddTests()
                //     }
                // }
            } catch (err) {
                currentBuild.result = 'FAILED'
                throw err
            }
        }
    }

//Functions to call Tests
def buildStaticTests() {
	sh 'make STATIC_TESTS'
   }
def buildUnitTests() {
	sh 'make UNIT_TESTS'
   }
def buildIntergrationTests() {
	sh 'make INTEGRATION_TESTS'
   }
def buildBddTests() {
	sh 'make BDD_TESTS'
   }
