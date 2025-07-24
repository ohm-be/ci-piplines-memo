def call(){
    stage('Run Tests') {
        sh 'mvn test'
    }
}