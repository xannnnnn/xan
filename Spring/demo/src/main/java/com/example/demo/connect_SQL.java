package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class connect_SQL {
    @Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void con(Model model){
		System.out.println("查詢中...");
	    jdbcTemplate.queryForList("select * from account.account where Account = '",model.getUser(),"' and Pwd = '", model.getPwd(),"';");
  }
}