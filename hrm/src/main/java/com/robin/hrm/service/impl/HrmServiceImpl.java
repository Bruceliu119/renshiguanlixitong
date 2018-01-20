package com.robin.hrm.service.impl;

import com.robin.hrm.dao.*;
import com.robin.hrm.domain.*;
import com.robin.hrm.service.HrmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 服务层接口实现类
 */
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("hrmService")
public class HrmServiceImpl implements HrmService {
    /**
     * 自动注入持久层dao对象
     */
    @Autowired
    private UserDao userDao;
    @Autowired
    private DeptDao deptDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private JobDao jobDao;
    @Autowired
    private NoticeDao noticeDao;
    @Autowired
    private DocumentDao documentDao;

    /**********用户服务接口实现***********/
    @Transactional(readOnly = true)
    @Override
    public User login(String loginname, String password) {
        return userDao.selectByLoginnameAndPassword(loginname, password);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findUserByParam(Map<String, Object> params) {
        return userDao.selectByPage(params);
    }

    @Transactional(readOnly = true)
    @Override
    public User findUserById(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public Boolean deleteUserById(Integer id) {
        Boolean flag = userDao.deleteById(id);
        return flag;
    }

    @Override
    public Boolean updateUser(User user) {
        Boolean flag = userDao.update(user);
        return flag;
    }

    @Override
    public Boolean addUser(User user) {
        Boolean flag = userDao.save(user);
        return flag;
    }

    /**********部门服务接口实现***********/
    @Transactional(readOnly = true)
    @Override
    public List<Dept> findDeptByParam(Map<String, Object> params) {
        return deptDao.selectByPage(params);
    }

    @Transactional(readOnly = true)
    @Override
    public Dept findDeptById(Integer id) {
        return deptDao.selectById(id);
    }

    @Override
    public void deleteDeptById(Integer id) {
        deptDao.deleteById(id);
    }

    @Override
    public void updateDept(Dept dept) {
        deptDao.update(dept);
    }

    @Override
    public void addDept(Dept dept) {
        deptDao.save(dept);
    }

    /**********员工服务接口实现***********/
    @Transactional(readOnly = true)
    @Override
    public List<Employee> findEmployeeByParam(Map<String, Object> params) {
        return employeeDao.selectByPage(params);
    }

    @Transactional(readOnly = true)
    @Override
    public Employee findEmployeeById(Integer id) {
        return employeeDao.selectById(id);
    }

    @Override
    public Boolean deleteEmployeeById(Integer id) {
        Boolean flag = employeeDao.deleteById(id);
        return flag;
    }

    @Override
    public Boolean updateEmployee(Employee employee) {
        Boolean flag = employeeDao.update(employee);
        return flag;
    }

    @Override
    public Boolean addEmployee(Employee employee) {
        Boolean flag = employeeDao.save(employee);
        return flag;
    }

    /**********职位服务接口实现***********/
    @Transactional(readOnly = true)
    @Override
    public List<Job> findJobByParam(Map<String, Object> params) {
        return jobDao.selectByPage(params);
    }

    @Transactional(readOnly = true)
    @Override
    public Job findJobById(Integer id) {
        return jobDao.selectById(id);
    }

    @Override
    public void deleteJobById(Integer id) {
        jobDao.deleteById(id);
    }

    @Override
    public void updateJob(Job job) {
        jobDao.update(job);
    }

    @Override
    public void addJob(Job job) {
        jobDao.save(job);
    }

    /**********公告服务接口实现***********/
    @Transactional(readOnly = true)
    @Override
    public List<Notice> findNoticeByParam(Map<String, Object> params) {
        return noticeDao.selectByPage(params);
    }

    @Transactional(readOnly = true)
    @Override
    public Notice findNoticeById(Integer id) {
        return noticeDao.selectById(id);
    }

    @Override
    public void deleteNoticeById(Integer id) {
        noticeDao.deleteById(id);
    }

    @Override
    public void updateNotice(Notice notice) {
        noticeDao.update(notice);
    }

    @Override
    public void addNotice(Notice notice) {
        noticeDao.save(notice);
    }

    /**********文档服务接口实现***********/
    @Transactional(readOnly = true)
    @Override
    public List<Document> findDocumentByParam(Map<String, Object> params) {
        return documentDao.selectByPage(params);
    }

    @Transactional(readOnly = true)
    @Override
    public Document findDocumentById(Integer id) {
        return documentDao.selectById(id);
    }

    @Override
    public void deleteDocumentById(Integer id) {
        documentDao.deleteById(id);
    }

    @Override
    public void updateDocument(Document document) {
        documentDao.update(document);
    }

    @Override
    public void addDocument(Document document) {
        documentDao.save(document);
    }
}
