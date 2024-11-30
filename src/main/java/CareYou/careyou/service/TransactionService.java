package CareYou.careyou.service;

import CareYou.careyou.factory.DonationFactory;
import CareYou.careyou.factory.TransactionFactory;
import CareYou.careyou.factory.WithdrawalFactory;
import CareYou.careyou.model.Donation;
import CareYou.careyou.model.Transaction;
import CareYou.careyou.model.Withdrawal;
import CareYou.careyou.repository.DonationRepository;
import CareYou.careyou.repository.TransactionRepository;
import CareYou.careyou.repository.WithdrawalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private WithdrawalRepository withdrawalRepository;

    @Autowired
    private DonationFactory donationFactory;

    @Autowired
    private WithdrawalFactory withdrawalFactory;

    public int getUserAmount(int userId) {
        Integer amount = transactionRepository.findByUserId(userId)
                .stream()
                .mapToInt(Transaction::getAmount)
                .sum();
        return amount != null ? amount : 0;
    }

    public List<Transaction> getTransactionsByUserId(int userId) {
        return transactionRepository.findByUserId(userId);
    }

    public List<Transaction> getTransactionsByProgramId(int programId) {
        return transactionRepository.findByProgramIdOrderByTransactionDateDesc(programId);
    }

    public List<Transaction> getDonationsByProgramId(int programId) {
        return transactionRepository.findByProgramIdAndTransactionTypeOrderByTransactionDateDesc(programId, "donation");
    }

    public List<Transaction> getDonationsByUserId(int userId) {
        return transactionRepository.findByTransactionTypeAndUserId("donation", userId);
    }

    public List<Transaction> getWithdrawalsByUserId(int userId) {
        return transactionRepository.findByTransactionTypeAndUserId("withdrawal", userId);
    }

    public List<Transaction> getTransactionsAfterDateByUserId(LocalDateTime date, int userId) {
        return transactionRepository.findByTransactionDateAfterAndUserId(date, userId);
    }

    public List<Transaction> getTransactionsByTypeAfterDateAndUserId(LocalDateTime date, String type, int userId) {
        return transactionRepository.findByTransactionDateAfterAndTransactionTypeAndUserId(date, type, userId);
    }

    public void insertDonation(int userId, LocalDateTime transactionDate, int amount, int programId, String paymentMethod, boolean isAnonymous) {
        Donation donation = donationFactory.create(userId, transactionDate, amount, programId);
        donationFactory.createDonation(donation, paymentMethod, isAnonymous);
        donationRepository.save(donation);
    }

    public void insertWithdrawal(int userId, LocalDateTime transactionDate, int amount, int programId, String withdrawalMethod) {
        Withdrawal withdrawal = withdrawalFactory.create(userId, transactionDate, amount, programId);
        withdrawalFactory.createWithdrawal(withdrawal, withdrawalMethod);
        withdrawalRepository.save(withdrawal);
    }

//    public void addComment(int transactionId, String comment) {
//        Transaction transaction = transactionRepository.findById(transactionId).orElse(null);
//        if (transaction != null && transaction.getDonation() != null) {
//            transaction.getDonation().setComment(comment);
//            donationRepository.save(transaction.getDonation());
//        }
//    }

    public int getSumOfDonations() {
        return transactionRepository.findByTransactionType("donation")
                .stream()
                .mapToInt(Transaction::getAmount)
                .sum();
    }
}
