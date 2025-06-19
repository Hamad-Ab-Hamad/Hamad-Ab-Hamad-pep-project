package DAO;

import Model.Message;
import Util.ConnectionUtil;

import java.sql.*;

public class MessageDAO {

    public Message insertMessage(Message newMessage){
        Connection connection = ConnectionUtil.getConnection();

        try{
            //Write SQL logic here
            String sql = "INSERT INTO message (posted_by, message_text, time_posted_epoch) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            //write preparedStatement's setString and setInt methods here.
            preparedStatement.setInt(1, newMessage.getPosted_by());
            preparedStatement.setString(2, newMessage.getMessage_text());
            preparedStatement.setLong(3, newMessage.getTime_posted_epoch());

            preparedStatement.executeUpdate();
            ResultSet pkeyResultSet = preparedStatement.getGeneratedKeys();
            if(pkeyResultSet.next()){
                int generated_account_id = (int) pkeyResultSet.getLong(1);
                Message message = new Message(generated_account_id, newMessage.getPosted_by(), newMessage.getMessage_text(), newMessage.getTime_posted_epoch());
                return message; 
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return null;
    }
    
}
