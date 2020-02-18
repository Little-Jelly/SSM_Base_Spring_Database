import com.yyf.jdbc.update.POJO.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Main {
    public static void main(String[] args){
        System.out.println("hello, world");

        Main m = new Main();
//        m.test_createTable();
    }
    /**
     *  测试JdbcTemplate.execute，在数据库中创建新表
     */
    @Test
    public void test_createTable(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/yyf/jdbc/execute/applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        jdbcTemplate.execute("create table account(" +
                "id int primary key auto_increment," +
                "username varchar(50)," +
                "balance double)");
        System.out.println("账户表account创建成功！");
    }

    /**
     *  测试向数据库表中插入一条数据
     */
    @Test
    public void test_addAccount(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/yyf/jdbc/update/applicationContext.xml");
        com.yyf.jdbc.update.Dao.I_AccountDao dao = (com.yyf.jdbc.update.Dao.I_AccountDao)applicationContext.getBean("accountDao");
        Account account = new Account();
        account.setBalance(400.00);
        account.setUsername("Rose");
        int num = dao.addAccount(account);
        if(num > 0){
            System.out.println("成功插入了" + num + "条数据！");
        }else {
            System.out.println("插入操作执行失败！");
        }
    }

    /**
     *  测试更改数据库表中的一条数据
     */
    @Test
    public void test_updateAccount(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/yyf/jdbc/update/applicationContext.xml");
        com.yyf.jdbc.update.Dao.I_AccountDao dao = (com.yyf.jdbc.update.Dao.I_AccountDao)applicationContext.getBean("accountDao");
        Account account = new Account();
        account.setUsername("tom");
        account.setBalance(50000.00);
        account.setId(1);
        int num = dao.updateAccount(account);
        if(num > 0) {
            System.out.println("成功更新了" + num + "条数据！");
        }else {
            System.out.println("更新数据失败！");
        }
    }

    /**
     *  测试删除数据库表中的一条数据
     */
    @Test
    public void test_deleteAccount(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/yyf/jdbc/update/applicationContext.xml");
        com.yyf.jdbc.update.Dao.I_AccountDao dao = (com.yyf.jdbc.update.Dao.I_AccountDao)applicationContext.getBean("accountDao");
        int num = dao.deleteAccount(1);
        if(num > 0){
            System.out.println("成功删除了" + num + "条数据！");
        }else {
            System.out.println("删除数据失败！");
        }
    }

    /**
     *  根据一个列查询数据库表中的一条数据
     */
    @Test
    public void test_findAccountById(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/yyf/jdbc/query/applicationContext.xml");
        com.yyf.jdbc.query.Dao.I_AccountDao dao = (com.yyf.jdbc.query.Dao.I_AccountDao)applicationContext.getBean("accountDao");
        com.yyf.jdbc.query.POJO.Account account = dao.findAccountById(3);
        System.out.println(account);
    }

    /**
     *  测试查询数据库表中的所有数据
     */
    @Test
    public void test_findAllAccount(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/yyf/jdbc/query/applicationContext.xml");
        com.yyf.jdbc.query.Dao.I_AccountDao dao = (com.yyf.jdbc.query.Dao.I_AccountDao)applicationContext.getBean("accountDao");
        List<com.yyf.jdbc.query.POJO.Account> accountList = dao.findAllAccount();
        for( com.yyf.jdbc.query.POJO.Account act : accountList){
            System.out.println(act);
        }
    }
}
