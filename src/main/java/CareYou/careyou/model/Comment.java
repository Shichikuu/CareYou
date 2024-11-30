package CareYou.careyou.model;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Column(name = "Username")
    private String username;

    @Column(name = "Content")
    private String content;

    @Column(name = "UserID", insertable = false, updatable = false)
    private Integer userId;

    @Column(name = "TransactionID", insertable = false, updatable = false)
    private Integer transactionId;

    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    private User user;

    @OneToOne
    @JoinColumn(name = "TransactionID", referencedColumnName = "TransactionID")
    private Transaction transaction;

    public Comment(String username, String content, Integer userId, Integer transactionId, User user, Transaction transaction) {
        this.username = username;
        this.content = content;
        this.userId = userId;
        this.transactionId = transactionId;
        this.user = user;
        this.transaction = transaction;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
