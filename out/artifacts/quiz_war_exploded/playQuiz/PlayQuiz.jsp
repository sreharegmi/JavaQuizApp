<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>Demo Project</title>
  <link href="../css/templatemo_style.css" rel="stylesheet" type="text/css" />
  <link href="../css/table.css" rel="stylesheet" type="text/css" />

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>
<div id="templatemo_wrapper_outter">

  <div id="templatemo_wrapper_inner">

    <div id="templatemo_header">
      <h1 id="name">QUIZ APP</h1>
    </div> <!-- end of templatemo_header -->

    <div id="templatemo_menu">

      <ul>
        <ul>
          <li><a href="phome?page=home" class="current">Home</a></li>
          <li><a href="play?page=play">Playquiz</a></li>
          <li><a href="logout?page=logout" >Logout</a></li>
        </ul>
      </ul>

    </div> <!-- end of templatemo_menu -->

    <div id="templatemo_content_wrapper">
      <div id="templatemo_content">

        <div class="content_section">
          <div>
            <table>
              <tr>
                <th>Category</th>
                <th>Action</th>
              </tr>
              <tr>
                <th>General</th>
                <th>Play Now</th>
              </tr>
              <tr>
                <th>Not General</th>
                <th>Play Now</th>
              </tr>
            </table>
          </div>

          <%--<h2>Questions List</h2>
        </div>

        <table>
          <tr>
            <th>Questions</th>
            <th>Option1</th>
            <th>Option2</th>
            <th>Option3</th>
            <th>Option4</th>
            <th>Correct Answer</th>
            <th>Question Category</th>
          </tr>
          <c:forEach items="${questionList}" var="question">
            <tr>
              <td>${question.question}</td>
              <td>${question.option1}</td>
              <td>${question.option2}</td>
              <td>${question.option3}</td>
              <td>${question.option4}</td>
              <td>${question.correctAnswer}</td>
              <td>${question.questionCategory}</td>
            </tr>
          </c:forEach>
        </table>--%>

      </div>

      <div class="cleaner"></div>

    </div> <!-- end of templatemo_content_wrapper -->

    <div id="templatemo_footer">
      This is Footer

</div>
    </div><!-- end of footer -->

  </div> <!-- end of templatemo_wrapper_inner -->

</div> <!-- end of templatemo_wrapper_outter -->

</body>
</html>



