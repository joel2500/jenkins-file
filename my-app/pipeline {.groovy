pipeline {
    agent any

    tools {
        maven "MAVEN"
        jdk "JDK"
    }

    stages{
        stage('Bulid'){

            steps{
                dir("C:\ProgramData\Jenkins\.jenkins\workspace\New-demo\my-app"){
                
                sh 'mvn -B -DskipTests clean package'
                }
            }

        }
    }
    post {
        always {
            junit(
                 allowEmptyResults: true,
                 testResults: '*/test-reports/.xml'
            )
        }
    }
}