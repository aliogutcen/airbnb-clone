package com.ogutcenali.service;

import com.ogutcenali.dto.request.UpdateProfileRequest;
import com.ogutcenali.model.Customer;
import com.ogutcenali.rabbitmq.model.CreateCustomer;
import com.ogutcenali.repository.ICustomerRepository;
import com.ogutcenali.utility.ServiceManager;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Optional;

@Service
public class CustomerService extends ServiceManager<Customer, Long> {

    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        super(customerRepository);
        this.customerRepository = customerRepository;
    }

    public void createCustomer(CreateCustomer createCustomer) {
        Customer customer = Customer.builder()
                .authId(createCustomer.getAuthId())
                .build();
        save(customer);
    }

    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = findById(id);
        if (customer.isEmpty()) throw new RuntimeException();
        return customer.get();
    }

    public Customer updateCustomerProfile(UpdateProfileRequest updateProfileRequest) {
        Customer customer = findById(updateProfileRequest.getId()).orElseThrow(() -> new NotFoundException("User not found with id"));
        if (updateProfileRequest.getFirstName() != null) customer.setFirstName(updateProfileRequest.getFirstName());
        if (updateProfileRequest.getLastName() != null) customer.setLastName(updateProfileRequest.getLastName());
        if (updateProfileRequest.getPhoneNumber() != null)
            customer.setPhoneNumber(updateProfileRequest.getPhoneNumber());
        if (updateProfileRequest.getGovernmentId() != null)
            customer.setGovernmentId(updateProfileRequest.getGovernmentId());
        if (updateProfileRequest.getNationality() != null)
            customer.setNationality(updateProfileRequest.getNationality());
        update(customer);
        return customer;
    }
}
