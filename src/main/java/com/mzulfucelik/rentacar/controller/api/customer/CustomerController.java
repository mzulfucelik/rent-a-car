package com.mzulfucelik.rentacar.controller.api.customer;

import com.mzulfucelik.rentacar.controller.api.AbstractController;
import com.mzulfucelik.rentacar.dto.customer.CustomerDTO;
import com.mzulfucelik.rentacar.dto.order.CustomerOrderDTO;
import com.mzulfucelik.rentacar.model.customer.Customer;
import com.mzulfucelik.rentacar.service.order.CustomerOrderService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@NoArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController extends AbstractController<Customer, CustomerDTO> {
    private CustomerOrderService customerOrderService;

    @Autowired
    public CustomerController(CustomerOrderService customerOrderService) {
        this.customerOrderService = customerOrderService;
    }

    @GetMapping("/getOldOrders")
    public ResponseEntity<List<CustomerOrderDTO>> getOldOrders(@RequestParam("id") Long id) throws Exception {
        return new ResponseEntity<>(customerOrderService.getOldOrders(id), HttpStatus.OK);
    }
}
