// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.auth.loginFormUrl = '/springSecurityOAuth2/authenticate?provider=okta'
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.objectcomputing.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.objectcomputing.UserRole'
grails.plugin.springsecurity.authority.className = 'com.objectcomputing.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/', access: ['permitAll']],
        [pattern: '/admin/**', access: ['ROLE_ADMIN']],
        [pattern: '/error', access: ['permitAll']],
        [pattern: '/index', access: ['ROLE_ADMIN']],
        [pattern: '/demo/**', access: ['permitAll']],
        [pattern: '/h2-console', access: ['permitAll']],
        [pattern: '/index.gsp', access: ['permitAll']],
        [pattern: '/shutdown', access: ['permitAll']],
        [pattern: '/assets/**', access: ['permitAll']],
        [pattern: '/**/js/**', access: ['permitAll']],
        [pattern: '/**/css/**', access: ['permitAll']],
        [pattern: '/**/images/**', access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/assets/**', filters: 'none'],
        [pattern: '/**/js/**', filters: 'none'],
        [pattern: '/**/css/**', filters: 'none'],
        [pattern: '/**/images/**', filters: 'none'],
        [pattern: '/**/favicon.ico', filters: 'none'],
        [pattern: '/**', filters: 'JOINED_FILTERS']
]


// Added by the Spring Security OAuth2 Google Plugin:
grails.plugin.springsecurity.oauth2.domainClass = 'com.objectcomputing.OAuthID'
grails.plugin.springsecurity.oauth2.active = true
grails.plugin.springsecurity.oauth2.registration.roleNames = ["ROLE_ADMIN"]
grails.plugin.springsecurity.oauth2.providers.okta.api_key = ["ROLE_ADMIN"]
grails.plugin.springsecurity.oauth2.providers.okta.api_key = '0oa4bpjgny9F3GqrG5d7'
grails.plugin.springsecurity.oauth2.providers.okta.api_secret = 'vvR19L2NG_bD-QBxIIcPPWeHnoL8WncQB6F1zy5N'
grails.plugin.springsecurity.oauth2.providers.okta.userInfoUrl = 'https://dev-18113932.okta.com/oauth2/v1/userinfo'
grails.plugin.springsecurity.oauth2.providers.okta.authorizeUrl = 'https://dev-18113932.okta.com/oauth2/v1/authorize'
grails.plugin.springsecurity.oauth2.providers.okta.tokenUrl = 'https://dev-18113932.okta.com/oauth2/v1/token'
grails.plugin.springsecurity.oauth2.providers.okta.scopes = 'email profile openid'
