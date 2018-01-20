package com.robin.hrm.controller;

import com.robin.hrm.domain.Dept;
import com.robin.hrm.domain.Employee;
import com.robin.hrm.domain.Job;
import com.robin.hrm.service.HrmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {
    @Autowired
    @Qualifier("hrmService")
    private HrmService hrmService;

    /**
     * 查询所有员工
     */
    @RequestMapping(value = "/employee/all")
    @ResponseBody
    public Object employeeAll() throws Exception {
        Map<String, Object> params = new HashMap<>();
        List<Employee> employeeList = hrmService.findEmployeeByParam(params);
        return employeeList;
    }

    /**
     * 根据参数查询员工
     */
    @RequestMapping(value = "/employee/search")
    @ResponseBody
    public Object employeeSearch(@RequestParam("name") String name) throws Exception {
        Employee employee = new Employee();
        employee.setName(name);
        Map<String, Object> params = new HashMap<>();
        params.put("employee", employee);
        List<Employee> employeeList = hrmService.findEmployeeByParam(params);
        return employeeList;
    }

    /**
     * 插入员工
     */
    @RequestMapping(value = "/employee/add")
    @ResponseBody
    public Boolean employeeAdd(@RequestBody Employee employee, @RequestParam("deptId") String deptId, @RequestParam("jobId") String jobId) throws Exception {
        Dept dept = hrmService.findDeptById(Integer.parseInt(deptId));
        Job job = hrmService.findJobById(Integer.parseInt(jobId));
        employee.setDept(dept);
        employee.setJob(job);
        Boolean flag = hrmService.addEmployee(employee);
        return flag;
    }

    /**
     * 删除员工
     */
    @RequestMapping(value = "/employee/delete")
    @ResponseBody
    public Boolean employeeDelete(@RequestParam("id") String id) {
        Boolean flag = hrmService.deleteEmployeeById(Integer.parseInt(id));
        return flag;
    }

    /**
     * 修改员工
     */
    @RequestMapping(value = "/employee/modify")
    @ResponseBody
    public Boolean employeeModify(@RequestBody Employee employee, @RequestParam("id") String id, @RequestParam("deptId") String deptId, @RequestParam("jobId") String jobId) throws Exception {
        Dept dept = hrmService.findDeptById(Integer.parseInt(deptId));
        Job job = hrmService.findJobById(Integer.parseInt(jobId));
        employee.setId(Integer.parseInt(id));
        employee.setDept(dept);
        employee.setJob(job);
        Boolean flag = hrmService.updateEmployee(employee);
        return flag;
    }
}
