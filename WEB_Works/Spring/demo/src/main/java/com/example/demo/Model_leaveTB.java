package com.example.demo;
import org.springframework.stereotype.Component;

@Component
public class Model_leaveTB {
    private String code;
    private String index;
    private String name;
    private String empid;
    private String Sdate;
    public String getJobAgent() {
        return JobAgent;
    }
    public void setJobAgent(String jobAgent) {
        JobAgent = jobAgent;
    }
    private String Edate;
    private String JobAgent;
    public String getEmpid() {
        return empid;
    }
    public void setEmpid(String empid) {
        this.empid = empid;
    }
    private String LeaveType;
    private String reason;
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getIndex() {
        return index;
    }
    public void setIndex(String index) {
        this.index = index;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSdate() {
        return Sdate;
    }
    public void setSdate(String sdate) {
        Sdate = sdate;
    }
    public String getEdate() {
        return Edate;
    }
    public void setEdate(String edate) {
        Edate = edate;
    }
    public String getLeaveType() {
        return LeaveType;
    }
    public void setLeaveType(String leaveType) {
        LeaveType = leaveType;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    
}
