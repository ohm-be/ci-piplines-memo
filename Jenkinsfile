pipeline {
    agent any

    options {
        disableConcurrentBuilds()
    }

    triggers {
        // ปิด PollSCM
        // GitHub webhook จะเป็นตัว trigger
    }

    environment {
        REPO_URL = 'https://github.com/ohm-be/ci-piplines-memo.git'
    }

    stages {
        stage('Run only for Tag') {
            when {
                buildingTag()
            }
            steps {
                echo "Triggered by tag: ${env.GIT_TAG}"
            }
        }

        stage('Checkout Tag') {
            when {
                buildingTag()
            }
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: "refs/tags/${env.GIT_TAG}"]],
                    userRemoteConfigs: [[url: "${env.REPO_URL}"]]
                ])
                echo "Checked out tag: ${env.GIT_TAG}"
            }
        }

        stage('Build') {
            when {
                buildingTag()
            }
            steps {
                echo "🚀 Building code from tag: ${env.GIT_TAG}"
            }
        }
    }
}
