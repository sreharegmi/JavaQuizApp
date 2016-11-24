package controller;

import domains.Question;
import domains.User;
import service.QuestionService;

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
 * Created by Shreha on 9/20/2016.
 */
@WebServlet(name = "QuestionServlet")
public class QuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");

        ifLogged(request,response,page);
        if(page.equalsIgnoreCase("qlist")) {
            List<Question> questionList = new QuestionService().getQuestionList();
            request.setAttribute("questionList",questionList);
            RequestDispatcher rd = request.getRequestDispatcher("question/qlist.jsp");
            rd.forward(request, response);
        }

        if (page.equalsIgnoreCase("qForm")) {
            RequestDispatcher rd = request.getRequestDispatcher("question/qForm.jsp");
            rd.forward(request, response);
        }
        if (page.equalsIgnoreCase("addquestion")) {
            Question question = new Question();
            question.setQuestion(request.getParameter("question"));
            question.setOption1(request.getParameter("option1"));
            question.setOption2(request.getParameter("option2"));
            question.setOption3(request.getParameter("option3"));
            question.setOption4(request.getParameter("option4"));
            question.setCorrectAnswer(request.getParameter("correctAnswer"));
            question.setQuestionCategory(request.getParameter("questionCategory"));

            // insert into db
            new QuestionService().insert(question);
            redirectToList(request, response);
        }
        if (page.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            new QuestionService().delete(id);
            redirectToList(request, response);
        }

        if (page.equalsIgnoreCase("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Question question = new QuestionService().getQuestion(id);
            request.setAttribute("question", question);
            RequestDispatcher rd = request.getRequestDispatcher("question/qedit.jsp");
            rd.forward(request, response);
        }

        if (page.equalsIgnoreCase("updatequestion")) {
            Question question = new Question();
            question.setQuestion(request.getParameter("question"));
            question.setOption1(request.getParameter("option1"));
            question.setOption2(request.getParameter("option2"));
            question.setOption3(request.getParameter("option3"));
            question.setOption4(request.getParameter("option4"));
            question.setCorrectAnswer(request.getParameter("correctAnswer"));
            question.setQuestionCategory(request.getParameter("questionCategory"));
            question.setId(Integer.parseInt(request.getParameter("id")));

            new QuestionService().update(question);
            redirectToList(request, response);
        }

    }
    private void redirectToList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Question> questionList = new QuestionService().getQuestionList();
        request.setAttribute("questionList",questionList);
        RequestDispatcher rd = request.getRequestDispatcher("question/qlist.jsp");
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
        doPost(request, response);
    }
}
