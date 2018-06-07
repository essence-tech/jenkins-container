def call() {
	stage('Static Tests') {
	  agent {
	    docker {
	    label 'master'
	    image 'mugen/ubuntu-build-essential'
	    args '-u root:sudo'
	    }
	  }
	  steps {
	    script {
	    starkillerTests.runTest(test:'bdd_tests')
	    }
	  }
	}
}