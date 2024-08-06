package com.example.connectspring.service;

import com.example.connectspring.model.Customer;
import com.example.connectspring.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findCustomerPage(int pageNumber, int pagesize) {
        Page<Customer> products =customerRepository.findAll(PageRequest.of(pageNumber,pagesize));
        return  products;
    }

    @Override
    public Page<Customer> findCustomerPageandSort(String feild, int pageNumber, int pagesize) {
       Page<Customer> productSort =customerRepository.findAll(PageRequest.of(pageNumber,pagesize).withSort(Sort.by(Sort.Direction.DESC,feild)));
       return  productSort;
    }

    @Override
    public Customer getById(Integer id) {
        return customerRepository.findById(id).get();
    }

    @Autowired
   private CustomerRepository repository;
    @Override
    public Customer addCustomer(Customer customer) {
        if(customer != null)
        {
            return repository.save(customer);
        }
        return null;
    }

    @Override
    public Customer updateCustomer(Integer id, Customer customer) {
        if(customer != null)
        {
            Customer customer1=repository.getById(id);
            if(customer1!=null)
            {
                customer1.setName(customer.getName());
                customer1.setEmail(customer.getEmail());
                customer1.setAge(customer.getAge());
                return repository.save(customer1);
            }
        }
        return null;
    }

    @Override
    public boolean deleteCustomer(Integer id) {
        if(id>=1)
        {
            Customer customer=repository.getById(id); // lấy ra id cần xóa
            if(customer!=null)
            {
                repository.delete(customer);  // xóa customer với id cần xóa
                return true;

            }

        }
        return false;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @Override
    public Customer getCustomer(Integer id) {
        return repository.getById(id);
    }

    @Override
    public List<Customer> getSortCustomer(String feild) {
        return repository.findAll(Sort.by(Sort.Direction.DESC, feild));

    }

}
