package CareYou.careyou.repository;

import CareYou.careyou.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    List<Transaction> findByUserId(int userId);

    List<Transaction> findByProgramIdOrderByTransactionDateDesc(int programId);

    List<Transaction> findByProgramIdAndTransactionTypeOrderByTransactionDateDesc(int programId, String transactionType);

    List<Transaction> findByTransactionTypeAndUserId(String transactionType, int userId);

    List<Transaction> findByTransactionDateAfterAndUserId(LocalDateTime date, int userId);

    List<Transaction> findByTransactionDateAfterAndTransactionTypeAndUserId(LocalDateTime date, String transactionType, int userId);

    List<Transaction> findByTransactionType(String transactionType);
}
