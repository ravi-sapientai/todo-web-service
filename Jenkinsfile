pipeline {
    agent any

    triggers {
        pollSCM('*/5 * * * *')
    }

    stages {
        stage('Compile & Unit Tests') {
            steps {
                gradlew('clean', 'test')
            }
            post {
                always {
                    junit '**/build/test-results/test/TEST-*.xml'
                }
            }
        }
        stage('Integration Tests') {
            steps {
                gradlew('integrationTest')
            }
            post {
                always {
                    junit '**/build/test-results/integrationTest/TEST-*.xml'
                }
            }
        }
        stage('Assembly') {
            steps {
                gradlew('assemble')
                stash includes: '**/build/libs/*.jar', name: 'app'
            }
        }
        stage('Build Image') {
            steps {
                gradlew('dockerBuildImage')
            }
        }
        stage('Functional Tests') {
            steps {
                gradlew('functionalTest')
            }
            post {
                always {
                    junit '**/build/test-results/functionalTest/TEST-*.xml'
                }
            }
        }
        stage('Push Image') {
            environment {
                DOCKER_USERNAME = "${env.DOCKER_USERNAME}"
                DOCKER_PASSWORD = credentials('DOCKER_PASSWORD')
                DOCKER_EMAIL = "${env.DOCKER_EMAIL}"
            }
            steps {
                gradlew('dockerPushImage')
            }
        }
        stage('Deploy to Production') {
            steps {
                timeout(time: 1, unit:'DAYS') {
                    input 'Deploy to Production?'
                }
                sshagent(credentials: ['ee8346e0-a000-4496-88aa-49977fd97154']) {
                    sh "ssh -o StrictHostKeyChecking=no -l ${env.DOCKER_SWARM_MANAGER_USERNAME} ${env.DOCKER_SWARM_MANAGER_IP} docker service update --image bmuschko/todo-web-service:latest todo-web-service"
                }
            }
        }
    }
    post {
        failure {
            mail to: 'benjamin.muschko@gmail.com', subject: 'Build failed', body: 'Please fix!'
        }
    }
}

def gradlew(String... args) {
    sh "./gradlew ${args.join(' ')} -s"
}