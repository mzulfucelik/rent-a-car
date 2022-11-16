package com.mzulfucelik.rentacar.controller.api.order;

import com.mzulfucelik.rentacar.controller.api.AbstractController;
import com.mzulfucelik.rentacar.dto.order.CustomerOrderDTO;
import com.mzulfucelik.rentacar.dto.order.repsonse.StatisticResponse;
import com.mzulfucelik.rentacar.model.order.CustomerOrder;
import com.mzulfucelik.rentacar.service.order.CustomerOrderService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@NoArgsConstructor
@RestController
@RequestMapping("/customerOrder")
public class CustomerOrderController extends AbstractController<CustomerOrder, CustomerOrderDTO> {
    private CustomerOrderService customerOrderService;

    @Autowired
    public CustomerOrderController(CustomerOrderService customerOrderService) {
        this.customerOrderService = customerOrderService;
    }

    @PostMapping("/createOrder")
    public ResponseEntity<CustomerOrderDTO> createOrder(@RequestBody CustomerOrderDTO request) throws Exception {
        return new ResponseEntity<>(customerOrderService.createOrder(request), HttpStatus.CREATED);
    }

    @GetMapping("/finishOrder")
    public ResponseEntity<CustomerOrderDTO> createOrder(@RequestParam("id") Long id) throws Exception {
        return new ResponseEntity<>(customerOrderService.finishOrder(id), HttpStatus.OK);
    }

    @GetMapping("/getStatistics")
    public ResponseEntity<StatisticResponse> createOrder() throws Exception {
        return new ResponseEntity<>(customerOrderService.getStatistics(), HttpStatus.OK);
    }
}
