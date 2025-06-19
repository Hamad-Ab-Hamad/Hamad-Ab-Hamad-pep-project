package DAO;

import Model.Message;
import Util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO {

    
    public void updateMessageByID(int message_id, String message_text){
        Connection connection = ConnectionUtil.getConnection();
        try{
            //Write SQL logic here
            String sql = "UPDATE message SET message_text = ? WHERE message_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //write preparedStatement's setString and setInt methods here.
            preparedStatement.setString(1, message_text);
            preparedStatement.setInt(2, message_id);

            preparedStatement.executeUpdate();

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
    
    public void deleteMessageByID(int message_id){
        Connection connection = ConnectionUtil.getConnection();
        try{
            //Write SQL logic here
            String sql = "DELETE FROM message WHERE message_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //write preparedStatement's setString and setInt methods here.
            preparedStatement.setInt(1, message_id);

            preparedStatement.executeUpdate();

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
    
    
    public Message getMessageByID(int message_id){
        Connection connection = ConnectionUtil.getConnection();
        try{
            //Write SQL logic here
            String sql = "SELECT * FROM message WHERE message_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //write preparedStatement's setString and setInt methods here.
            preparedStatement.setInt(1, message_id);

            
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                Message message = new Message(rs.getInt("message_id"),
                rs.getInt("posted_by"),
                rs.getString("message_text"),
                rs.getLong("time_posted_epoch"));

                return message;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return null;
    }
    
    public List<Message> getAllMessages(){
        
        Connection connection = ConnectionUtil.getConnection();
        List<Message> messages = new ArrayList<>();
        try {
            //Write SQL logic here
            String sql = "SELECT * FROM message";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Message message = new Message(rs.getInt("message_id"),
                        rs.getInt("posted_by"),
                        rs.getString("message_text"),
                        rs.getLong("time_posted_epoch"));
                messages.add(message);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return messages;


    }
    
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
