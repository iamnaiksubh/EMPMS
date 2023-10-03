package com.dnb.empms;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dnb.empms.repo.EmployeeRepository;

@SpringBootApplication
public class EmpmsApplication {

	private static EmployeeRepository employeeRepository = null;

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(EmpmsApplication.class, args);
		employeeRepository = applicationContext.getBean(EmployeeRepository.class);

		System.out.println(
				"findByDeptAndSalaryLessThan :" + employeeRepository.findByDeptAndSalaryLessThan("fms", 20000));
		System.out.println("findByDept :" + employeeRepository.findByDept("core").get(0));
		System.out.println("findBySalaryGreaterThan :" + employeeRepository.findBySalaryGreaterThan(3000));
		System.out.println(employeeRepository.findTopByOrderBySalaryDesc());
		System.out.println(employeeRepository.findBy());
		System.out.println(employeeRepository.findBySalaryBetween(1000, 25000));
		System.out.println(employeeRepository.findByNameLike("ra%"));
		System.out.println(employeeRepository.countByDept("core"));
		
		List<Object[]> result = employeeRepository.findMaxSalaryByDept();
		
		result.forEach(obj -> {
			System.out.println(Arrays.toString(obj));

//			System.out.println(obj[0] + " " + obj[1]);
		});
		
		
	}

}
