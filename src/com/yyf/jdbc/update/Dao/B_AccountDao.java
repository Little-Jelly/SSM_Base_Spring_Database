package com.yyf.jdbc.update.Dao;

import com.yyf.jdbc.update.POJO.Account;
import org.springframework.jdbc.core.JdbcTemplate;

public class B_AccountDao implements I_AccountDao {

    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addAccount(Account account) {
        String sql = "insert into account(username, balance) value(?,?)";

        Object[] objects = new Object[]{
                account.getUsername(),
                account.getBalance()
        };
        int num = jdbcTemplate.update(sql,objects);
        return num;
    }

    @Override
    public int updateAccount(Account account) {
        String sql = "update account set username=?,balance=? where id=?";
        Object[] objects = new Object[]{
                account.getUsername(),
                account.getBalance(),
                account.getId()
        };
        int num = this.jdbcTemplate.update(sql, objects);
        return num;
    }

    @Override
    public int deleteAccount(int id) {
        String sql = "delete from account where id=?";
        int num = this.jdbcTemplate.update(sql, id);
        return num;
    }
}
