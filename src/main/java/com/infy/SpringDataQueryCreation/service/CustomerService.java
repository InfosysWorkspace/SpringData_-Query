package com.infy.SpringDataQueryCreation.service;

import com.infy.SpringDataQueryCreation.exception.InfyBankException;

public interface CustomerService {
    String findNameByEmailId(String emailId);
    void updateCustomerEmailId(String newEmailId, Integer customerId) throws InfyBankException;
    void deleteCustomerByEmailId(String emailId) throws InfyBankException;
}
