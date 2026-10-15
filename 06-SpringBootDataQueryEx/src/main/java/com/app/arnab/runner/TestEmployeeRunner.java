package com.app.arnab.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.arnab.entity.Employee;
import com.app.arnab.exception.EmployeeNotFoundException;
import com.app.arnab.repo.EmployeeRepository;

@Component
public class TestEmployeeRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repo.saveAll(Arrays.asList(//
				new Employee(101, "AA", 200.00, "DEV"), //
				new Employee(102, "BB", 300.00, "DEV"), //
				new Employee(103, "CC", 400.00, "QA"), //
				new Employee(104, "DD", 500.00, "QA"), //
				new Employee(105, "EE", 600.00, "DEV")//
		));

		Consumer<String> c = e -> System.out.println(e);
		List<String> l = repo.getAllEmpNames();
		l.forEach(c);

		// #1 SQL: fetch one column data
		repo.getAllEmpNames().forEach(e -> System.out.println(e));

		repo.getAllEmpNames().forEach(System.out::println);

		
		// #2 SQL: select all columns
		repo.getAllEmployees().forEach(System.out::println);

		
		// #3 SQL: select multiple columns (but not all)
		repo.fetchIdAndNames().forEach(System.out::println); // prints obj arr ref.

		repo.fetchIdAndNames().forEach(o -> System.out.println(o[0] + "-" + o[1]));

		repo.fetchIdAndNames()
		.stream().map(o -> o[0] + " : " + o[1])
		.forEach(System.out::println);
		
		
		// #4: Fetch one col and one row data
		Optional<String> empName = repo.getEmpNameById(103);
		if (empName.isPresent()) {
			System.out.println(empName.get());
		} else {
			System.out.println("No data found!");
		}

		
		// #5: Fetch all columns and one row
		// Create a custom exception - anonymous person exception
		try {			
			Integer id = 1010;
			Employee emp = repo.getEmployeeById(id)
					.orElseThrow(() -> new EmployeeNotFoundException(
						String.format("Employee with ID %d not found!", id)
					));
			System.out.println(emp);
		} catch (EmployeeNotFoundException enfe) {
			enfe.printStackTrace();
		}

		// #6: Fetch multiple columns and one row
		repo.getEmpNameAndSalaryById(102).ifPresent(data -> {

			// Step 1: Print the outer array using Arrays.toString()
			// Displays the default representation of the inner Object[] array
			System.out.println(Arrays.toString(data));

			// Step 2: Print all nested array elements using Arrays.deepToString()
			// Displays the actual employee name and salary
			System.out.println(Arrays.deepToString(data));

			// Step 3: Print the length of the outer array
			// Expected: 1, because the outer array contains one inner array
			System.out.println("Array length: " + data.length);

			// Step 4: Print the runtime type of the first element
			// Expected: [Ljava.lang.Object; (Object[] array)
			System.out.println("First element type: " + data[0].getClass().getName());

			// Step 5: Print the contents of the first element
			// Cast data[0] to Object[] to access the inner array
			System.out.println("First element: " + Arrays.deepToString((Object[]) data[0]));

			// Step 6: Store the inner array in a separate variable
			Object[] row = (Object[]) data[0];

			// Step 7: Print the employee name (index 0)
			System.out.println("Employee Name: " + row[0]);

			// Step 8: Print the employee salary (index 1)
			System.out.println("Employee Salary: " + row[1]);

		});

	}

}
