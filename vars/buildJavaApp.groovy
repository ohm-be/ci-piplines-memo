import memo.ci_cd.Docker

def call() {
    def docker = new Docker(this)
    docker.buildAndPush("myregistry/myapp:latest")
}
