package memo.ci_cd

class Docker implements Serializable {
    def steps

    Docker(steps) {
        this.steps = steps
    }

    def buildAndPush(imageName) {
        steps.sh "docker build -t ${imageName} ."
        steps.sh "docker push ${imageName}"
    }
}