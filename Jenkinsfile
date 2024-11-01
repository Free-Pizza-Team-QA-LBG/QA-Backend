pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                echo 'BuildingTest...'
                // Add build steps here
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
                // Add test steps here
            }
        }
    }
    
    post {
        success {
            updateGitHubStatus("success", "All tests passed!")
        }
        failure {
            updateGitHubStatus("failure", "Tests failed.")
        }
    }
}

def updateGitHubStatus(String status, String description) {
    githubCheck(  // githubCheck step provided by GitHub Checks Plugin
        name: 'Jenkins Build',
        detailsURL: "${env.BUILD_URL}",
        conclusion: status,
        title: 'Build Status',
        summary: description
    )
}