#!/bin/bash

mvn clean install
mvn -Dserver.port=8085 spring-boot:run

