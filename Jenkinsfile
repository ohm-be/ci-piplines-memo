
pipeline {
    agent any

    stages {
            stage('Build Only on Tag Creation') {
                when {
                    expression {
                        return env.GIT_BRANCH?.startsWith('refs/tags/')
                    }
                }
                steps {
                    echo "Building for tag: ${env.GIT_BRANCH}"
                }
            }
            stage('Skip Non Tag') {
                when {
                    expression {
                        return !env.GIT_BRANCH?.startsWith('refs/tags/')
                    }
                }
                steps {
                    echo "Not a tag creation event, skipping build."
                }
            }
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
