pipeline{
    agent any
    tools{
        gradle 'Gradle'
    }
    environment{
        DOCKERHUB_CREDS = credentials("dockerHub-creds")
    }
    stages{
        stage('Build java project'){
            steps{
                checkout scmGit(branches: [[name: '*/jenkins']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/II-AmiFooL-II/SpringBoot-Crud-Example']])
                bat "gradle build"
            }
        }
        stage("building docker image"){
            steps{
                //bat "@FOR /f "tokens=*" %i IN ('minikube -p minikube docker-env --shell cmd') DO @%i"
                //bat "kubectl get all"
                bat "docker build -t %DOCKERHUB_CREDS_USR%/restapiexample ."
            }
        }
        stage("pushing image to Docker Hub"){
            steps{
                bat "docker login -u %DOCKERHUB_CREDS_USR% -p %DOCKERHUB_CREDS_PSW%"
                bat "docker push %DOCKERHUB_CREDS_USR%/restapiexample"

            }
        }
        stage("deploying in minikube"){
            steps{
                bat "minikube version"
                withCredentials([string(credentialsId: 'minikube-config-path', variable: 'minikube-config-path')]) {
                    bat "kubectl --kubeconfig=%minikube-config-path% apply -f kube/deployment.yml"
                    bat "kubectl --kubeconfig=%minikube-config-path% apply -f kube/mongo.yml"
                    bat "kubectl --kubeconfig=%minikube-config-path% apply -f kube/ingress.yml"
                }
            }
        }
    }
}