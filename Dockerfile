FROM jenkins/jenkins:lts
ENV JAVA_OPTS="-Xmx256m -Djenkins.install.runSetupWizard=false"
COPY jobs /usr/share/jenkins/ref/jobs
COPY init.groovy.d /usr/share/jenkins/ref/init.groovy.d