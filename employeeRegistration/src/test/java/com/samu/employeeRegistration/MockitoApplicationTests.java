package com.samu.employeeRegistration;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.samu.employeeRegistration.model.Employee;
import com.samu.employeeRegistration.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest

public class MockitoApplicationTests {
	@Autowired
	@MockBean
	private EmployeeRepository repository;
	
	@Test
	public void getEmployeesTest() {
		when(repository.findAllOrderByFirstNameAsc()).thenReturn(Stream
				.of(new Employee(5,"anupamma", "biradar","female", "24/02/1992","Accounts"), new Employee(6,"shama", "mahamad","female","12/02/1999", "Human resource")).collect(Collectors.toList()));
		assertEquals(2, repository.findAllOrderByFirstNameAsc().size());
	}

	@Test
	public void saveEmployeeTest() {
		Employee employee = new Employee(7,"venkat","Pranya","male","1992-01-02","IT");
		when(repository.save(employee)).thenReturn(employee);
		assertEquals(employee, repository.save(employee));
	}

	@Test
	public void deleteUserTest() {
		Employee employee = new Employee(8,"nkat","Pranya","male","2000-12-12","IT");
		repository.delete(employee);
		verify(repository, times(1)).delete(employee);
	}



}
