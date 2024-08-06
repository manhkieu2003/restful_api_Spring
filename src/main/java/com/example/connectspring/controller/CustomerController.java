package com.example.connectspring.controller;

import com.example.connectspring.model.Customer;
import com.example.connectspring.service.CustomerService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @GetMapping("/")
    public String test()
    {
        return "timeday";
    }
    //api add customer
    @PostMapping("/add")
    public Customer add(@RequestBody Customer customer)
    {
        return customerService.addCustomer(customer);
    }
    //api update customer
    @PutMapping("/update")
    public Customer update(@RequestParam("id") Integer id, @RequestBody Customer customer)
    {
        return customerService.updateCustomer(id,customer);
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id)
    {
        return  customerService.deleteCustomer(id);
    }
    // api lấy danh sách
    @GetMapping("/list")
    public   List<Customer> list(Model model)
    {




        return customerService.getAllCustomers();
    }
    @GetMapping("/list/{id}")
    public Customer listId(@PathVariable Integer id)
    {
        return customerService.getCustomer(id);
    }
    @GetMapping("/{feild}")
    public List<Customer>  Sortage(@PathVariable String feild)
    {
        return customerService.getSortCustomer(feild);
    }
    @GetMapping("/pagination/{pageNumber}/{pagesize}")
    public Page<Customer> PaginationCustomer(@PathVariable Integer pageNumber, @PathVariable Integer pagesize)
    {
        return customerService.findCustomerPage(pageNumber,pagesize);
    }
    @GetMapping("/pagination/{feild}/{pageNumber}/{pagesize}")
    public Page<Customer> PaginationandSortCustomer(@PathVariable String feild, @PathVariable Integer pageNumber, @PathVariable Integer pagesize)
    {
        return  customerService.findCustomerPageandSort(feild,pageNumber,pagesize);
    }
    @GetMapping("/{id}")
    public Customer getIdCustomer(@PathVariable Integer id)     //lấy giá trị id đang bị fail
    {
        return customerService.getById(id);
    }

}
