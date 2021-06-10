def AGENT_LABEL = null
node('master') {
    stage('Set Agent Label') {
        AGENT_LABEL = "AMRIT_BUILD"
    }
}

pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/jglick/simple-maven-project-with-tests.git'

                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

           // post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                //success {
                //    junit '**/target/surefire-reports/TEST-*.xml'
                //    archiveArtifacts 'target/*.jar'
                //}

        }


    }
}

def checkout() {
    echo "Branch $env.branchName is checked out"
    checkout([$class           : 'GitSCM',
              //branches         : [[name: "origin/${env.branchName}"]],
              branches         : [[name: "origin/master"]],
              extensions       : [],
              userRemoteConfigs: [[credentialsId: '29e88c97-65a1-471b-8fbf-2f6301891ea7',
                                   url          : 'git@github.dev.global.tesco.org:stock/stock-outbound-events.git'
                                  ]]
    ])

    echo "Stage: POM_VERSION"
    def pom = readMavenPom()
    env.VERSION = pom.version[0..4]
    echo "Project version from POM : $version"
}

def build() {
    JAR_PATH = "${JAR_PATH}" + "${env.VERSION}." + "${BUILD_NUMBER}" + ".jar"
    JAR_NAME = "${MVN_ARTIFACTID}-" + "${env.VERSION}." + "${BUILD_NUMBER}" + ".jar"
    echo "${JAR_PATH} ${JAR_NAME} ${DOWNLOAD_LOCATION}"
    sh "${MAVEN_PATH} -B -V -U -e clean package -Dv=${BUILD_NUMBER}"
    echo "Build Completed"
}