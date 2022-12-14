package com.infy.SpringDataQueryCreation.service;

import com.infy.SpringDataQueryCreation.entity.Customer;
import com.infy.SpringDataQueryCreation.exception.InfyBankException;
import com.infy.SpringDataQueryCreation.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service(value= "customerService")
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String findNameByEmailId(String emailId){
        return customerRepository.findNameByEmailId(emailId);
    }

    @Override
    public void updateCustomerEmailId(String newEmailId, Integer customerId) throws InfyBankException{
        Optional<Customer> optional = customerRepository.findById(customerId);
        optional.orElseThrow(() -> new InfyBankException("Service.CUSTOMER_UNAVAILABLE"));
        customerRepository.updateCustomerEmailId(newEmailId, customerId);
    }

    @Override
    public void deleteCustomerByEmailId(String emailId) throws InfyBankException{

        Integer count = customerRepository.deleteCustomerByEmailId(emailId);
        if(count == 0)
            throw new InfyBankException("Service.CUSTOMER_UNAVAILABLE");
    }
}
