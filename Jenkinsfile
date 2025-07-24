
pipeline {
    agent any

    environment {
        IMAGE_NAME = "myregistry/myapp:${BUILD_NUMBER}"
    }

    stages {
        stage('Build if Tag') {
            when {
                buildingTag()
            }
            steps {
                echo "Building for Tag: ${env.TAG_NAME}"
                // build logic here
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
    post {
        always {
            echo "Cleaning up workspace..."
            cleanWs()
        }
        failure {
            echo "Pipeline failed, consider sending Slack/Email alert"
        }
    }
}
