package DAO;

import Model.Account;
import Util.ConnectionUtil;

import java.sql.*;

public class AccountDAO {


    /**
     * Adds a new account to the database
     * Parameter: Account object, doesn't contain account id
     * returns: Account object
     */

    public Account addAccount(Account newAccount){
        Connection connection = ConnectionUtil.getConnection();

        try{
            //Write SQL logic here
            String sql = "INSERT INTO account (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            //write preparedStatement's setString and setInt methods here.
            preparedStatement.setString(1, newAccount.getUsername());
            preparedStatement.setString(2, newAccount.getPassword());

            preparedStatement.executeUpdate();
            ResultSet pkeyResultSet = preparedStatement.getGeneratedKeys();
            if(pkeyResultSet.next()){
                int generated_account_id = (int) pkeyResultSet.getLong(1);
                return new Account(generated_account_id, newAccount.getUsername(), newAccount.getPassword());
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return null;
    }


    /*
     * retrives the specific username and password
     * param: username , password 
     * return: account object
     */
    public Account getUserAndPass(String username, String password){
        
        Connection connection = ConnectionUtil.getConnection();
        
        try {
            //Write SQL logic here
            String sql = "SELECT * FROM account WHERE username = ? AND password = ?";
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Account account = new Account(rs.getInt("account_id"), rs.getString("username"), rs.getString("password"));
            
                return account;
            }
        
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return null; // returns null if username and password combination doesn't exists
    }

     public Account getUserByID(int ID){
        
        Connection connection = ConnectionUtil.getConnection();
        
        try {
            //Write SQL logic here
            String sql = "SELECT * FROM account WHERE account_id = ?";
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, ID);


            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Account account = new Account(rs.getInt("account_id"), rs.getString("username"), rs.getString("password"));
            
                return account;
            }
        
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return null; // returns null if username and password combination doesn't exists
    }

}
