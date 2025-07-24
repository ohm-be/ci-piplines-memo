
pipeline {
    agent any

    stages {
            stage('Build if Tag') {
                when {
                    buildingTag()
                }
                steps {
                    echo "Building for Git Tag: ${env.TAG_NAME}"
                    // Add your build steps here
                }
            }

            stage('Skip for non-tag') {
                when {
                    not {
                        buildingTag()
                    }
                }
                steps {
                    echo "This is not a tag build. Skipping build....."
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
