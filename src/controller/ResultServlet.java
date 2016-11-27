package controller;

import domains.Question;
import domains.Result;
import domains.User;
import service.ResultService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shreha on 11/15/2016.
 */
@WebServlet(name = "PlayServlet")
public class ResultServlet extends HttpServlet {
    ArrayList<Integer> setOfquestion = new ArrayList<Integer>();
    Question step_backQuestion = new Question();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = request.getParameter("page");
        if(page.equalsIgnoreCase("phome")){
            RequestDispatcher rd = request.getRequestDispatcher("playQuiz/newUser.jsp");
            rd.forward(request, response);
            /*UserServlet.checkSession(request,response,page);
            // THis is the session to check the user playing the quiz
            User user_for_session = (User) request.getSession().getAttribute("user");
            System.out.println("The user session is ------------> " + user_for_session.getName());
            generateRandomQuestion(request, response, page, setOfquestion,user_for_session);*/
        }
        if(page.equalsIgnoreCase("play")){
/*            List<Question> questionList = new QuestionService().getQuestionList();
            request.setAttribute("questionList",questionList);*/
            RequestDispatcher rd = request.getRequestDispatcher("playQuiz/PlayQuiz.jsp");
            rd.forward(request, response);

        }
        UserServlet.checkSession(request,response,page);
        // THis is the session to check the user playing the quiz
        User user_for_session = (User) request.getSession().getAttribute("user");
        System.out.println("The user session is ------------> " + user_for_session.getName());
        generateRandomQuestion(request, response, page, setOfquestion,user_for_session);
    }

    private void generateRandomQuestion(HttpServletRequest request, HttpServletResponse response, String page, ArrayList<Integer> setOfquestion, User user_for_session) throws ServletException, IOException {
        System.out.println("I am in generate function");
        if(page.equalsIgnoreCase("playnow")){
            System.out.println("I am in Play now page");
            Question question = new ResultService().generateRandomQuestion();
            request.setAttribute("question", question);
            step_backQuestion = question;
            // recordQuestion(request,response,page,step_backQuestion);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("playQuiz/displayQuestion.jsp");
            requestDispatcher.forward(request,response);

        }
        if(page.equalsIgnoreCase("next")){

            recordQuestion(request,response,page,step_backQuestion,user_for_session);
            Question question = new ResultService().generateRandomQuestion();
            step_backQuestion = question;

            if(setOfquestion.contains(question.getId())) {
                System.out.println("The qstn is repeated!");

                int  number_of_question = new ResultService().TotalNumberOfQuestion();
                System.out.println("no of question : " + number_of_question);
                System.out.println("no of arraylist: "+ setOfquestion.size());
                if(number_of_question == setOfquestion.size()){
                    // Later WORK : DIRECT TO PAGE WHICH SAYS QUESTIONS ARE FINISHED
//                    System.out.println("no of question : " + number_of_question);
//                    System.out.println("no of arraylist: "+ setOfquestion.size());
//                    System.out.println("Question is finished ! ");
//                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("quiz/endQuestion.jsp");
//                    requestDispatcher.forward(request,response);

                    //late edits
                    List<Result> resultList = new ResultService().getResultList(user_for_session.getUid());
                    int totalscore = 0;
                    for(int i = 0 ; i <resultList.size(); i++){
                        System.out.println("Individual Score" +resultList.get(1).getScore());
                        totalscore = totalscore + resultList.get(i).getScore();

                    }
                    System.out.println("Total Score"+ totalscore);
                    request.setAttribute("resultList",resultList);
                    request.setAttribute("totalscore",totalscore);

                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("playQuiz/displayResult.jsp");
                    requestDispatcher.forward(request,response);




                }
                System.out.println("THe user name is before genran "+ user_for_session.getName());
                generateRandomQuestion(request,response,page,setOfquestion,user_for_session);

            }
            else{
                setOfquestion.add(question.getId());
                request.setAttribute("question", question);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("quiz/displayQuestion.jsp");
                requestDispatcher.forward(request,response);
            }

        }
        if(page.equalsIgnoreCase("viewresult")){
            List<Result> resultList = new ResultService().getResultList(user_for_session.getUid());
            int totalscore = 0;
            for(int i = 0 ; i <resultList.size(); i++){
                System.out.println("Individual Score" +resultList.get(1).getScore());
                totalscore = totalscore + resultList.get(i).getScore();

            }
            System.out.println("Total Score"+ totalscore);
            request.setAttribute("resultList",resultList);
            request.setAttribute("totalscore",totalscore);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("playQuiz/displayResult.jsp");
            requestDispatcher.forward(request,response);
        }
    }

    public void recordQuestion(HttpServletRequest request, HttpServletResponse response, String page, Question question,User user) throws ServletException, IOException {


        System.out.println("The user id is in recorQuestion ---> "+ user.getUid());
        int user_id = user.getUid() ;
        int question_id = question.getId();
        String question_name = question.getQuestion();
        String selectedAnswer = request.getParameter("ans");
        String correct_answer = question.getCorrectAnswer();
        int score = 0;
        if(selectedAnswer.equals(correct_answer)){score = 10;}
        Result result = new Result();

        result.setUid(user_id);
        result.setId(question_id);
        result.setQuestion(question_name);
        result.setSelectedAnswer(selectedAnswer);
        result.setCorrectAnswer(correct_answer);
        result.setScore(score);
        result.setId(question.getId());
        int update_result = new ResultService().resultRecord(result);
        if(update_result == 0){
            System.out.println("The result table is not updated !! ");
        }
        else {
            System.out.println("The result table is updated!!");
        }


        System.out.println("The question is "+ question.getQuestion());
        System.out.println("USer choice is: "+ selectedAnswer);
        System.out.println("Correct answer is "+ correct_answer);
        System.out.println("The score is : "+ score);




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
