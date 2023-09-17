package com.dnb.empms.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dnb.empms.dto.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	// select * from employee where dept = ?
	List<Employee> findByDept(String deptName);
	// select * from employee where salary > ?
	List<Employee> findBySalaryGreaterThan(int salary);
	// select * from employee where dept = ? and salary < ?
	List<Employee> findByDeptAndSalaryLessThan(String deptName, int salary);
	// select top 1 from employee order by salary desc
	Optional<Employee> findTopByOrderBySalaryDesc();
	
	List<Employee> findTop3ByOrderBySalaryDesc();
	
	List<Employee> findFirst2BySalary(int salary);
	List<Employee> findFirst2ByDeptOrderBySalaryDesc(String deptName);
	List<Employee> findBy();
	List<Employee> findBySalaryBetween(int salarya, int salaryb);
	List<Employee> findByNameLike(String likeName);
	List<Employee> findByDeptLike(String likeName);
	long countByDept(String deptName);
	
	// select dept, max(salary) from employee group by 
	// op : List : instance
	// input : NA
	
	@Query("SELECT e.dept, MAX(e.salary) FROM Employee e GROUP BY e.dept")
	List<Object[]> findMaxSalaryByDept();
	
}
