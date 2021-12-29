pipeline {
    agent any

    tools {
        maven "MAVEN"
        jdk "JDK"
    }
      stage('Build') {
            steps {
                dir("C:\ProgramData\Jenkins\.jenkins\workspace\New_demo\my-app\") {
                sh 'mvn -B -DskipTests clean package'
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