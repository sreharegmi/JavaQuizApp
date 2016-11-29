<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Demo Project</title>
    <link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
    <link href="css/table.css" rel="stylesheet" type="text/css" />
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>

<div id="templatemo_wrapper_outter">
    <div id="templatemo_wrapper_inner">
        <div id="templatemo_header">
            <h1>Quiz App</h1>
        </div> <!-- end of templatemo_header -->
        <div id="templatemo_menu">

            <ul>
                <ul>
                    <li><a href="phome?page=phome" class="current">Home</a></li>
                    <li><a href="play?page=play">Playquiz</a></li>
                    <li><a href="logout?page=logout" >Logout</a></li>
                </ul>
            </ul>

        </div> <!-- end of templatemo_menu -->

        <div id="templatemo_content_wrapper">

            <%--<div id="templatemo_sidebar_wrapper">

                <div id="templatemo_sidebar_top"></div>
                <div id="templatemo_sidebar">

                    <h2>Our Services</h2>

                    <ul class="categories_list">
                        <li><a href="#">Test1</a></li>
                        <li><a href="#">Test2</a></li>
                    </ul>

                    <div class="cleaner_h30"></div>

                </div>
                <div id="templatemo_sidebar_bottom"></div>

            </div>--%>


            <div id="templatemo_content">
                <div>
                    <h2>Question</h2>
                </div>

                <h2><a href="viewResult?page=viewresult">VIEW RESULT</a></h2>
                <table>


                        <tr>
                            <td>${question.id}</td>
                            <td>${question.question}</td>
                        </tr>
                        <tr>
                            <form action="next" method="post">
                                <input type="hidden" name="page" value="next">
                                <input type="hidden" name="category" value="${question.questionCategory}">
                                <td> <INPUT TYPE="radio" NAME="ans" VALUE="${question.option1}">${question.option1}</td>
                                <td><INPUT TYPE="radio" NAME="ans" VALUE="${question.option2}">${question.option2}</td>
                                <td><INPUT TYPE="radio" NAME="ans" VALUE="${question.option3}">${question.option3}</td>
                                <td><INPUT TYPE="radio" NAME="ans" VALUE="${question.option4}">${question.option4}</td>
                                <td><INPUT TYPE="submit" VALUE="submit"></td>
                            </form>

                        </tr>


                </table>

            </div>

            <div class="cleaner"></div>

        </div> <!-- end of templatemo_content_wrapper -->

        <div id="templatemo_footer">
            Copyright @2016
        </div><!-- end of footer -->

    </div> <!-- end of templatemo_wrapper_inner -->

</div> <!-- end of templatemo_wrapper_outter -->

</body>
</html>
