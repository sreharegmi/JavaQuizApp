package service;

import domains.Question;
import domains.Result;
import utils.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shreha on 10/20/2016.
 */
public class ResultService {

    public Question generateRandomQuestion(String category){
        Question randomQuestion = null;


        try {
            String query = "SELECT * FROM question where questionCategory=? order by rand() limit 1";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
            pstm.setString(1,category);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setQuestion(rs.getString("question"));
                question.setOption1(rs.getString("option1"));
                question.setOption2(rs.getString("option2"));
                question.setOption3(rs.getString("option3"));
                question.setOption4(rs.getString("option4"));
                question.setCorrectAnswer(rs.getString("correctAnswer"));
                question.setQuestionCategory(rs.getString("questionCategory"));
                randomQuestion = question;


            }
            pstm.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return randomQuestion;
    }
    public  int TotalNumberOfQuestion(){
        int number_of_rows = 0;
        try {

            String query = "SELECT * from question";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                number_of_rows++;
            }
          //  System.out.println("The numbrs of question in quiz service is + "+ number_of_rows);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return number_of_rows;
    }
    public int resultRecord(Result result){
        int validate = 0;
        String query = "INSERT INTO result(uid,id,question,correctAnswer,selectedAnswer,score) VALUES(?,?,?,?,?,?)";
//        String query = "UPDATE result SET uid=?,id=?,question=?,correctAnswer=?,selectedAnswer=?,score=?";
        PreparedStatement preparedStatement = new DatabaseConnection().getPreparedStatement(query);
        try {
            preparedStatement.setInt(1,result.getUid());
            preparedStatement.setInt(2,result.getId());
            preparedStatement.setString(3,result.getQuestion());
            preparedStatement.setString(4,result.getCorrectAnswer());
            preparedStatement.setString(5,result.getSelectedAnswer());
            preparedStatement.setInt(6,result.getScore());

            validate = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return validate;

    }
    public List<Result> getResultList(int user_id) {
        List<Result> resultList = new ArrayList<Result>();
        try {
            String query = "SELECT * FROM result where uid =?";// ORDER BY id DESC LIMIT 10";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
            pstm.setInt(1,user_id);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Result result = new Result();
                result.setId(rs.getInt("id"));
                result.setQuestion(rs.getString("question"));
                result.setCorrectAnswer(rs.getString("correctAnswer"));
                result.setSelectedAnswer(rs.getString("selectedAnswer"));
                result.setScore(rs.getInt("score"));
                resultList.add(result);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }


}
