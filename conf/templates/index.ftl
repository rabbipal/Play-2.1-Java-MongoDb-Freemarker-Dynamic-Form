<#-- freemarker .ftl -->
<html>
	    <head>
	        <title>Home</title>
	        <link rel="stylesheet" media="screen" href="${Router.Assets.at("stylesheets/main.css")}">
	        <link rel="shortcut icon" type="image/png" href="${Router.Assets.at("images/favicon.png")}">
	        <script src="{Router.Assets.at("javascripts/jquery-1.7.1.min.js")}" type="text/javascript"></script>
	    </head>
	    <body>
	    	<h1>Hello ${user ! 'Guest'}, this page is rendered with Freemarker</h1>


	        <hr>

        
	            <h2>${products ? size} Products</h2>

    <ul>
    <#list products as product>
        <li>${product.name}</li>
    </#list>
    </ul>
	        
	        

	    </body>
	</html>


