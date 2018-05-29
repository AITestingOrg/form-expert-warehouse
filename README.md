# Form Expert Warehouse

[![Build Status](https://travis-ci.org/AITestingOrg/mapping-service.svg?branch=master)](https://travis-ci.org/AITestingOrg/mapping-service)

Warehouse for all instances of forms seen and labelled. Currently, only supports adding unlabelled forms, labelling forms, and GETs on labelled data.

## Features
* Query labelled forms
* Label unlabelled forms
* Create unlabelled forms

# Running the service:
To run from docker:
* Make sure that the Docker is installed and running.
* Assemble this project. Or ```./gradlew assemble``` from terminal.
* Run ```docker-compose up --build``` from the root project.
* On another terminal run ```docker ps``` to see assigned ports.

## Requirements
* Docker 17.xx.x
* JDK 10
* Kotlin
* IntelliJ 2018

## License

This project is licensed under the MIT License