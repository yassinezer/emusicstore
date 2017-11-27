Jenkinsfile (Declarative Pipeline)
pipeline {
    agent any
    stages {
        stage('deploy') {
            steps {
                bat 'mvn jetty:run'
            }
        }
    }
}
