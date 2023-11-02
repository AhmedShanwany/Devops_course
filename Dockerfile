FROM openjdk:19-jdk-alpine
USER root
RUN mkdir test
### Download and setup maven part
ARG MAVEN_VERSION=3.9.4
ARG USER_HOME_DIR="/root"
ARG BASE_URL=https://apache.osuosl.org/maven/maven-3/${MAVEN_VERSION}/binaries
RUN apk update --no-cache && apk add wget zip bash sed gawk curl
RUN mkdir -p /usr/share/maven /usr/share/maven/ref
RUN curl -fsSL -o /tmp/apache-maven.tar.gz ${BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
	&& tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 \
	&& rm -f /tmp/apache-maven.tar.gz \
	&& ln -s /usr/share/maven/bin/mvn /usr/bin/mvn
ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"
#Copy current directory to test file created
COPY . test/
WORKDIR test/
#linux related to make file executable and any use can execute
RUN chmod +x /test/entrypoint.sh
RUN chmod 777 /test/entrypoint.sh
RUN dos2unix /test/entrypoint.sh
#define entry point to start this shell once Docker run command is triggered
ENTRYPOINT ["/bin/sh","./entrypoint.sh"]