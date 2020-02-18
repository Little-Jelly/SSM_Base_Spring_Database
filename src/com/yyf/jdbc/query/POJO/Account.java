package com.yyf.jdbc.query.POJO;

public class Account {
    private Integer id;
    private String username;
    private Double balance;

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return super.toString()+ ":Id:"+this.getId() +", username:"+this.getUsername()+", balance:"+this.getBalance();
    }
}
