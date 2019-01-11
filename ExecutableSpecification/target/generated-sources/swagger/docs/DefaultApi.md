# DefaultApi

All URIs are relative to *http://localhost:8090/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**authenticateApplicationAndGetToken**](DefaultApi.md#authenticateApplicationAndGetToken) | **POST** /auth | 
[**findApplicationBadges**](DefaultApi.md#findApplicationBadges) | **GET** /badges/{uuid} | 
[**findApplicationRules**](DefaultApi.md#findApplicationRules) | **GET** /rules/{uuid} | 
[**findApplicationScales**](DefaultApi.md#findApplicationScales) | **GET** /scales/{uuid} | 
[**findUserById**](DefaultApi.md#findUserById) | **GET** /users/{id} | 
[**getAllApplications**](DefaultApi.md#getAllApplications) | **GET** /applications | 
[**postApplication**](DefaultApi.md#postApplication) | **POST** /applications | 
[**postBadge**](DefaultApi.md#postBadge) | **POST** /badges/{uuid} | 
[**postRule**](DefaultApi.md#postRule) | **POST** /rules/{uuid} | 
[**postScale**](DefaultApi.md#postScale) | **POST** /scales/{uuid} | 
[**reportEvent**](DefaultApi.md#reportEvent) | **POST** /events | 
[**updateApplication**](DefaultApi.md#updateApplication) | **PUT** /applications | 
[**updateBadge**](DefaultApi.md#updateBadge) | **PUT** /badges/{uuid} | 
[**updateRule**](DefaultApi.md#updateRule) | **PUT** /rules/{uuid} | 
[**updateScale**](DefaultApi.md#updateScale) | **PUT** /scales/{uuid} | 


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

<a name="findApplicationBadges"></a>
# **findApplicationBadges**
> List&lt;ApplicationsBadgesSummary&gt; findApplicationBadges(uuid)



Retrieve badges by application uuid

### Example
```java
// Import classes:
//import ch.heigvd.gamification.ApiException;
//import ch.heigvd.gamification.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | uuid de l'application à trouver
try {
    List<ApplicationsBadgesSummary> result = apiInstance.findApplicationBadges(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#findApplicationBadges");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| uuid de l&#39;application à trouver |

### Return type

[**List&lt;ApplicationsBadgesSummary&gt;**](ApplicationsBadgesSummary.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="findApplicationRules"></a>
# **findApplicationRules**
> List&lt;ApplicationsRulesSummary&gt; findApplicationRules(uuid)



Retrieve rules by application uuid

### Example
```java
// Import classes:
//import ch.heigvd.gamification.ApiException;
//import ch.heigvd.gamification.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | uuid de l'application à trouver
try {
    List<ApplicationsRulesSummary> result = apiInstance.findApplicationRules(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#findApplicationRules");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| uuid de l&#39;application à trouver |

### Return type

[**List&lt;ApplicationsRulesSummary&gt;**](ApplicationsRulesSummary.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="findApplicationScales"></a>
# **findApplicationScales**
> List&lt;ApplicationsScalesSummary&gt; findApplicationScales(uuid)



Retrieve scale by application uuid

### Example
```java
// Import classes:
//import ch.heigvd.gamification.ApiException;
//import ch.heigvd.gamification.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | uuid de l'application à trouver
try {
    List<ApplicationsScalesSummary> result = apiInstance.findApplicationScales(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#findApplicationScales");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| uuid de l&#39;application à trouver |

### Return type

[**List&lt;ApplicationsScalesSummary&gt;**](ApplicationsScalesSummary.md)

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

<a name="getAllApplications"></a>
# **getAllApplications**
> List&lt;ApplicationSummary&gt; getAllApplications()



retrieve all applications

### Example
```java
// Import classes:
//import ch.heigvd.gamification.ApiException;
//import ch.heigvd.gamification.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    List<ApplicationSummary> result = apiInstance.getAllApplications();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getAllApplications");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;ApplicationSummary&gt;**](ApplicationSummary.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="postApplication"></a>
# **postApplication**
> postApplication(body)



register a new application

### Example
```java
// Import classes:
//import ch.heigvd.gamification.ApiException;
//import ch.heigvd.gamification.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
ApplicationRegistration body = new ApplicationRegistration(); // ApplicationRegistration | The info required to register an application
try {
    apiInstance.postApplication(body);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#postApplication");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ApplicationRegistration**](ApplicationRegistration.md)| The info required to register an application |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="postBadge"></a>
# **postBadge**
> postBadge(uuid, body)



add new badge

### Example
```java
// Import classes:
//import ch.heigvd.gamification.ApiException;
//import ch.heigvd.gamification.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | uuid of the application to fetch
RegistrationBadge body = new RegistrationBadge(); // RegistrationBadge | The info required to register an application's badge
try {
    apiInstance.postBadge(uuid, body);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#postBadge");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| uuid of the application to fetch |
 **body** | [**RegistrationBadge**](RegistrationBadge.md)| The info required to register an application&#39;s badge |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="postRule"></a>
# **postRule**
> postRule(uuid, body)



add new rule

### Example
```java
// Import classes:
//import ch.heigvd.gamification.ApiException;
//import ch.heigvd.gamification.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | uuid of the application to add rule
RegistrationRule body = new RegistrationRule(); // RegistrationRule | The rule for an application's badges
try {
    apiInstance.postRule(uuid, body);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#postRule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| uuid of the application to add rule |
 **body** | [**RegistrationRule**](RegistrationRule.md)| The rule for an application&#39;s badges |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="postScale"></a>
# **postScale**
> postScale(uuid, body)



add new scale

### Example
```java
// Import classes:
//import ch.heigvd.gamification.ApiException;
//import ch.heigvd.gamification.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | uuid of the application to fetch
RegistrationScale body = new RegistrationScale(); // RegistrationScale | The info required to register an application's badges
try {
    apiInstance.postScale(uuid, body);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#postScale");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| uuid of the application to fetch |
 **body** | [**RegistrationScale**](RegistrationScale.md)| The info required to register an application&#39;s badges |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="reportEvent"></a>
# **reportEvent**
> Event reportEvent(event)



Report that a new event has happened in the gamified application

### Example
```java
// Import classes:
//import ch.heigvd.gamification.ApiException;
//import ch.heigvd.gamification.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
Event event = new Event(); // Event | The event that occured in the realm of the gamified application
try {
    Event result = apiInstance.reportEvent(event);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#reportEvent");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **event** | [**Event**](Event.md)| The event that occured in the realm of the gamified application |

### Return type

[**Event**](Event.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="updateApplication"></a>
# **updateApplication**
> updateApplication(body)



update an existing application

### Example
```java
// Import classes:
//import ch.heigvd.gamification.ApiException;
//import ch.heigvd.gamification.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
ApplicationUpdate body = new ApplicationUpdate(); // ApplicationUpdate | The info required to update an application
try {
    apiInstance.updateApplication(body);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateApplication");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ApplicationUpdate**](ApplicationUpdate.md)| The info required to update an application |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="updateBadge"></a>
# **updateBadge**
> updateBadge(uuid, body)



update a badge

### Example
```java
// Import classes:
//import ch.heigvd.gamification.ApiException;
//import ch.heigvd.gamification.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | uuid of the application to fetch
UpdateBadge body = new UpdateBadge(); // UpdateBadge | The info required to update an application's badge
try {
    apiInstance.updateBadge(uuid, body);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateBadge");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| uuid of the application to fetch |
 **body** | [**UpdateBadge**](UpdateBadge.md)| The info required to update an application&#39;s badge |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="updateRule"></a>
# **updateRule**
> updateRule(uuid, body)



update a rule

### Example
```java
// Import classes:
//import ch.heigvd.gamification.ApiException;
//import ch.heigvd.gamification.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | uuid of the application to update rule
UpdateRule body = new UpdateRule(); // UpdateRule | The rule for an application's badges
try {
    apiInstance.updateRule(uuid, body);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateRule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| uuid of the application to update rule |
 **body** | [**UpdateRule**](UpdateRule.md)| The rule for an application&#39;s badges |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="updateScale"></a>
# **updateScale**
> updateScale(uuid, body)



update scale

### Example
```java
// Import classes:
//import ch.heigvd.gamification.ApiException;
//import ch.heigvd.gamification.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | uuid of the application to fetch
UpdateScale body = new UpdateScale(); // UpdateScale | The info required to update an application's badges
try {
    apiInstance.updateScale(uuid, body);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateScale");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| uuid of the application to fetch |
 **body** | [**UpdateScale**](UpdateScale.md)| The info required to update an application&#39;s badges |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

