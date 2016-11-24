package controller;

import domains.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Shreha on 8/19/2016.
 */
@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");

        ifLogged(request,response,page);
        if (page.equalsIgnoreCase("login")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = new UserService().getUser(username, password);
            if (user!=null) {
                request.setAttribute("message","Login Success!");
                HttpSession session = request.getSession(false);
                session.setAttribute("user", user);
                if(user.getRole().equalsIgnoreCase("user"))
                {
                    RequestDispatcher rd = request.getRequestDispatcher("playQuiz/newUser.jsp");
                    rd.forward(request, response);
                }
                else{
                    RequestDispatcher rd = request.getRequestDispatcher("user/home.jsp");
                    rd.forward(request, response);
                }
/*                RequestDispatcher rd = request.getRequestDispatcher("user/home.jsp");
                rd.forward(request,response);*/
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request,response);
            }



        }
        if (page.equalsIgnoreCase("logout")) {
            HttpSession session = request.getSession(false);
            session.invalidate();
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
        }
        if (page.equalsIgnoreCase("home")) {
            RequestDispatcher rd = request.getRequestDispatcher("user/home.jsp");
            rd.forward(request,response);
        }
        if (page.equalsIgnoreCase("list")) {
            redirectToList(request, response);
        }
        /*if (page.equalsIgnoreCase("qlist")){
            redirectToList(request, response);
        }*/
        if (page.equalsIgnoreCase("userForm")) {
            RequestDispatcher rd = request.getRequestDispatcher("user/userForm.jsp");
            rd.forward(request, response);
        }
        if (page.equalsIgnoreCase("adduser")) {
            User user = new User();
            user.setName(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setRole(request.getParameter("role"));

            // insert into db
            new UserService().insert(user);
            redirectToList(request, response);
        }
        if (page.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            new UserService().delete(id);
            redirectToList(request, response);
        }

        if (page.equalsIgnoreCase("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            User user = new UserService().getUser(id);
            request.setAttribute("user", user);
            RequestDispatcher rd = request.getRequestDispatcher("user/edit.jsp");
            rd.forward(request, response);
        }

        if (page.equalsIgnoreCase("updateuser")) {
            User user = new User();
            user.setName(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setRole(request.getParameter("role"));
            user.setId(Integer.parseInt(request.getParameter("id")));

            new UserService().update(user);
            redirectToList(request, response);
        }

    }

    private void redirectToList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = new UserService().getUserList();
        request.setAttribute("userList",userList);
        RequestDispatcher rd = request.getRequestDispatcher("user/list.jsp");
        rd.forward(request, response);
    }

    private void ifLogged(HttpServletRequest request, HttpServletResponse response, String page){
        if(!page.equalsIgnoreCase("login")){
            HttpSession session = request.getSession(false);
            User user = (User)session.getAttribute("user");
            if(user == null){
                try {
                    request.getRequestDispatcher("index.jsp").forward(request,response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
