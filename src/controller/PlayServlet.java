package controller;

import domains.Question;
import service.QuestionService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Shreha on 11/15/2016.
 */
@WebServlet(name = "PlayServlet")
public class PlayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = request.getParameter("page");
        if(page.equalsIgnoreCase("phome")){
            RequestDispatcher rd = request.getRequestDispatcher("playQuiz/newUser.jsp");
            rd.forward(request, response);
        }
        if(page.equalsIgnoreCase("play")){
/*            List<Question> questionList = new QuestionService().getQuestionList();
            request.setAttribute("questionList",questionList);*/
            RequestDispatcher rd = request.getRequestDispatcher("playQuiz/PlayQuiz.jsp");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
