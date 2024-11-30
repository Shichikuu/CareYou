package CareYou.careyou.factory;

import CareYou.careyou.model.Comment;
import CareYou.careyou.model.Transaction;
import CareYou.careyou.model.User;
import org.springframework.stereotype.Component;

@Component
public class CommentFactory {

    public Comment create(String username, String content, User user, Transaction transaction) {
        return new Comment(username, content, user.getUserId(), transaction.getTransactionId(), user, transaction);
    }
}
