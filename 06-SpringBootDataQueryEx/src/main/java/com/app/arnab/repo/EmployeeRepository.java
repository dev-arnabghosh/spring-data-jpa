package com.app.arnab.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.arnab.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// Step 2 - @Query("_________")
	// Step 1 - ReturnType absractMethodName(<Param>)
	// The abstract method name can be any name...

	// #1 SQL: fetch one column data
	// @Query("SELECT empName from Employee")
	@Query("SELECT e.empName from Employee e") // using aliasing - standard approach
	List<String> getAllEmpNames();

	// #2 SQL: select all columns
	// @Query("SELECT e FROM Employee e")
	@Query("From Employee e")
	List<Employee> getAllEmployees();

	// #3 SQL: select multiple columns (but not all)
	@Query("SELECT e.empId, e.empName from Employee e")
	List<Object[]> fetchIdAndNames();

	// #4: Fetch one col and one row data
	// @Query("SELECT e.empName FROM Employee e where e.empId=?0") // named parameter
	@Query("SELECT e.empName FROM Employee e where e.empId=:id") 
	// colon means runtime input and id means matching variable
	Optional<String> getEmpNameById(Integer id);

	// #5: Fetch all columns and one row
	@Query("SELECT e from Employee e where e.empId=:id")
	Optional<Employee> getEmployeeById(Integer id);

	// #6: Fetch multiple columns and one row
	@Query("SELECT e.empName, e.empSal FROM Employee e WHERE e.empId = :id")
	Optional<Object[]> getEmpNameAndSalaryById(Integer id);

}
