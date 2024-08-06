package com.example.connectspring.service;

import com.example.connectspring.model.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService {
    // hàm thêm nhân viên
    public Customer addCustomer(Customer customer);


    // hàm sửa thông tin nhân viên
    public Customer updateCustomer(Integer id,Customer customer);


    // hàm xóa nhân viên
    public boolean deleteCustomer(Integer id); // boolean xóa được hay không


    // hàm lấy ra danh sách nhân viên
    public List<Customer> getAllCustomers();

    // hàm lấy ra 1 nhân viên
    public Customer getCustomer(Integer id);

   // hàm sắp xếp nhân viên
    public List<Customer> getSortCustomer(String feild);

    // phân trang
    public Page<Customer> findCustomerPage(int pageNumber, int pagesize);

    // phân trang và sắp xếp field
    public Page<Customer> findCustomerPageandSort(String feild, int pageNumber, int pagesize);

    public Customer getById(Integer id);
}
