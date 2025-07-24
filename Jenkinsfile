
pipeline {
    agent any

    options {
        disableConcurrentBuilds()
    }
    triggers {
        pollSCM('') // ปิด polling
    }

    parameters {
        string(name: 'TAG_NAME', defaultValue: '', description: 'Git tag to build')
    }
    stages {
            stage('Validate Tag') {
                when {
                    expression { params.TAG_NAME?.trim() != '' }
                }
                steps {
                    echo "Tag to build: ${params.TAG_NAME}"
                }
            }
            stage('Checkout Tag') {
                steps {
                    checkout([
                        $class: 'GitSCM',
                        branches: [[name: "refs/tags/${params.TAG_NAME}"]],
                        userRemoteConfigs: [[url: 'https://github.com/your-org/your-repo.git']]
                    ])
                    echo "Checked out tag ${params.TAG_NAME}"
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
