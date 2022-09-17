package tech.getarrays.employeemanager;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.service.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeResource {
	private final EmployeeService employeeService;

	public EmployeeResource(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@CrossOrigin
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee () {
		List<Employee> employees = employeeService.findAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") Long id) {
		Employee employee = employeeService.findEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee (@RequestBody Employee employee) {
		Employee newEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee (@RequestBody Employee employee) {
		Employee updateEmployee = employeeService.updateEmployee(employee);
		return new ResponseEntity<>(updateEmployee, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<?> deleteById (@PathVariable("id") Long id) {
		employeeService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
}
