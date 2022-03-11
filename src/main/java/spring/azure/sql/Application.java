package spring.azure.sql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
	@Autowired
	private EmployeeRepository repository;

	public static void main(String[] args) {
		System.out.println("Hello I am doing here");
		SpringApplication.run(Application.class, args);
	}
	
	@PostMapping("/getEmp")
	public Employee addEmployee(@RequestBody Employee employee) {
		return repository.save(employee);
	}
	
	

	@GetMapping("/getEmpLIst")
	public List<Employee> getEmployeeList(){
		
		return repository.findAll();
	}

}
