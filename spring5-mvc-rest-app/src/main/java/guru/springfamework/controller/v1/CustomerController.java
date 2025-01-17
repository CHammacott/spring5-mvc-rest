package guru.springfamework.controller.v1;


import guru.springfamework.services.CustomerService;
import guru.springframework.model.CustomerDTO;
import guru.springframework.model.CustomerListDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(value ="onlinestore",description = "This is my Customer Controller")
@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

    public static final String BASE_URL = "/api/v1/customers";

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ApiOperation(value = "This will get the list of customers.", notes = "These are some notes about the API.")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomerListDTO getListOfCustomers(){
        CustomerListDTO customerListDTO = new CustomerListDTO();
        customerListDTO.getCustomers().addAll(customerService.getAllCustomers());
        return customerListDTO;
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createNewCustomer(@RequestBody() CustomerDTO customerDTO){
        return customerService.createNewCustomer(customerDTO);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody() CustomerDTO customerDTO){
        return customerService.saveCustomerById(id, customerDTO);
    }

    @PatchMapping({"/{id}"})
    public CustomerDTO patchCustomer(@PathVariable Long id, @RequestBody() CustomerDTO customerDTO){
        return customerService.patchCustomer(id, customerDTO);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomerById(id);
    }

}
