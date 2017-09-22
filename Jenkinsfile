#!groovy
def jobName = 'gs-spring-boot-docker'

node {

  stage('Pre Build') {
    try {
      echo "Cloning code from git branch"
    } catch (exc) {
      echo "unable to pull code from branch"
      throw exc
    }
  }

  stage('Build') {
    try {
      echo "Running Build Environment"
    } catch (exc) {
      echo "Build failed"
      throw exc
    }
  }

}