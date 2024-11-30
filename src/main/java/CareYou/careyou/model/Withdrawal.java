package CareYou.careyou.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("WITHDRAWAL")
public class Withdrawal extends Transaction {

    @Column(name = "BankAccount")
    private String bankAccount;

    @Column(name = "BankName")
    private String bankName;

    @Column(name = "WithdrawMethod", nullable = false)
    private String withdrawMethod;

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getWithdrawMethod() {
        return withdrawMethod;
    }

    public void setWithdrawMethod(String withdrawMethod) {
        this.withdrawMethod = withdrawMethod;
    }

}
