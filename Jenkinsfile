@Library('ci-shared-lib') _

pipeline {
    agent any

    environment {
        IMAGE_NAME = "myregistry/myapp:${BUILD_NUMBER}"
    }

    stages {
        stage('Build') {
            steps {
                buildJavaApp()
            }
        }

        stage('Security Scan (Trivy)') {
            steps {
                sh '''
                  trivy --version
                  trivy image --severity HIGH,CRITICAL --no-progress --format table ${IMAGE_NAME} || true
                '''
                archiveArtifacts artifacts: 'trivy-report.json', fingerprint: true
            }
        }

        stage('Test') {
            steps {
                runTests()
            }
        }

        stage('Deploy') {
            steps {
                deployToK8s("dev")
            }
        }
    }
}
