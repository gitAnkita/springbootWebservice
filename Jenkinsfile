#!groovy
def jobName = 'gs-spring-boot-docker'

node {

  stage('Pre Build') {
    try {
      echo "Cloning code from git branch"
      sh "mvn install dockerfile:build"
    } catch (exc) {
      echo "unable to pull code from branch"
      throw exc
    }
  }

  stage('Build') {
    try {
      echo "Running Build Environment"
      sh "docker run -p 8080:8080 springio/gs-spring-boot-docker"
    } catch (exc) {
      echo "Build failed"
      throw exc
    }
  }

}