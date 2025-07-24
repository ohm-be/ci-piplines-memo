
pipeline {
    agent any

    stages {
            stage('Build for Tag') {
                when {
                    buildingTag()
                }
                steps {
                    echo "Building tag ${env.GIT_BRANCH} or ${env.TAG_NAME} ..."
                    // build steps
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
