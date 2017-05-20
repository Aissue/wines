<!DOCTYPE html>
<html lang="en" class="no-js">
    <head>
        <meta charset="utf-8">
        <title>register</title>
		<meta name="keywords" content="" />
		<meta name="description" content="" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
		
		<script type="text/javascript" src="assets/js/ajax.js"></script>
        <script type="text/javascript">
            function check_username(){
            	var flag=false;
                var xhr=getXhr();
                var username=document.getElementById('username').value; 
                var uri='check_username.do?userName='+username;
                xhr.open('get',encodeURI(uri),true);
                xhr.onreadystatechange=function(){
					if(xhr.readyState==4 && xhr.status==200){
						var txt=xhr.responseText;
						document.getElementById('uncr').innerHTML=txt;

                    }
                };
                xhr.send(null);
                return flag;
            }
            function check_password(){
            	var flag=false;
            	var xhr=getXhr();
            	xhr.open('post','check_email.do',true);
            	xhr.setRequestHeader('content-type',
				'application/x-www-form-urlencoded');
            	xhr.onreadystatechange=function(){
            		if(xhr.readyState==4 && xhr.status==200){
						var txt=xhr.responseText;
            			document.getElementById('upcr').innerHTML=txt;
            		}
            	};
            	xhr.send('email='+document.getElementById('email').value);
         		return flag;
            }
            function beforeSubmit(){
				var flag1=check_username();
				var flag2=check_password();
				var result=flag1 && flag2;
				return result;
			}
        </script>
		
        <!-- CSS -->
        <link rel="stylesheet" href="assets/css/reset.css">
        <link rel="stylesheet" href="assets/css/supersized.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>

    <body>

        <div class="page-container">
            <h1>register</h1>
            <form action="register.form" method="post" onsubmit="return beforeSubmit()">
                <input id="username" type="text"   placeholder="userName" onblur="check_username();"><span id="uncr"></span>
                <input id="email" type="text"   placeholder="E-mail" onblur="check_password();"><span id="upcr"></span>
                <button type="submit">register</button>
                <div class="error"><span>+</span></div>
            </form>
        </div>
		
        <!-- Javascript -->
        <script src="assets/js/jquery-1.8.2.min.js"></script>
        <script src="assets/js/supersized.3.2.7.min.js"></script>
        <script src="assets/js/supersized-init.js"></script>
        <script src="assets/js/scripts.js"></script>

    </body>

</html>


