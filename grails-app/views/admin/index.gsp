<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Admin Portal</title>
</head>

<body>

<content tag="nav">
    <li>
        <sec:ifLoggedIn>
            <form action='${request.contextPath}/logout' method='POST'>
                <input type='submit' value="Logout"/>
            </form>
        </sec:ifLoggedIn>
    </li>
</content>

<div class="svg" role="presentation">
    <div class="grails-logo-container">
        <asset:image src="grails-cupsonly-logo-white.svg" class="grails-logo"/>
    </div>
</div>

<div id="content" role="main">
    <div class="container">
        <section class="row colset-2-its">
            <h1>Welcome, <sec:username/></h1>

            <p>
                Congratulations, you have successfully authenticated via Okta OAuth. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum urna nisl, feugiat ut erat eget, vestibulum vehicula orci. Nam maximus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum urna nisl, feugiat ut erat eget, vestibulum vehicula orci. Nam maximus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum urna nisl, feugiat ut erat eget, vestibulum vehicula orci. Nam maximus.
            </p>

            <div id="controllers" role="navigation">
                <h2>Available Controllers:</h2>
                <ul>
                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                        <li class="controller">
                            <g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link>
                        </li>
                    </g:each>
                </ul>
            </div>
        </section>
    </div>
</div>
</body>
</html>