# DefaultApi

All URIs are relative to *http://localhost:8090/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**authenticateApplicationAndGetToken**](DefaultApi.md#authenticateApplicationAndGetToken) | **POST** /auth | 
[**findApplicationBadgesByUuid**](DefaultApi.md#findApplicationBadgesByUuid) | **GET** /badges/{uuid} | 
[**findUserById**](DefaultApi.md#findUserById) | **GET** /users/{id} | 
[**postBadge**](DefaultApi.md#postBadge) | **POST** /badges/{uuid} | 
[**postRule**](DefaultApi.md#postRule) | **POST** /rules/{uuid} | 
[**registrationsGet**](DefaultApi.md#registrationsGet) | **GET** /registrations | 
[**registrationsPost**](DefaultApi.md#registrationsPost) | **POST** /registrations | 
[**reportEvent**](DefaultApi.md#reportEvent) | **POST** /events | 


<a name="authenticateApplicationAndGetToken"></a>
# **authenticateApplicationAndGetToken**
> Token authenticateApplicationAndGetToken(body)



### Example
```java
// Import classes:
//import ch.heigvd.gamification.ApiException;
//import ch.heigvd.gamification.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
Credentials body = new Credentials(); // Credentials | The info required to authenticate an application
try {
    Token result = apiInstance.authenticateApplicationAndGetToken(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#authenticateApplicationAndGetToken");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Credentials**](Credentials.md)| The info required to authenticate an application |

### Return type

[**Token**](Token.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="findApplicationBadgesByUuid"></a>
# **findApplicationBadgesByUuid**
> List&lt;ApplicationsBadgesSummary&gt; findApplicationBadgesByUuid(idApplication, uuid)



Retrieve one application by uuid

### Example
```java
// Import classes:
//import ch.heigvd.gamification.ApiException;
//import ch.heigvd.gamification.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String idApplication = "idApplication_example"; // String | uuid identifiant l'application
String uuid = "uuid_example"; // String | uuid of the application to fetch
try {
    List<ApplicationsBadgesSummary> result = apiInstance.findApplicationBadgesByUuid(idApplication, uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#findApplicationBadgesByUuid");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idApplication** | **String**| uuid identifiant l&#39;application |
 **uuid** | **String**| uuid of the application to fetch |

### Return type

[**List&lt;ApplicationsBadgesSummary&gt;**](ApplicationsBadgesSummary.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="findUserById"></a>
# **findUserById**
> User findUserById(xGamificationToken, id)



Retrieve one user by id

### Example
```java
// Import classes:
//import ch.heigvd.gamification.ApiException;
//import ch.heigvd.gamification.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String xGamificationToken = "xGamificationToken_example"; // String | token that identifies the application sending the request
String id = "id_example"; // String | id of the user to fetch
try {
    User result = apiInstance.findUserById(xGamificationToken, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#findUserById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **xGamificationToken** | **String**| token that identifies the application sending the request |
 **id** | **String**| id of the user to fetch |

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="postBadge"></a>
# **postBadge**
> postBadge(idApplication, uuid, body)



add new badges

### Example
```java
// Import classes:
//import ch.heigvd.gamification.ApiException;
//import ch.heigvd.gamification.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String idApplication = "idApplication_example"; // String | uuid identifiant l'application
String uuid = "uuid_example"; // String | uuid of the application to fetch
RegistrationBadges body = new RegistrationBadges(); // RegistrationBadges | The info required to register an application's badges
try {
    apiInstance.postBadge(idApplication, uuid, body);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#postBadge");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idApplication** | **String**| uuid identifiant l&#39;application |
 **uuid** | **String**| uuid of the application to fetch |
 **body** | [**RegistrationBadges**](RegistrationBadges.md)| The info required to register an application&#39;s badges |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="postRule"></a>
# **postRule**
> postRule(idApplication, uuid, body)



add new rule

### Example
```java
// Import classes:
//import ch.heigvd.gamification.ApiException;
//import ch.heigvd.gamification.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String idApplication = "idApplication_example"; // String | uuid identifiant l'application
String uuid = "uuid_example"; // String | uuid of the application to add rule
RegistrationRule body = new RegistrationRule(); // RegistrationRule | The rule for an application's badges
try {
    apiInstance.postRule(idApplication, uuid, body);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#postRule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idApplication** | **String**| uuid identifiant l&#39;application |
 **uuid** | **String**| uuid of the application to add rule |
 **body** | [**RegistrationRule**](RegistrationRule.md)| The rule for an application&#39;s badges |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="registrationsGet"></a>
# **registrationsGet**
> List&lt;RegistrationSummary&gt; registrationsGet()



### Example
```java
// Import classes:
//import ch.heigvd.gamification.ApiException;
//import ch.heigvd.gamification.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    List<RegistrationSummary> result = apiInstance.registrationsGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#registrationsGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;RegistrationSummary&gt;**](RegistrationSummary.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="registrationsPost"></a>
# **registrationsPost**
> registrationsPost(body)



### Example
```java
// Import classes:
//import ch.heigvd.gamification.ApiException;
//import ch.heigvd.gamification.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
Registration body = new Registration(); // Registration | The info required to register an application
try {
    apiInstance.registrationsPost(body);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#registrationsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Registration**](Registration.md)| The info required to register an application |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="reportEvent"></a>
# **reportEvent**
> Event reportEvent(xGamificationToken, event)



Report that a new event has happened in the gamified application

### Example
```java
// Import classes:
//import ch.heigvd.gamification.ApiException;
//import ch.heigvd.gamification.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String xGamificationToken = "xGamificationToken_example"; // String | token that identifies the application sending the request
Event event = new Event(); // Event | The event that occured in the realm of the gamified application
try {
    Event result = apiInstance.reportEvent(xGamificationToken, event);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#reportEvent");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **xGamificationToken** | **String**| token that identifies the application sending the request |
 **event** | [**Event**](Event.md)| The event that occured in the realm of the gamified application |

### Return type

[**Event**](Event.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

