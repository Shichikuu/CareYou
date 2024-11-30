package CareYou.careyou.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("DONATION")
public class Donation extends Transaction{

    @Column(name = "Comment")
    private String comment;

    @Column(name = "PaymentMethod", nullable = false)
    private String paymentMethod;

    @Column(name = "isAnonymous", nullable = false)
    private boolean isAnonymous;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(boolean anonymous) {
        isAnonymous = anonymous;
    }
}
