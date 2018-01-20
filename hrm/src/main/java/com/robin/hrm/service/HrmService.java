package com.robin.hrm.service;

import com.robin.hrm.domain.*;

import java.util.List;
import java.util.Map;

public interface HrmService {
    /**
     * 用户登录
     * @param loginname
     * @param password
     * @return User对象
     */
    User login(String loginname, String password);

    /**
     * 根据id查询用户
     * @param id
     * @return 用户对象
     */
    User findUserById(Integer id);

    /**
     * 通过参数查询用户
     * @return User对象的List集合
     */
    List<User> findUserByParam(Map<String, Object> params);

    /**
     * 根据id删除用户
     * @param id
     */
    Boolean deleteUserById(Integer id);

    /**
     * 修改用户
     * @param user
     */
    Boolean updateUser(User user);

    /**
     * 添加用户
     * @param user
     */
    Boolean addUser(User user);

    /**
     * 根据参数查询员工
     * @param params
     * @return Employee的List集合
     */
    List<Employee> findEmployeeByParam(Map<String, Object> params);

    /**
     * 根据id查询员工
     * @param id
     * @return 员工对象
     */
    Employee findEmployeeById(Integer id);

    /**
     * 根据id删除员工
     * @param id
     */
    Boolean deleteEmployeeById(Integer id);

    /**
     * 修改员工
     * @param employee
     */
    Boolean updateEmployee(Employee employee);

    /**
     * 添加员工
     * @param employee
     */
    Boolean addEmployee(Employee employee);

    /**
     * 通过参数查询部门
     * @param params
     * @return Dept的List集合
     */
    List<Dept> findDeptByParam(Map<String, Object> params);

    /**
     * 根据id查询部门
     * @param id
     * @return 部门对象
     */
    Dept findDeptById(Integer id);

    /**
     * 根据id删除部门
     * @param id
     */
    void deleteDeptById(Integer id);

    /**
     * 修改部门
     * @param dept
     */
    void updateDept(Dept dept);

    /**
     * 添加部门
     * @param dept
     */
    void addDept(Dept dept);

    /**
     * 根据参数查询职位
     * @param params
     * @return Job的List集合
     */
    List<Job> findJobByParam(Map<String, Object> params);

    /**
     * 根据id查询职位
     * @param id
     * @return 职位对象
     */
    Job findJobById(Integer id);

    /**
     * 根据id删除职位
     * @param id
     */
    void deleteJobById(Integer id);

    /**
     * 修改职位
     * @param job
     */
    void updateJob(Job job);

    /**
     * 添加职位
     * @param job
     */
    void addJob(Job job);

    /**
     * 通过参数查询公告
     * @param params
     * @return Notice的List集合
     */
    List<Notice> findNoticeByParam(Map<String, Object> params);

    /**
     * 根据id查询公告
     * @param id
     * @return 公告对象
     */
    Notice findNoticeById(Integer id);

    /**
     * 根据id删除公告
     * @param id
     */
    void deleteNoticeById(Integer id);

    /**
     * 修该公告
     * @param notice
     */
    void updateNotice(Notice notice);

    /**
     * 添加公告
     * @param notice
     */
    void addNotice(Notice notice);

    /**
     * 根据参数查询文档
     * @param params
     * @return Document的List集合
     */
    List<Document> findDocumentByParam(Map<String, Object> params);

    /**
     * 根据id查询文档
     * @param id
     * @return 文档对象
     */
    Document findDocumentById(Integer id);

    /**
     * 根据id删除文档
     * @param id
     */
    void deleteDocumentById(Integer id);

    /**
     * 修改文档
     * @param document
     */
    void updateDocument(Document document);

    /**
     * 添加文档
     * @param document
     */
    void addDocument(Document document);
}
