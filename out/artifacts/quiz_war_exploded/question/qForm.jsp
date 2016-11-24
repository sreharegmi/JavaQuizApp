<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>Demo Project</title>
  <link href="../css/templatemo_style.css" rel="stylesheet" type="text/css" />
  <link href="../css/table.css" rel="stylesheet" type="text/css" />
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>
<script>
  function checkVal(){

    var wrong=false;
    var ques = document.getElementById("quest").value;
    var opt1 = document.getElementById("opt1").value;
    var opt2 = document.getElementById("opt2").value;
    var opt3 = document.getElementById("opt3").value;
    var opt4 = document.getElementById("opt4").value;
    var correct = document.getElementById("correct").value;
//    alert(ques + opt1 + opt2 +opt3 + opt4 + correct);
    if(correct!=opt1 && correct!=opt2 && correct!=opt3 && correct!=opt4){
      alert("The correct answer doesn't belong to any of the options!!");
      wrong=true;
    }
    if(opt1==opt2 || opt1 ==opt3 || opt1==opt4 || opt2==opt3 || opt2==opt4 || opt3==opt4){
      alert("Options cannot have the same value");
      wrong=true;
    }

    if(wrong){
      return false;
    }else{
      $("#submitQues").submit();
    }
  }
</script>

<div id="templatemo_wrapper_outter">

  <div id="templatemo_wrapper_inner">

    <div id="templatemo_header">
      <h1 id="name">QUIZ APP</h1>
    </div> <!-- end of templatemo_header -->

    <div id="templatemo_menu">

      <ul>
        <ul>
          <li><a href="home?page=home" class="current">Home</a></li>
          <li><a href="ulist?page=list">User</a></li>
          <li><a href="qlist?page=qlist">Questions</a></li>
          <li><a href="logout?page=logout" >Logout</a></li>
        </ul>
      </ul>

    </div> <!-- end of templatemo_menu -->

    <div id="templatemo_content_wrapper">

     <%--<div id="templatemo_sidebar_wrapper">--%>

        <%--<div id="templatemo_sidebar_top"></div>--%>
        <%--<div id="templatemo_sidebar">--%>

          <%--<h2>Our Services</h2>--%>

          <%--<ul class="categories_list">--%>
            <%--<li><a href="#">Test1</a></li>--%>
            <%--<li><a href="#">Test2</a></li>--%>
          <%--</ul>--%>

          <%--<div class="cleaner_h30"></div>--%>

        <%--</div>--%>
        <%--<div id="templatemo_sidebar_bottom"></div>--%>

      <%--</div>--%>



      <div id="templatemo_content">

        <div class="content_section">

          <h2>Question Add Form</h2>
        </div>
        <h2><a href="qForm?page=qForm">Add New Question</a></h2>
        <form method="post" action="addquestion">
          <input type="hidden" name="page" value="addquestion">
          <table>
            <tr>
              <th>Question</th><td><input type="text" id="quest" name="question"  required="required"></td>
            </tr>

            <tr>
              <th>Option1</th><td><input type="text" id="opt1" name="option1"  required="required"></td>
            </tr>

            <tr>
              <th>Option2</th><td><input type="text" id="opt2" name="option2"  required="required"></td>
            </tr>

            <tr>
              <th>Option3</th><td><input type="text" id="opt3" name="option3"  required="required"></td>
            </tr>

            <tr>
              <th>Option4</th><td><input type="text" id="opt4" name="option4"  required="required"></td>
            </tr>

            <tr>
              <th>Correct Answer</th><td><input type="text" id="correct" name="correctAnswer"  required="required"></td>
            </tr>

            <tr>
              <th>Question Category</th><td><input type="text" name="questionCategory"  required="required"></td>
            </tr>

            <tr>
              <th colspan="2"><input type="submit" id="submitQues" value="Add Question" onclick="checkVal(); return false;"></th>
            </tr>

          </table>
        </form>
      </div>

      <div class="cleaner"></div>

    </div> <!-- end of templatemo_content_wrapper -->

    <div id="templatemo_footer">

      This is Footer
    </div><!-- end of footer -->

  </div> <!-- end of templatemo_wrapper_inner -->

</div> <!-- end of templatemo_wrapper_outter -->

</body>
</html>



