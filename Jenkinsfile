pipeline {
   agent any

   tools {
      // Install the Maven version configured as "M3" and add it to the path.
      maven "3.8.6"
      jdk "java"
   }
    triggers {
        cron('0 1 * * *')
    }
    parameters {
        choice(choices: ['chrome', 'firefox', 'safari', 'opera'], name: 'browser')
        choice(choices: ['src/test/resources/testng-smoke.xml', 'src/test/resources/testng-regression.xml'], name: 'surefire')
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH'
        booleanParam(defaultValue: true, description: 'Headless mode', name: 'HEADLESS')
        string(name: 'DEPLOY_ENV', defaultValue: 'staging', description: '')
    }

   stages {
      stage('Testing') {
         steps {
            // Get some code from a GitHub repository
            git branch: "${params.BRANCH}", url: 'https://github.com/stardust-nebula/hw2_6_saucedemo.git'

            // Run Maven on a Unix agent.
//             sh "mvn -Dmaven.test.failure.ignore=true -Dbrowser=${browser} -Dsurefire.suiteXmlFiles=${surefire} clean test"

            // To run Maven on a Windows agent, use
            bat "mvn -Dmaven.test.failure.ignore=true -Dbrowser=${browser} -Dsurefire.suiteXmlFiles=${surefire} clean test"
         }

         post {
            // If Maven was able to run the tests, even if some of the test
            // failed, record the test results and archive the jar file.
            success {
               junit '**/target/surefire-reports/TEST-*.xml'
            }
         }
      }
      stage('Reporting') {
         steps {
             script {
                     allure([
                             includeProperties: false,
                             jdk: '',
                             properties: [],
                             reportBuildPolicy: 'ALWAYS',
                             results: [[path: 'target/allure-results']]
                     ])
             }
         }
        }
   }
}
