package DAO;

import Model.Account;
import Util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {


    /**
     * Adds a new account to the database
     * Parameter: Account object
     */

    public void addAccount(Account newAccount){
        Connection connection = ConnectionUtil.getConnection();

        try{
            //Write SQL logic here
            String sql = "INSERT INTO account (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //write preparedStatement's setString and setInt methods here.
            preparedStatement.setString(1, newAccount.getUsername());
            preparedStatement.setString(2, newAccount.getPassword());

            preparedStatement.executeUpdate();
            //return newAccount;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        //return null;
    }


    /*
     * retrives the specific username and password
     * param: account object 
     * return: account object
     */
    public Account getUserAndPass(Account userAccount){
        
        Connection connection = ConnectionUtil.getConnection();
        
        try {
            //Write SQL logic here
            String sql = "SELECT * FROM account WHERE username = ? AND password = ?";
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, userAccount.getUsername());
            preparedStatement.setString(2, userAccount.getPassword());

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Account account = new Account(rs.getInt("account_id"), rs.getString("username"), rs.getString("password"));
            
                return account;
            }
        
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return null;
    }

}
