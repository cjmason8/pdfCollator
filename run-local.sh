#!/bin/bash

mvn clean install
mvn -Dserver.port=8083 spring-boot:run

