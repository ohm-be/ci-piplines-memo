def call(){
    stage("Deploy to ${env}") {
        sh "kubectl apply -f k8s/${env}/deployment.yaml"
    }
}