def call(body) {

        def config = [:]
        body.resolveStrategy = Closure.DELEGATE_FIRST
        body.delegate = config
        body()

        node {
            // Clean workspace
            deleteDir()

            try {
                // stage ('Clone') {
                //     checkout scm
                // }
                stage ('Build') {
                	buildStaticTests()
                }
                stage ('Tests') {
                    parallel 'static': {
                        echo "${config.projectName}"
                    },
                    'unit': {
                        sh "echo 'shell scripts to run unit tests...'"
                    },
                    'integration': {
                        sh "echo 'shell scripts to run integration tests...'"
                    }
                }
                stage ('Deploy') {
                    echo "${config.serverDomain}"
                }
            } catch (err) {
                currentBuild.result = 'FAILED'
                throw err
            }
        }
    }

//Functions to call Tests
def buildStaticTests() {
        	echo "MAKE TEST"
   }
