# Grails 5 and Okta Integration

This is an example Grails 5 application which uses [Grails Spring Security OAuth2](https://github.com/grails/grails-spring-security-oauth2[Grails) plugin and an inline Grails 5 plugin implementation for the provider Okta.

In order to run the application you would need to Create a Free Okta Developer Account. If you don't have one, [create an Okta Developer account](https://developer.okta.com/signup/). After you've completed the setup process, log in to your account. After you've completed the setup process, log in to your account.

* Click on **Applications > Add Application**
* Select **Web** and click **Next**

Fill in the following options in the form:

* Name: okta_demo
* Base URIs: http://localhost:8080
* Login redirect URLs: http://localhost:8080/login/oauth2/code/okta
* Grant Type allowed:
  * Client Credentials
  * Authorization Code
* Click Done.

Configure following ENV variables:

* export OKTA_CLIENT_ID=<your_app_client_id>
* export OKTA_CLIENT_SECRET=<your_app_client_id>
* export OKTA_CLIENT_SUBDOMAIN+<your_client_subdomain>

You will find {CLIENT_ID} and {CLIENT_SECRET} in the application's page from the Okta dashboard.

## Run Application

* Execute the following command from terminal or command line.

```bash
./gradlew :bootRun -x :spring-security-oauth2-okta:bootRun
```
