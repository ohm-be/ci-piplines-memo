pipeline {
  agent any

  parameters {
    string(name: 'TAG_NAME', defaultValue: '', description: 'Git tag to build')
  }

  stages {
    stage('Build') {
      steps {
        echo "Run your build step here..."
      }
    }
  }
}




// pipeline {
// agent any
//     stages {
//         stage('Build only on tag') {
//             when {
//                 expression {
//                     return env.GIT_TAG_NAME != null && env.GIT_TAG_NAME != ''
//                 }
//             }
//             steps {
//                 echo "Running on tag: ${env.GIT_TAG_NAME}"
//                 // build commands here
//             }
//         }
//     }
//
// //     stages {
// //         stage('Build') {
// //             steps {
// //                 buildJavaApp()
// //             }
// //         }
// //
// //         stage('Security Scan (Trivy)') {
// //             steps {
// //                 sh '''
// //                   trivy --version
// //                   trivy image --severity HIGH,CRITICAL --no-progress --format table ${IMAGE_NAME} || true
// //                 '''
// //                 archiveArtifacts artifacts: 'trivy-report.json', fingerprint: true
// //             }
// //         }
// //
// //         stage('Test') {
// //             steps {
// //                 runTests()
// //             }
// //         }
// //
// //         stage('Deploy') {
// //             steps {
// //                 deployToK8s("dev")
// //             }
// //         }
// //     }
// //     post {
// //         always {
// //             echo "Cleaning up workspace..."
// //             cleanWs()
// //         }
// //         failure {
// //             echo "Pipeline failed, consider sending Slack/Email alert"
// //         }
// //     }
// }

