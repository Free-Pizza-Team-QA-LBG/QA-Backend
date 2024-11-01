pipeline {
    agent any
    
    tools {
        maven 'Maven 3.8.6' // Make sure to define your Maven version here or in Jenkins tool config
    }

    stages {
        stage('Build') {
            steps {
                echo 'Starting build...'
                // Run the Maven build
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                // Run Maven tests
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging application...'
                // Package the application
                sh 'mvn package'
            }
        }
    }

    post {
        success {
            publishGitHubCheck('success', 'All stages completed successfully')
        }
        failure {
            publishGitHubCheck('failure', 'One or more stages failed')
        }
    }
}

// Helper function to publish GitHub Checks
def publishGitHubCheck(String status, String description) {
    githubCheck(
        name: 'Jenkins Build',        // Name of the GitHub check
        detailsURL: "${env.BUILD_URL}", // Link back to the Jenkins build
        conclusion: status,           // Either 'success', 'failure', or 'neutral'
        title: 'Build and Test Status',
        summary: description          // Description of the check result
    )
}