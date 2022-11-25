package com.example.demo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class Post {
    @Autowired
	Model model;
	@Autowired
	Service_ service;

    @RequestMapping("/post")
	public Rsp SelectUser(@RequestBody String data){
		Rsp rsp = new Rsp();
        Model model = new Model();
		
		try{
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(data);
			model.setUser(jsonNode.get("user").asText());
			model.setPwd(jsonNode.get("pwd").asText());
			rsp = service.SelectUser(model);
		}catch(Exception e){
			e.printStackTrace();
		}
		return rsp;
    }

	@RequestMapping("/Get_LeaveTypeTB")
	public Rsp lt(){
		Rsp rsp = new Rsp();
		try{
			rsp = service.Get_LeaveTypeTB();
		}catch(Exception e){
			e.printStackTrace();
		}
		return rsp;
    }

	@RequestMapping("/Get_departmentTB")
	public Rsp dt(){
		Rsp rsp = new Rsp();
		try{
			rsp = service.Get_departmentTB();
		}catch(Exception e){
			e.printStackTrace();
		}
		return rsp;
    }

	@RequestMapping("/Get_JobAgent")
	public Rsp Get_JobAgent(@RequestBody String data){
		Rsp rsp = new Rsp();
		Model_JobAgent model = new Model_JobAgent();
		try{
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(data);
			model.setName(jsonNode.get("name").asText());
			rsp = service.Get_JobAgent(model);
		}catch(Exception e){
			e.printStackTrace();
		}
		return rsp;
    }

	@RequestMapping("/Get_leaveTB")
	public Rsp Get_leave(@RequestBody String data){
		Rsp rsp = new Rsp();
		Model_GetleaveTB Model_leaveTB = new Model_GetleaveTB();
		try{
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(data);
			Model_leaveTB.setYear(jsonNode.get("year").asText());
			Model_leaveTB.setReview(jsonNode.get("review").asText());
			rsp = service.Get_leaveTB(Model_leaveTB);
		}catch(Exception e){
			e.printStackTrace();
		}
		return rsp;
    }

	@RequestMapping("/Get_EmpTB")
	public Rsp et(){
		Rsp rsp = new Rsp();
		try{
			ObjectMapper objectMapper = new ObjectMapper();
			rsp = service.Get_EmpTB();
		}catch(Exception e){
			e.printStackTrace();
		}
		return rsp;
    }

	@RequestMapping("/upd_typeTB")
	public Rsp upd_typeTB(@RequestBody String data){
		
		Rsp rsp = new Rsp();
        Model_typeTB Model_typeTB = new Model_typeTB();
		try{
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(data);
			Model_typeTB.setIndex(jsonNode.get("index").asText());
			Model_typeTB.setType(jsonNode.get("type").asText());
			rsp = service.upd_typeTB(Model_typeTB);
		}catch(Exception e){
			e.printStackTrace();
		}
		return rsp;
    }

	@RequestMapping("/del_typeTB")
	public Rsp del_typeTB(@RequestBody String data){
		
		Rsp rsp = new Rsp();
        Model_typeTB Model_typeTB = new Model_typeTB();
		try{
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(data);
			Model_typeTB.setIndex(jsonNode.get("index").asText());
			rsp = service.del_typeTB(Model_typeTB);
		}catch(Exception e){
			e.printStackTrace();
		}
		return rsp;
    }

	@RequestMapping("/add_typeTB")
	public Rsp add_typeTB(@RequestBody String data){
		
		Rsp rsp = new Rsp();
        Model_typeTB Model_typeTB = new Model_typeTB();
		try{
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(data);
			Model_typeTB.setType(jsonNode.get("type").asText());
			rsp = service.add_typeTB(Model_typeTB);
		}catch(Exception e){
			e.printStackTrace();
		}
		return rsp;
    }

	@RequestMapping("/department")
	public Rsp department(@RequestBody String data){
		
		Rsp rsp = new Rsp();
        Model_departmentTB model = new Model_departmentTB();
		try{
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(data);
			model.setName(jsonNode.get("name").asText());
			model.setIndex(jsonNode.get("index").asText());
			model.setCode(jsonNode.get("code").asText());
			rsp = service.department(model);
		}catch(Exception e){
			e.printStackTrace();
		}
		return rsp;
    }
	
	@RequestMapping("/employee")
	public Rsp employee(@RequestBody String data){
		
		Rsp rsp = new Rsp();
        Model_empTB model = new Model_empTB();
		try{
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(data);
			model.setAccount(jsonNode.get("account").asText());
			model.setAddress(jsonNode.get("address").asText());
			model.setDate(jsonNode.get("date").asText());
			model.setDepartment(jsonNode.get("department").asText());
			model.setMail(jsonNode.get("mail").asText());
			model.setName(jsonNode.get("name").asText());
			model.setPermission(jsonNode.get("permission").asText());
			model.setPhone(jsonNode.get("phone").asText());
			model.setPwd(jsonNode.get("pwd").asText());
			model.setCode(jsonNode.get("code").asText());
			model.setIndex(jsonNode.get("index").asText());
			rsp = service.employee(model);
		}catch(Exception e){
			e.printStackTrace();
		}
		return rsp;
    }

	@RequestMapping("/verify")
	public Rsp verify(@RequestBody String data){
		
		Rsp rsp = new Rsp();
        Model_verify model = new Model_verify();
		try{
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(data);
			model.setIndex(jsonNode.get("index").asText());
			model.setReview(jsonNode.get("review").asText());
			model.setReview_reason(jsonNode.get("review_reason").asText());
			rsp = service.verify(model);
		}catch(Exception e){
			e.printStackTrace();
		}
		return rsp;
    }

	@RequestMapping("/leaveTB")
	public Rsp leaveTB(@RequestBody String data){
		
		Rsp rsp = new Rsp();
        Model_leaveTB model = new Model_leaveTB();
		try{
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(data);
			model.setCode(jsonNode.get("code").asText());
			model.setIndex(jsonNode.get("index").asText());
			model.setName(jsonNode.get("name").asText());
			model.setEmpid(jsonNode.get("empid").asText());
			model.setSdate(jsonNode.get("Sdate").asText());
			model.setEdate(jsonNode.get("Edate").asText());
			model.setJobAgent(jsonNode.get("JobAgent").asText());
			model.setLeaveType(jsonNode.get("LeaveType").asText());
			model.setReason(jsonNode.get("reason").asText());
			rsp = service.leaveTB(model);
		}catch(Exception e){
			e.printStackTrace();
		}
		return rsp;
    }
}

