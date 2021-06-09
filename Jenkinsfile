pipeline {
  environment {
    dockerImage = ''
  }
  tools {
    jdk "JAVA11"
  }
  agent any
  stages {
    stage('Build') {
      steps {
        script {
            git branch:'main',url:'https://github.com/thongchaiSH/spring-jenkins-pipeline'
            withMaven(
            maven: 'M3')
            {
                sh "mvn clean package"
            }
        }
      }
    }
    stage('CodeCoverage') {
        steps {
        	step([$class: 'JacocoPublisher', changeBuildStatus: false, inclusionPattern: 'com/jenkins/app/**/service/*.class', minimumBranchCoverage: '80', sourcePattern: '**/src'])
        }
    }
    stage('SonarQube analysis') {
        steps{
            withSonarQubeEnv('SonarQubeServer') {
                withMaven(maven: 'M3'){
                    sh 'mvn sonar:sonar'
                }
            }
        }
    }
    stage('Build2') {
      steps {
        sh 'echo "hello"'
      }
    }
  }
}