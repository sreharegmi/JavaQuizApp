<%--
  Created by IntelliJ IDEA.
  User: Shreha
  Date: 11/15/2016
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>Demo Project</title>
  <link href="../css/templatemo_style.css" rel="stylesheet" type="text/css" />
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <script language="javascript" type="text/javascript">
    function showLoginDiv()
    {
      document.getElementById("loginDiv").style.display="";
    }
  </script>
</head>
<body>

<div id="templatemo_wrapper_outter">

  <div id="templatemo_wrapper_inner">

    <div id="templatemo_header">
      <h1 id="name">QUIZ APP</h1>
    </div> <!-- end of templatemo_header -->

    <div id="templatemo_menu">

      <ul>
        <li><a href="phome?page=phome" class="current">Home</a></li>
        <li><a href="play?page=play">Playquiz</a></li>
        <li><a href="logout?page=logout" >Logout</a></li>
      </ul>

    </div> <!-- end of templatemo_menu -->

    <div> <h2>I am a playing user and I am in my home not admin's!!</h2></div>


</body>
</html>
