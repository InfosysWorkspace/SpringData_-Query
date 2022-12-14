package com.infy.SpringDataQueryCreation;

import com.infy.SpringDataQueryCreation.repository.CustomerRepository;
import com.infy.SpringDataQueryCreation.service.CustomerServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringDataQueryCreationApplication implements CommandLineRunner {

	private static final Log LOGGER = LogFactory.getLog(SpringDataQueryCreationApplication.class);

	@Autowired
	CustomerServiceImpl customerService;

	@Autowired
	Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataQueryCreationApplication.class, args);
	}

	public void run(String... args) throws Exception{
		findNameByEmailId();
		updateCustomerByEmailId();
		deleteCustomerByEmailId();
	}

	public void findNameByEmailId(){
		try{
			String name = customerService.findNameByEmailId("buhari@infy.com");
			LOGGER.info("Customer name : " +name);
		} catch (Exception e ){
			if(e.getMessage() != null)
				LOGGER.info(environment.getProperty(e.getMessage(),
						"Something went wrong. Please check log file for more details."));
		}
	}

	public void updateCustomerByEmailId(){
		try{
			customerService.updateCustomerEmailId("buhari02@infy.com", 1);
			LOGGER.info(environment.getProperty("UserInterface.UPDATE_SUCCESS"));
		} catch (Exception e ){
			if(e.getMessage() != null)
				LOGGER.info(environment.getProperty(e.getMessage(),
						"Something went wrong. Please check log file for more details."));
		}
	}

	public void deleteCustomerByEmailId(){
		try{
			customerService.deleteCustomerByEmailId("buhari02@infy.com");
			LOGGER.info(environment.getProperty("UserInterface.UPDATE_SUCCESS"));
		} catch (Exception e ){
			if(e.getMessage() != null)
				LOGGER.info(environment.getProperty(e.getMessage(),
						"Something went wrong. Please check log file for more details."));
		}
	}

}
