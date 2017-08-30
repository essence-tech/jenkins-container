FROM jenkins/jenkins:lts
MAINTAINER 2Sixty
ENV REFRESHED_AT 2017-08-24

USER root
RUN apt-get -qqy update; apt-get install -qqy sudo
RUN echo "jenkins ALL=NOPASSWD: ALL" >> /etc/sudoers

USER jenkins

# add all the plugins we need
COPY plugins.txt /usr/share/jenkins/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/plugins.txt

# add the seed jobs
COPY jobs-generator.xml /usr/share/jenkins/ref/jobs/jobs-generator/config.xml
