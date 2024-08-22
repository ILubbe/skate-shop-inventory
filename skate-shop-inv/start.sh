#!/bin/bash
export JAVA_HOME=$(find /usr/lib/jvm/ -name java-17-openjdk*);
export PATH="${JAVA_HOME}/bin:${PATH}";
mvn spring-boot:run;
