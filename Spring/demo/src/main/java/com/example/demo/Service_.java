package com.example.demo;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class Service_ {

	Rsp rsp = new Rsp();
	
	
    @Autowired
	demodao Demodao;

	public Rsp SelectUser(Model model){
		Map<String, Object> map = Demodao.SelectUser(model);
		Object Code;
		Integer code_int = 0;
		Code = map.get("code");
		code_int = Integer.parseInt(Code.toString());

		if(code_int > 0){
			rsp.setData(map);
			rsp.setMsg("查詢成功。");
		}else{
			rsp.setMsg("查詢失敗。");
		}
		return rsp;
	}

	public Rsp Get_LeaveTypeTB(){
		List<Map<String, Object>> res = Demodao.Get_LeaveTypeTB();
		
		String res_str="";

		for(Map<String,Object> map : res){
	
			res_str = res_str + "{";
			int j=0 ;
			for(String key : map.keySet()){
				res_str = res_str+('"'+ key +'"' +':'+ '"'+map.get(key)+'"');

				if(j<1){
					res_str = res_str+(" ,");	
				}else{
					j=0;
				}
				j=j+1;
			}
			res_str = res_str+("},");
		}
		res_str = res_str.substring(0, res_str.length()-1);
		res_str="[" + res_str + "]";
		rsp.setData_str(res_str);
		rsp.setMsg("查詢成功");
		return rsp;
	}

	public Rsp Get_JobAgent(Model_JobAgent model){
		List<Map<String, Object>> res = Demodao.Get_JobAgent(model);
		
		String res_str="";

		for(Map<String,Object> map : res){
			res_str += "{";
			for(String key : map.keySet()){
				res_str = res_str+('"'+ key +'"' +':'+ '"'+map.get(key)+'"'+",");
			}
			res_str = res_str.substring(0, res_str.length()-1);
			res_str += "},";
		}
		res_str = res_str.substring(0, res_str.length()-1);
		res_str="[" + res_str + "]";
		rsp.setData_str(res_str);
		rsp.setMsg("查詢成功");
		return rsp;
	}

	public Rsp Get_leaveTB(Model_GetleaveTB model){
		List<Map<String, Object>> res = Demodao.Get_leaveTB(model);
		if(res.size()>0){
			String res_str="";

			for(Map<String,Object> map : res){
				res_str += "{";
				for(String key : map.keySet()){
					res_str = res_str+('"'+ key +'"' +':'+ '"'+map.get(key)+'"'+",");
				}
				res_str = res_str.substring(0, res_str.length()-1);
				res_str += "},";
			}
			res_str = res_str.substring(0, res_str.length()-1);
			res_str="[" + res_str + "]";
			rsp.setData_str(res_str);
			rsp.setMsg("查詢成功");
		}else{
			rsp.setData_str("[]");
			rsp.setMsg("查詢為空");
		}

		return rsp;
	}
	
	public Rsp Get_departmentTB(){
		List<Map<String, Object>> res = Demodao.Get_departmentTB();
		
		String res_str="";

		for(Map<String,Object> map : res){
	
			res_str = res_str + "{";
			int j=0 ;
			for(String key : map.keySet()){
				res_str = res_str+('"'+ key +'"' +':'+ '"'+map.get(key)+'"');

				if(j<1){
					res_str = res_str+(" ,");	
				}else{
					j=0;
				}
				j=j+1;
			}
			res_str = res_str+("},");
		}
		res_str = res_str.substring(0, res_str.length()-1);
		res_str="[" + res_str + "]";
		rsp.setData_str(res_str);
		rsp.setMsg("查詢成功");
		return rsp;
	}

	public Rsp Get_EmpTB(){
		List<Map<String, Object>> res = Demodao.Get_EmpTB();
		
		String res_str="";

		for(Map<String,Object> map : res){
			res_str += "{";
			for(String key : map.keySet()){
				res_str = res_str+('"'+ key +'"' +':'+ '"'+map.get(key)+'"'+",");
			}
			res_str = res_str.substring(0, res_str.length()-1);
			res_str += "},";
		}
		res_str = res_str.substring(0, res_str.length()-1);
		res_str="[" + res_str + "]";
		rsp.setData_str(res_str);
		rsp.setMsg("查詢成功");
		return rsp;
	}

	public Rsp upd_typeTB(Model_typeTB model){
		Rsp rsp = new Rsp();
		Integer code = Demodao.upd_typeTB(model);
		rsp.setCode(code);
		if(code > 0){
			rsp.setMsg("更新成功");
		}else{
			rsp.setMsg("更新失敗");
		}
		return rsp;
	}

	public Rsp verify(Model_verify model){
		Rsp rsp = new Rsp();
		Integer code = Demodao.verify(model);
		rsp.setCode(code);
		if(code > 0){
			rsp.setMsg("更新成功");
		}else{
			rsp.setMsg("更新失敗");
		}
		return rsp;
	}

	public Rsp del_typeTB(Model_typeTB model){
		Rsp rsp = new Rsp();
		Integer code = Demodao.del_typeTB(model);
		rsp.setCode(code);
		if(code > 0){
			rsp.setMsg("更新成功");
		}else{
			rsp.setMsg("更新失敗");
		}
		return rsp;
	}

	public Rsp add_typeTB(Model_typeTB model){
		Rsp rsp = new Rsp();
		Integer code = Demodao.add_typeTB(model);
		rsp.setCode(code);
		if(code > 0){
			rsp.setMsg("新增成功");
		}else{
			rsp.setMsg("新增失敗");
		}
		return rsp;
	}

	public Rsp department(Model_departmentTB model){
		Rsp rsp = new Rsp();
		Integer code = Demodao.department(model);
		rsp.setCode(code);
		if(code > 0){
			rsp.setMsg("新增成功");
		}else{
			rsp.setMsg("新增失敗");
		} 
		return rsp;
	}

	public Rsp employee(Model_empTB model){
		Rsp rsp = new Rsp();
		Integer code = Demodao.employee(model);
		rsp.setCode(code);
		if(code > 0){
			rsp.setMsg("新增成功");
		}else{
			rsp.setMsg("新增失敗");
		} 
		return rsp;
	}

	public Rsp leaveTB(Model_leaveTB model){
		Rsp rsp = new Rsp();
		Integer code = Demodao.leaveTB(model);
		rsp.setCode(code);
		if(code > 0){
			rsp.setMsg("新增成功");
		}else{
			rsp.setMsg("新增失敗");
		} 
		return rsp;
	}
	
}
