# SSM_Base_Spring_Database

使用到的Spring的bean有：
数据源：org.springframework.jdbc.datasource.DriverManagerDataSource
Jdbc: org.springframework.jdbc.core.JdbcTemplate
查询数据之后的结果：org.springframework.jdbc.core.BeanPropertyRowMapper
查询数据之后的结果：org.springframework.jdbc.core.RowMapper

使用的方法有：
org.springframework.jdbc.core.JdbcTemplate.execute()
org.springframework.jdbc.core.JdbcTemplate.update()
org.springframework.jdbc.core.JdbcTemplate.queryForObject()
org.springframework.jdbc.core.JdbcTemplate.query

使用到的其他工具：
测试工具：junit4进行测试
