package com.ogutcenali.controller;

import com.ogutcenali.dto.request.UpdateProfileRequest;
import com.ogutcenali.model.Customer;
import com.ogutcenali.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @QueryMapping
    Customer getCustomerById(@Argument Long id){
        return customerService.getCustomerById(id);
    }

    @MutationMapping
    Customer updateCustomerProfile(@Argument UpdateProfileRequest updateProfileRequest){
        return customerService.updateCustomerProfile(updateProfileRequest);
    }
}
