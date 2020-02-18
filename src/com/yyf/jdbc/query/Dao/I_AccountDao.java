package com.yyf.jdbc.query.Dao;

import com.yyf.jdbc.query.POJO.Account;

import java.util.List;

public interface I_AccountDao {
    public Account findAccountById(int id);
    public List<Account> findAllAccount();
}
