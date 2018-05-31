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
                        sh 'gcloud config list'
                    },
                    'unit': {
                        sh "echo 'shell scripts to run unit tests...'"
                    },
                    'integration': {
                        sh "echo 'shell scripts to run integration tests...'"
                    }
                }
                stage ('Deploy') {
                    sh "echo 'deploying to server ${config.serverDomain} & ${config.projectName}...'"
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
