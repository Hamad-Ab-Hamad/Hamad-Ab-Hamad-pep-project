package Service;

import java.util.List;

import DAO.AccountDAO;
import DAO.MessageDAO;
import Model.Message;

public class MessageService {

    public MessageDAO messageDAO;
    
    

    public MessageService(){
        messageDAO = new MessageDAO();
    }

    public MessageService(MessageDAO messageDAO, AccountDAO accountDAO){
        this.messageDAO = messageDAO;
    }


    public Message insertMessage(Message message){

        AccountDAO accountDAO = new AccountDAO();
        
        if(accountDAO.getUserByID(message.getPosted_by()) != null){
            if(message.getPosted_by() == accountDAO.getUserByID(message.getPosted_by()).getAccount_id()){

                if(message.getMessage_text().length() > 0 || message.getMessage_text().length() >=255){
                    return this.messageDAO.insertMessage(message);
                }
            }
        }

        return null;
    }

    public List<Message> getAllMessages() {
        return this.messageDAO.getAllMessages();
    }

    public Message getMessageByID(int message_id) {
        return this.messageDAO.getMessageByID(message_id);
    }

    public Message deleteMessageByID(int message_id){
        Message message = this.messageDAO.getMessageByID(message_id);
        if(message != null){
            this.messageDAO.deleteMessageByID(message_id);
        }
        return message;
    }

    public Message updateMessageByID(int message_id, String message_text){
        Message message = this.messageDAO.getMessageByID(message_id);
        if(message != null){
            this.messageDAO.updateMessageByID(message_id, message_text);
            message = this.messageDAO.getMessageByID(message_id);
        }
        return message;
    } 
    
}
