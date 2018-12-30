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
*DefaultApi* | [**findApplicationBadgesByUuid**](docs/DefaultApi.md#findApplicationBadgesByUuid) | **GET** /badges/{uuid} | 
*DefaultApi* | [**findUserById**](docs/DefaultApi.md#findUserById) | **GET** /users/{id} | 
*DefaultApi* | [**postBadge**](docs/DefaultApi.md#postBadge) | **POST** /badges/{uuid} | 
*DefaultApi* | [**postRule**](docs/DefaultApi.md#postRule) | **POST** /rules/{uuid} | 
*DefaultApi* | [**registrationsGet**](docs/DefaultApi.md#registrationsGet) | **GET** /registrations | 
*DefaultApi* | [**registrationsPost**](docs/DefaultApi.md#registrationsPost) | **POST** /registrations | 
*DefaultApi* | [**reportEvent**](docs/DefaultApi.md#reportEvent) | **POST** /events | 


## Documentation for Models

 - [ApplicationsBadgesSummary](docs/ApplicationsBadgesSummary.md)
 - [Credentials](docs/Credentials.md)
 - [Event](docs/Event.md)
 - [Registration](docs/Registration.md)
 - [RegistrationBadges](docs/RegistrationBadges.md)
 - [RegistrationRule](docs/RegistrationRule.md)
 - [RegistrationSummary](docs/RegistrationSummary.md)
 - [Token](docs/Token.md)
 - [User](docs/User.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issue.

## Author



