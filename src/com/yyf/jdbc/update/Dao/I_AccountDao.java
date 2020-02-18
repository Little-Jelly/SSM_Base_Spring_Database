package com.yyf.jdbc.update.Dao;

import com.yyf.jdbc.update.POJO.Account;

public interface I_AccountDao {
    public int addAccount(Account account);
    public int updateAccount(Account account);
    public int deleteAccount(int id);
}
