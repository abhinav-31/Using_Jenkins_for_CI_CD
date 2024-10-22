pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout code using GitHub credentials
                git branch: 'main', 
                    url: 'https://github.com/abhinav-31/Using_Jenkins_for_CI_CD.git',
                    credentialsId: 'add8e79a-4225-4160-91b6-b9b6e31bc73a' // Use the ID of the credentials added in Jenkins
            }
        }

        stage('Docker Cleanup') {
            steps {
                script {
                    sh 'docker-compose ls -a'
                    sh 'docker-compose down'
                    sh 'docker image ls -a'
                    sh 'docker image rm fullstackproject-spring-boot-app || true'
                    sh 'docker image rm fullstackproject-react-app || true'
                    sh 'docker image ls -a'
                }
            }
        }

        stage('Docker Build') {
            steps {
                script {
                    sh 'docker-compose build'
                }
            }
        }

        stage('Docker Deploy') {
            steps {
                script {
                    sh 'docker-compose up -d'
                }
            }
        }
    }

    post {
        success {
            echo 'Build and Deployment Successful'
        }
        failure {
            echo 'Build or Deployment Failed'
        }
    }
}
