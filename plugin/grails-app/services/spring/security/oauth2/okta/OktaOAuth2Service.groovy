package spring.security.oauth2.okta

import com.github.scribejava.core.builder.api.DefaultApi20
import com.github.scribejava.core.model.OAuth2AccessToken
import com.github.scribejava.core.model.OAuthRequest
import com.github.scribejava.core.model.Response
import com.github.scribejava.core.model.Verb
import grails.converters.JSON
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.oauth2.exception.OAuth2Exception
import grails.plugin.springsecurity.oauth2.service.OAuth2AbstractProviderService
import grails.plugin.springsecurity.oauth2.token.OAuth2SpringToken
import grails.util.Holders
import groovy.util.logging.Slf4j

@Transactional
@Slf4j
class OktaOAuth2Service extends OAuth2AbstractProviderService {

    String userInfoUrl

    OktaOAuth2Service() {
        this.userInfoUrl = Holders.grailsApplication.config.getProperty('grails.plugin.springsecurity.oauth2.providers.okta.userInfoUrl', String.class)
        log.info "Okta userInfoUrl = " + this.userInfoUrl

        if (!this.userInfoUrl || this.userInfoUrl == null) {
            throw new MissingPropertyException("Please define userInfoUrl for Okta OAuth2 ('grails.plugin.springsecurity.oauth2.providers.okta.userInfoUrl')");
        }
    }

    String getProviderID() {
        'okta'
    }

    Class<? extends DefaultApi20> getApiClass() {
        OktaApi.class
    }

    String getProfileScope() {
        this.userInfoUrl
    }

    String getScopes() {
        'openid profile email'
    }

    String getScopeSeparator() {
        ' '
    }

    @Override
    Response getResponse(OAuth2AccessToken accessToken) {
        OAuthRequest oAuthRequest = new OAuthRequest(Verb.POST, getProfileScope())
        String header =  "Bearer " + accessToken.getAccessToken()
        oAuthRequest.addHeader("Authorization",  header);
        authService.execute(oAuthRequest)
    }

    @Override
    OAuth2SpringToken createSpringAuthToken(OAuth2AccessToken accessToken) {
        def user
        def response = getResponse(accessToken)
        try {
            log.debug("JSON response body: {}", accessToken.rawResponse)
            String responseBody = response.getBody();
            user = JSON.parse(responseBody)
        }
        catch (Exception e) {
            log.error("Error parsing response from {}. Response:\n{}", providerID, response.body)
            throw new OAuth2Exception("Error parsing response from " + providerID, e)
        }

        if (user && !user['email']) {
            log.error("No user email from {}. Response was:\n{}", providerID, response.body)
            throw new OAuth2Exception("No user id from " + providerID)
        }

        new OktaOauth2SpringToken(accessToken, (String) user['email'], providerID)

    }
}
