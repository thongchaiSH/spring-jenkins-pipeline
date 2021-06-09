pipeline {
  environment {
    dockerImage = ''
    registry = "thongchaidocker/spring-jenkins-pipeline"
    registryCredential = 'dockerhub'
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
    stage("Quality Gate") {
        steps {
            waitForQualityGate abortPipeline: true
        }
    }
    stage('Building image') {
      steps{
        script {
          dockerImage = docker.build registry + ":$BUILD_NUMBER"
        }
      }
    }
    stage('Deploy Image') {
      steps{
         script {
            docker.withRegistry( '', registryCredential ) {
            dockerImage.push()
          }
        }
      }
    }
    stage('Remove Unused docker image') {
      steps{
        sh "docker rmi $registry:$BUILD_NUMBER"
      }
    }
    stage('Build2') {
      steps {
        sh 'echo "hello"'
      }
    }
  }
}