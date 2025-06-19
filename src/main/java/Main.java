import Controller.SocialMediaController;

import io.javalin.Javalin;


import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import DAO.AccountDAO;
import DAO.MessageDAO;
import Model.Account;
import Model.Message;
import Service.AccountService;
import Service.MessageService;

/**
 * This class is provided with a main method to allow you to manually run and test your application. This class will not
 * affect your program in any way and you may write whatever code you like here.
 */
public class Main {
    public static void main(String[] args) {
        // SocialMediaController controller = new SocialMediaController();
        // Javalin app = controller.startAPI();
        // app.start(8080);



        ConnectionUtil.resetTestDatabase();
        

        
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

        // accountService.addAccount(account);
        // System.out.println(accountService.checkLogin(account));

        // Account account2 = new Account("user", "pass2");
        // System.out.println(accountService.checkLogin(account2));

        // Account account3 = new Account("user2", "pass2");
        // System.out.println(accountService.checkLogin(account3));

        /*------------------------------------------------------------------------- */
        // tests MessageDAO methods

        // MessageDAO messageDAO = new MessageDAO();
        // Message message = new Message(1, "Hello Message", 1669947792);

        // ** Test insertMessage

        // System.out.println(messageDAO.insertMessage(message));

        // ** test getAllMessages

        // messageDAO.insertMessage(message);

        // System.out.println(messageDAO.getAllMessages());

        // ** test getMessageByID

        // messageDAO.insertMessage(message);

        // System.out.println(messageDAO.getMessageByID(1));
        // System.out.println(messageDAO.getMessageByID(2));
        // System.out.println(messageDAO.getMessageByID(3));

        // ** test deleteMessageByID

        // messageDAO.insertMessage(message);

        // System.out.println(messageDAO.getMessageByID(1));
        // System.out.println(messageDAO.getMessageByID(2));

        // messageDAO.deleteMessageByID(1);

        // System.out.println(messageDAO.getMessageByID(1));
        // System.out.println(messageDAO.getMessageByID(2));
        
        /*------------------------------------------------------------------------- */
        // tests MessageService methods

        // MessageService messageService = new MessageService();
        // Message message = new Message(1, "hello message", 1669947792);
        // messageService.insertMessage(message);

        // ** test insertMessage       
        
        // System.out.println(messageService.insertMessage(message));

        // ** test getAllMessages

        // System.out.println(messageService.getAllMessages());

        // ** tests getMessageByID

        // System.out.println(messageService.getMessageByID(1));
        // System.out.println(messageService.getMessageByID(2));
        // System.out.println(messageService.getMessageByID(3));

        // ** tests deleteMessageByID

        // System.out.println(messageService.getMessageByID(1));
        // System.out.println(messageService.getMessageByID(2));
        
        // System.out.println("/*------------------------------------------------------------------------- */");

        // System.out.println(messageService.deleteMessageByID(1));

        // System.out.println("/*------------------------------------------------------------------------- */");

        // System.out.println(messageService.getMessageByID(1));
        // System.out.println(messageService.getMessageByID(2));
        
        /*------------------------------------------------------------------------- */
        // tests AccountDAO methods

        // test getUserByID method
        
        // AccountDAO accountDAO = new AccountDAO();

        // Account account = new Account(1,"user", "pass");
        // Account account2 = new Account("user2", "pass2");
        // Account account3 = new Account("user3", "pass2");

        // account = accountDAO.addAccount(account);
        // account2 = accountDAO.addAccount(account2);
        // account3 = accountDAO.addAccount(account3);

        // System.out.println(accountDAO.getUserByID(account.getAccount_id()));
        // System.out.println(accountDAO.getUserByID(account2.getAccount_id()));
        // System.out.println(accountDAO.getUserByID(account3.getAccount_id()));
        


    }

}
