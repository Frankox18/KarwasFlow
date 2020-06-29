package pe.edu.upc.Karwas.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.Karwas.model.entity.User;
import pe.edu.upc.Karwas.model.repository.RoleRepository;
import pe.edu.upc.Karwas.model.repository.UserRepository;

@Service 
public class AddUserDB implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		// SOLO DESBLOQUEAR CUANDO SE REQUIERA CREAR USUARIO DE FORMA MANUAL
		
		/*User driver = new User();
		driver.setUsername("driver1");
		driver.setPassword( new BCryptPasswordEncoder().encode("driver") );
		driver.setEnable(true);
		
		User manager = new User();
		manager.setUsername("manager1");
		manager.setPassword( new BCryptPasswordEncoder().encode("manager") );
		manager.setEnable(true);
		
		User employee = new User();
		employee.setUsername("employee1");
		employee.setPassword( new BCryptPasswordEncoder().encode("employee") );
		employee.setEnable(true);
		
		driver.addRoles("ROLE_DRIVER");
		driver.addRoles("ACCESS_ADDPERSON");
		
		manager.addRoles("ROLE_MANAGER");
		manager.addRoles("ACCESS_DELPERSON");
		manager.addRoles("ACCESS_EDITPERSON");
		
		employee.addRoles("ROLE_EMPLOYEE");
		employee.addRoles("ACCESS_DELPERSON");
		employee.addRoles("ACCESS_EDITPERSON");
		
		userRepository.save(driver);	
		userRepository.save(manager);
		userRepository.save(employee);*/
	}

}
