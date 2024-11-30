package CareYou.careyou.factory;

import CareYou.careyou.model.Transaction;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public interface TransactionFactory {
    Transaction create(int userId, LocalDateTime transactionDate, int amount, int programId);
}
