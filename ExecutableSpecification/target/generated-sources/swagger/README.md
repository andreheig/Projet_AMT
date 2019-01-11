# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import ch.heigvd.gamification.*;
import ch.heigvd.gamification.auth.*;
import ch.heigvd.gamification.model.*;
import ch.heigvd.gamification.api.DefaultApi;

import java.io.File;
import java.util.*;

public class DefaultApiExample {

    public static void main(String[] args) {
        
        DefaultApi apiInstance = new DefaultApi();
        Credentials body = new Credentials(); // Credentials | The info required to authenticate an application
        try {
            Token result = apiInstance.authenticateApplicationAndGetToken(body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#authenticateApplicationAndGetToken");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://localhost:8090/api*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DefaultApi* | [**authenticateApplicationAndGetToken**](docs/DefaultApi.md#authenticateApplicationAndGetToken) | **POST** /auth | 
*DefaultApi* | [**findApplicationBadges**](docs/DefaultApi.md#findApplicationBadges) | **GET** /badges/{uuid} | 
*DefaultApi* | [**findApplicationRules**](docs/DefaultApi.md#findApplicationRules) | **GET** /rules/{uuid} | 
*DefaultApi* | [**findApplicationScales**](docs/DefaultApi.md#findApplicationScales) | **GET** /scales/{uuid} | 
*DefaultApi* | [**findUserById**](docs/DefaultApi.md#findUserById) | **GET** /users/{id} | 
*DefaultApi* | [**getAllApplications**](docs/DefaultApi.md#getAllApplications) | **GET** /applications | 
*DefaultApi* | [**postApplication**](docs/DefaultApi.md#postApplication) | **POST** /applications | 
*DefaultApi* | [**postBadge**](docs/DefaultApi.md#postBadge) | **POST** /badges/{uuid} | 
*DefaultApi* | [**postRule**](docs/DefaultApi.md#postRule) | **POST** /rules/{uuid} | 
*DefaultApi* | [**postScale**](docs/DefaultApi.md#postScale) | **POST** /scales/{uuid} | 
*DefaultApi* | [**reportEvent**](docs/DefaultApi.md#reportEvent) | **POST** /events | 
*DefaultApi* | [**updateApplication**](docs/DefaultApi.md#updateApplication) | **PUT** /applications | 
*DefaultApi* | [**updateBadge**](docs/DefaultApi.md#updateBadge) | **PUT** /badges/{uuid} | 
*DefaultApi* | [**updateRule**](docs/DefaultApi.md#updateRule) | **PUT** /rules/{uuid} | 
*DefaultApi* | [**updateScale**](docs/DefaultApi.md#updateScale) | **PUT** /scales/{uuid} | 


## Documentation for Models

 - [ApplicationRegistration](docs/ApplicationRegistration.md)
 - [ApplicationSummary](docs/ApplicationSummary.md)
 - [ApplicationUpdate](docs/ApplicationUpdate.md)
 - [ApplicationsBadgesSummary](docs/ApplicationsBadgesSummary.md)
 - [ApplicationsRulesSummary](docs/ApplicationsRulesSummary.md)
 - [ApplicationsScalesSummary](docs/ApplicationsScalesSummary.md)
 - [Credentials](docs/Credentials.md)
 - [Event](docs/Event.md)
 - [RegistrationBadge](docs/RegistrationBadge.md)
 - [RegistrationRule](docs/RegistrationRule.md)
 - [RegistrationScale](docs/RegistrationScale.md)
 - [Token](docs/Token.md)
 - [UpdateBadge](docs/UpdateBadge.md)
 - [UpdateRule](docs/UpdateRule.md)
 - [UpdateScale](docs/UpdateScale.md)
 - [User](docs/User.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issue.

## Author



