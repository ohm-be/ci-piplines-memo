
pipeline {
    agent any
        triggers {
            githubPush() // Responds to webhook push and tag events
        }
        options {
            skipDefaultCheckout()
        }
        stages {
            stage('Checkout') {
                steps {
                    checkout scm
                }
            }
            stage('Build') {
                when {
                    expression {
                        return env.GIT_TAG_NAME != null
                    }
                }
                steps {
                    echo "Building tag: ${env.GIT_TAG_NAME}"
                    // Your build steps
                }
            }
        }
        environment {
            GIT_TAG_NAME = sh(script: "git describe --tags", returnStdout: true).trim()
        }

//     stages {
//         stage('Build') {
//             steps {
//                 buildJavaApp()
//             }
//         }
//
//         stage('Security Scan (Trivy)') {
//             steps {
//                 sh '''
//                   trivy --version
//                   trivy image --severity HIGH,CRITICAL --no-progress --format table ${IMAGE_NAME} || true
//                 '''
//                 archiveArtifacts artifacts: 'trivy-report.json', fingerprint: true
//             }
//         }
//
//         stage('Test') {
//             steps {
//                 runTests()
//             }
//         }
//
//         stage('Deploy') {
//             steps {
//                 deployToK8s("dev")
//             }
//         }
//     }
//     post {
//         always {
//             echo "Cleaning up workspace..."
//             cleanWs()
//         }
//         failure {
//             echo "Pipeline failed, consider sending Slack/Email alert"
//         }
//     }
}
