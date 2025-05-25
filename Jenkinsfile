pipeline {
  agent any

  environment {
    IMAGE_TAG = "${env.BUILD_NUMBER}"
  }

  stages {
    stage('Clean') {
      steps {
        deleteDir()
      }
    }

    stage('Checkout') {
      steps {
        git url: 'https://github.com/2kaushik7/fx-alert-app.git', branch: 'main'
      }
    }

    stage('Build JAR') {
      steps {
        dir('fx-rate-service') {
          sh 'mvn clean package -DskipTests'
        }
        dir('alert-service') {
          sh 'mvn clean package -DskipTests'
        }
        dir('api-gateway') {
          sh 'mvn clean package -DskipTests'
        }
      }
    }

    stage('Build Docker Images') {
      steps {
        sh 'docker build -t fx-rate-service ./fx-rate-service'
        sh 'docker build -t alert-service ./alert-service'
        sh 'docker build -t api-gateway ./api-gateway'
      }
    }

    stage('Stop and Remove Old Containers') {
      steps {
        sh '''
          docker rm -f fx-rate-service || true
          docker rm -f alert-service || true
          docker rm -f api-gateway || true
        '''
      }
    }

    stage('Start via Docker Compose') {
        steps {
            sh 'docker-compose down || true'
            sh 'docker-compose up -d --build'
        }
    }
  }

  post {
    failure {
      echo '❌ Build or Deployment Failed.'
    }
    success {
      echo '✅ App deployed successfully.'
    }
  }
}
