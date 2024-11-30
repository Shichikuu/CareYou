package CareYou.careyou.factory;

import CareYou.careyou.model.Donation;
import CareYou.careyou.model.Transaction;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DonationFactory implements TransactionFactory {
    @Override
    public Donation create(int userId, LocalDateTime transactionDate, int amount, int programId) {
        Donation donation = new Donation();
        donation.setTransactionDate(transactionDate);
        donation.setAmount(amount);
        donation.setProgramId(programId);
        return donation;
    }

    public void createDonation(Donation donation, String paymentMethod, boolean isAnonymous) {
        donation.setPaymentMethod(paymentMethod);
        donation.setAnonymous(isAnonymous);
    }
}
