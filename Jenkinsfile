pipeline {
    agent any
    
    tools {
        maven 'Maven 3.8.6' // Make sure to define your Maven version here or in Jenkins tool config
    }

    stages {
        stage('Build') {
            steps {
                // Run the Maven build
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                // Run Maven tests
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                // Package the application (optional)
                sh 'mvn package'
            }
        }
    }

    post {
        success {
            echo 'Build and tests succeeded!'
        }
        failure {
            echo 'Build or tests failed.'
        }
    }
}