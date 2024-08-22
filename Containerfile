FROM  docker.io/redhat/ubi8-minimal:latest

COPY skate-shop-inv/ /skate-shop-inv/

WORKDIR /skate-shop-inv

RUN   microdnf install -y \
        java-17-openjdk \
        maven && \
      export JAVA_HOME=$(find /usr/lib/jvm/ -name java-17-openjdk*) && \
      export PATH="$JAVA_HOME/bin:$PATH" && \
      mvn clean install;

EXPOSE 8080

ENTRYPOINT ["/bin/bash", "./start.sh"]
