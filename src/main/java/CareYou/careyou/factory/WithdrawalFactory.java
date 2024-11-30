package CareYou.careyou.factory;

import CareYou.careyou.model.Transaction;
import CareYou.careyou.model.Withdrawal;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class WithdrawalFactory implements TransactionFactory {
    @Override
    public Withdrawal create(int userId, LocalDateTime transactionDate, int amount, int programId) {
        Withdrawal withdrawal = new Withdrawal();
        withdrawal.setTransactionDate(transactionDate);
        withdrawal.setAmount(amount);
        withdrawal.setProgramId(programId);
        return withdrawal;
    }

    public void createWithdrawal(Withdrawal withdrawal, String withdrawalMethod) {
        withdrawal.setWithdrawMethod(withdrawalMethod);
    }

    public void createWithdrawal(Withdrawal withdrawal, String withdrawalMethod, String bankAccount, String bankName) {
        withdrawal.setWithdrawMethod(withdrawalMethod);
        withdrawal.setBankAccount(bankAccount);
        withdrawal.setBankName(bankName);
    }
}
