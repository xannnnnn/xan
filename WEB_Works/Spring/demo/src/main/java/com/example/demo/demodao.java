package com.example.demo;


import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Repository

public class demodao {
  
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
	private NamedParameterJdbcTemplate jdbcNameTemplate;

    public Map SelectUser(Model model){
        String sql = "select count(account)as 'code',UserName,`index`,permission from account.emp_record where Account = '" + model.getUser() + "' and Pwd = '" + model.getPwd() + "';" ;
        System.out.print(sql);
        return jdbcTemplate.queryForMap(sql);
    }

    public List Get_LeaveTypeTB(){
        String sql = "SELECT `index`, `type` FROM account.leave_type;" ;
        return jdbcTemplate.queryForList(sql);
    }

    public List Get_leaveTB(Model_GetleaveTB model){
        String sql="";
        
        if(model.getReview().equals("all")){
            sql = "select a.`index`,a.emp_name,a.emp_id,b.`type`,a.type as type_id ,a.start_date,a.end_date,a.reason,a.review,a.review_reason,c.userName as JobAgent ,c.`index` as JobAgent_id from leave_record a, leave_type b ,emp_record c WHERE a.`type` = b.`index` and a.`job_agent` = c.`index` and start_date >= '" + model.getYear() + "-01-01' and start_date <= '" + model.getYear() + "-12-31' order by start_date DESC;";
        }else{
            sql = "select a.`index`,a.emp_name,a.emp_id,b.`type`,a.type as type_id ,a.start_date,a.end_date,a.reason,a.review,a.review_reason,c.userName as JobAgent ,c.`index` as JobAgent_id from leave_record a, leave_type b ,emp_record c WHERE a.`type` = b.`index` and a.`job_agent` = c.`index` and start_date >= '" + model.getYear() + "-01-01' and start_date <= '" + model.getYear() + "-12-31' and review='" + model.getReview() + "' order by start_date DESC;";
        }
        return jdbcTemplate.queryForList(sql);
    }

    public List Get_JobAgent(Model_JobAgent model){
        String sql="";

            sql = "select department FROM account.emp_record  where UserName='"+model.getName()+"';";
            List<Map<String, Object>> res= jdbcTemplate.queryForList(sql);
            
            String res_str="";
            for(Map<String,Object> map : res){
                for(String key : map.keySet()){
                    res_str = res_str+(map.get(key));
                }
            }
            System.out.print(res_str);

            sql = "SELECT `index`, userName FROM account.emp_record where department='" + res_str + "' and userName != '"+ model.getName() +"';";
        
        return jdbcTemplate.queryForList(sql);
    }

    public List Get_departmentTB(){
        String sql = "SELECT `index`, `department` FROM account.department;" ;
        return jdbcTemplate.queryForList(sql);
    }

    public List Get_EmpTB(){
        String sql = "SELECT a.index,a.username,a.email,a.phone,a.address,a.onboarding,a.permission,b.`index` as `department_index`, b.department FROM emp_record a, department b WHERE a.`department` = b.`Index`;" ;
        return jdbcTemplate.queryForList(sql);
    }

    public int upd_typeTB(Model_typeTB model){
        
        String sql = "UPDATE account.leave_type SET type = :type WHERE `index` = :index ";
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(model);
        return jdbcNameTemplate.update(sql, paramSource);
    }

    public int del_typeTB(Model_typeTB model){
        String sql = "DELETE FROM account.leave_type WHERE `index` = :index ";
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(model);
        return jdbcNameTemplate.update(sql, paramSource);
    }

    public int add_typeTB(Model_typeTB model){
        String sql = "INSERT INTO account.leave_type (type) VALUE (:type);";
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(model);
        return jdbcNameTemplate.update(sql, paramSource);
    }

    public int department(Model_departmentTB model){
        
        String sql = "";
        switch(model.getCode()){
            case "add" :
                sql = "INSERT INTO account.department (department) VALUE (:name);";
            break; 

            case "upd" :
                sql = "UPDATE account.department SET department = :name WHERE `index` = :index ";
            break; 

            case "del" :
                sql = "DELETE FROM account.department WHERE `index` = :index ";
            break; 
        }
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(model);
        return jdbcNameTemplate.update(sql, paramSource);
    }

    public int employee(Model_empTB model){
        
        String sql = "";
        switch(model.getCode()){
            case "add" :
                sql = "INSERT INTO account.emp_record (account,pwd,username,email,phone,address,onboarding,department,permission)"
                + " VALUE (:account,:pwd,:name,:mail,:phone,:address,:date,:department,:permission);";
            break; 

            case "upd" :
                sql = "UPDATE account.emp_record SET username = :name , email = :mail , phone = :phone ,"
                +" address = :address , onboarding = :date , department = :department "
                +", permission = :permission WHERE `index` = :index ";
            break; 

            case "del" :
                sql = "DELETE FROM account.emp_record WHERE `index` = :index ";
            break; 
        }
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(model);
        return jdbcNameTemplate.update(sql, paramSource);
    }

    public int verify(Model_verify model){
        
        String sql = "UPDATE account.leave_record SET review = :review , review_reason = :review_reason WHERE `index` = :index ;";

        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(model);
        return jdbcNameTemplate.update(sql, paramSource);
    }

    public int leaveTB(Model_leaveTB model){
        
        String sql = "";
        switch(model.getCode()){
            case "add" :
                sql = "INSERT INTO account.leave_record (emp_name,emp_id,type,start_date,end_date,reason,job_agent)"
                + " VALUE (:name,:empid,:LeaveType,:Sdate,:Edate,:reason,:JobAgent);";
            break; 

            case "upd" :
                sql = "UPDATE account.leave_record SET  type = :LeaveType , start_date = :Sdate , end_date = :Edate , reason = :reason , job_agent = :JobAgent "
                +"WHERE `index` = :index ;";
            break; 

            case "del" :
                sql = "DELETE FROM account.leave_record WHERE `index` = :index ;";
            break; 
        }
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(model);
        return jdbcNameTemplate.update(sql, paramSource);
    }
}

