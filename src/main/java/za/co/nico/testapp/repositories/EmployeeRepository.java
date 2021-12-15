package za.co.nico.testapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import za.co.nico.testapp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	public Employee findByEmployeeId(Long employeeId);



}

