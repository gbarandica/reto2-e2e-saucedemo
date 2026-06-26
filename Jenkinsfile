pipeline {
    agent any

    environment {
        JAVA_HOME = 'C:\\Program Files\\Java\\jdk-21'
        PATH = "${env.JAVA_HOME}\\bin;${env.PATH}"
    }

    stages {
        stage('Ejecucion Serenity') {
            steps {
                dir('serenity-saucedemo') {
                    bat 'gradlew.bat clean test aggregate'
                }
            }
        }

        stage('Ejecucion Playwright') {
            steps {
                dir('playwright-saucedemo') {
                    bat 'python -m venv venv'
                    bat 'venv\\Scripts\\pip install -r requirements.txt'
                    bat 'venv\\Scripts\\playwright install'
                    bat 'if not exist reports mkdir reports'
                    bat 'venv\\Scripts\\behave -f behave_html_formatter:HTMLFormatter -o reports/playwright-report.html'
                }
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'serenity-saucedemo/target/site/serenity/**,playwright-saucedemo/reports/**,**/screenshots/**', allowEmptyArchive: true
        }
    }
}