# iwf-java-sdk
[![Coverage Status](https://codecov.io/github/indeedeng/iwf-java-sdk/coverage.svg?branch=main)](https://app.codecov.io/gh/indeedeng/iwf-java-sdk/branch/main)
[![Build status](https://github.com/indeedeng/iwf-java-sdk/actions/workflows/ci-integ-test.yml/badge.svg?branch=main)](https://github.com/indeedeng/iwf-java-sdk/actions/workflows/ci-integ-test.yml)

Java SDK for [iWF workflow engine](https://github.com/indeedeng/iwf)

See [samples](https://github.com/indeedeng/iwf-java-samples) for how to use this SDK to build your workflow.

## Requirements

- Java 1.8+

## How to use

Here is
the [link to all the versions](https://s01.oss.sonatype.org/content/repositories/releases/io/iworkflow/iwf-java-sdk/)
available to use.
Also the [Java docs for the latest version](https://www.javadoc.io/doc/io.iworkflow/iwf-java-sdk/latest/index.html).
For the latest version, [MVN Repository](https://mvnrepository.com/artifact/io.iworkflow/iwf-java-sdk) website may have
1~2 days delay to show up.

### Gradle

```gradle
// https://mvnrepository.com/artifact/io.iworkflow/iwf-java-sdk
implementation 'io.iworkflow:iwf-java-sdk:2.1.+'
```

### Maven

```
<!-- https://mvnrepository.com/artifact/io.iworkflow/iwf-java-sdk -->
<dependency>
    <groupId>io.iworkflow</groupId>
    <artifactId>iwf-java-sdk</artifactId>
    <version>2.1.+</version>
    <type>pom</type>
</dependency>

```

## Concepts

To implement a workflow, the two most core interfaces are

* [Workflow interface](https://github.com/indeedeng/iwf-java-sdk/blob/main/src/main/java/io/iworkflow/core/ObjectWorkflow.java)
  defines the workflow definition

* [WorkflowState interface](https://github.com/indeedeng/iwf-java-sdk/blob/main/src/main/java/io/iworkflow/core/WorkflowState.java)
  defines the workflow states for workflow definitions

A workflow can contain any number of WorkflowStates.

See more in https://github.com/indeedeng/iwf#what-is-iwf

## How to build & run

### Using IntelliJ

1. Check out the idl submodule by running the command: `git submodule update --init --recursive`
2. In "Build, Execution, Deployment" -> "Gradle", choose "wrapper task in Gradle build script" for "Use gradle from".
3. Open Gradle tab, click "build" under "build" to build the project
4. In the same Gradle tab, click "bootRun" under "application to run the project"
5. Go to "script/http/local" folder, use the http script to invoke a REST API (you may need to install the HttpClient
   plugin for IntelliJ)

## Development Guide

### Update IDL

Run the command `git submodule update --remote --merge` to update IDL to the latest commit

# Development Plan

## 1.0

- [x] Start workflow API
- [x] Executing `start`/`decide` APIs and completing workflow
- [x] Parallel execution of multiple states
- [x] Timer command
- [x] Signal command
- [x] SearchAttribute
- [x] DataAttribute
- [x] StateExecutionLocal
- [x] Signal workflow API
- [x] Get workflow DataAttributes/SearchAttributes API
- [x] Get workflow API
- [x] Search workflow API
- [x] Cancel workflow API
- [x] Reset workflow API
- [x] InternalChannel command
- [x] AnyCommandCompleted Decider trigger type
- [x] More workflow start options: IdReusePolicy, cron schedule, retry
- [x] StateOption: WaitUntil/Execute API timeout and retry policy
- [x] Reset workflow by stateId/StateExecutionId

## 1.1

- [x] New search attribute types: Double, Bool, Datetime, Keyword array, Text
- [x] Workflow start options: initial search attributes

## 1.2

- [x] Skip timer API for testing/operation
- [x] Decider trigger type: any command combination

## 1.3

- [x] Support failing workflow with results
- [x] Improve workflow uncompleted error return(canceled, failed, timeout, terminated)

### 1.4

- [x] Support PROCEED_ON_FAILURE for WaitUntilApiFailurePolicy

### 2.0

- [x] Renaming some concepts/APIs with breaking changes(see releaste notes)
- [x] Support workflow RPC

### 2.1

- [x] Support caching on persistence
