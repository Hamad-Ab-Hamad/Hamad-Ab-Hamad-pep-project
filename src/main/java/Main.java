import Controller.SocialMediaController;

import io.javalin.Javalin;


import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import DAO.AccountDAO;
import Model.Account;
import Service.AccountService;

/**
 * This class is provided with a main method to allow you to manually run and test your application. This class will not
 * affect your program in any way and you may write whatever code you like here.
 */
public class Main {
    public static void main(String[] args) {
        //SocialMediaController controller = new SocialMediaController();
        //Javalin app = controller.startAPI();
        //app.start(8080);



        ConnectionUtil.resetTestDatabase();
        AccountDAO accountDAO = new AccountDAO();
        
        AccountService accountService = new AccountService();

        Account account = new Account("user", "pass");

        
        /*------------------------------------------------------------------------- */
        // Tests for adding an account


        // Adding account using accountDAO

        // Account newAccount = accountDAO.addAccount(account);

        // System.out.println(newAccount.getAccount_id());
        // System.out.println(newAccount.getUsername());
        // System.out.println(newAccount.getPassword());

        // Account newAccount2 = accountDAO.addAccount(account);

        // System.out.println(newAccount2.getAccount_id());
        // System.out.println(newAccount2.getUsername());
        // System.out.println(newAccount2.getPassword());

        // Adding account using AccountService

        // Account newAccount = accountService.addAccount(account);
        
        // System.out.println(newAccount.getAccount_id());
        // System.out.println(newAccount.getUsername());
        // System.out.println(newAccount.getPassword());

        // Account newAccount2 = accountService.addAccount(account);

        // System.out.println(newAccount2.getAccount_id());
        // System.out.println(newAccount2.getUsername());
        // System.out.println(newAccount2.getPassword());

        /*------------------------------------------------------------------------- */
        // tests for checking login

        accountService.addAccount(account);
        System.out.println(accountService.checkLogin(account));

        Account account2 = new Account("user", "pass2");
        System.out.println(accountService.checkLogin(account2));

        Account account3 = new Account("user2", "pass2");
        System.out.println(accountService.checkLogin(account3));

    }

}
