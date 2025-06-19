package Service;

import DAO.AccountDAO;
import DAO.MessageDAO;
import Model.Message;

public class MessageService {

    public MessageDAO messageDAO;
    public AccountDAO accountDAO;
    

    public MessageService(){
        messageDAO = new MessageDAO();
        accountDAO = new AccountDAO();
    }

    public MessageService(MessageDAO messageDAO, AccountDAO accountDAO){
        this.messageDAO = messageDAO;
        this.accountDAO = accountDAO;
    }


    public Message insertMessage(Message message){
        
        if(message.getPosted_by() == accountDAO.getUserByID(message.getPosted_by()).getAccount_id()){

            if(message.getMessage_text().length() > 0 || message.getMessage_text().length() >=255){
                return this.messageDAO.insertMessage(message);
            }
        }

        return null;
    }
    
}
