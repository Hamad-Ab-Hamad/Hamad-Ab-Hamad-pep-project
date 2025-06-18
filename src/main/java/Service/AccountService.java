package Service;

import DAO.AccountDAO;
import Model.Account;


public class AccountService {
    public AccountDAO accountDAO;

    // constructor to create an AccountDAO.
    public AccountService(){
        accountDAO = new AccountDAO();
    }

    // constructor for AccountService when accountDAO is provided
    public AccountService(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    public Account addAccount(Account account){
        

        // check if username not blank
        if(account.getUsername().length() > 0){

            // check if username exists, return null if it doesn't
            if(account.getUsername() == this.accountDAO.getUserAndPass(account.getUsername(), account.getPassword()).getUsername()){
                return null;
            }

            // if password is >= 4 characters long retrun new account
            if(account.getPassword().length() >= 4){
                return this.accountDAO.addAccount(account);
            } 
        }
        
        return null;
    }
}
