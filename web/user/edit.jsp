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

                    <h2>Edit User</h2>
                </div>
                <form method="post" action="updateuser">
                    <input type="hidden" name="page" value="updateuser">
                    <input type="hidden" name="id" value="${user.id}">
                <table>
                    <tr>
                        <th>User Name</th><td><input type="text" name="username" value="${user.name}"  required="required"></td>
                    </tr>

                    <tr>
                        <th>Password</th><td><input type="text" name="password" value="${user.password}"  required="required"></td>
                    </tr>

                    <tr>
                        <th>Role</th><td><input type="text" name="role" value="${user.role}"  required="required"></td>
                    </tr>

                    <tr>
                        <th colspan="2"><input type="submit" value="Update User"></th>
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



