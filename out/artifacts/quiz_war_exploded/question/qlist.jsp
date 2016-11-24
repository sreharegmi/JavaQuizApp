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

                    <h2>Questions List</h2>
                </div>
                <h2><a href="qForm?page=qForm">Add New Question</a></h2>
                <table>
                    <tr>
                        <th>Questions</th>
                        <th>Option1</th>
                        <th>Option2</th>
                        <th>Option3</th>
                        <th>Option4</th>
                        <th>Correct Answer</th>
                        <th>Question Category</th>
                        <th>Edit</th>
                        <th>Delete</th>
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
                            <td><a href="qedit?page=edit&id=${question.id}"><img src="../images/edit.jpg" height="30px" width="40px" alt="Edit"></a></td>
                            <td><a href="qdelete?page=delete&id=${question.id}" onclick="return confirm('Are you sure you want to delete the question?')"><img src="../images/delete.jpg" height="30px" width="40px" alt="Delete"></a></td>
                        </tr>
                    </c:forEach>
                </table>

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



