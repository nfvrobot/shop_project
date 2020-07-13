package by.shopproject.service;

import by.shopproject.dao.CustomerDao;
import by.shopproject.dto.CreateNewCustomerDto;
import by.shopproject.dto.ViewCustomerBasicInfo;
import by.shopproject.dto.ViewCustomerFullInfoDto;
import by.shopproject.entity.Customer;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerService {

    private static final CustomerService INSTANCE = new CustomerService();

    public List<ViewCustomerBasicInfo> getAll() {
        return CustomerDao.getInstance().getAll().stream()
                .map(it -> new ViewCustomerBasicInfo(it.getId(), it.getFirstName(), it.getLastName()))
                .collect(Collectors.toList());
    }

    public ViewCustomerFullInfoDto getById(Integer customerId) {
        return CustomerDao.getInstance().getById(customerId)
                .map(it -> ViewCustomerFullInfoDto.builder()
                        .firstName(it.getFirstName())
                        .lastName(it.getLastName())
                        .email(it.getEmail())
                        .phone(it.getPhone())
                        .address(it.getAddress())
                        .build())
                .orElse(null);
    }

    public ViewCustomerBasicInfo save(CreateNewCustomerDto customer) {
        Customer saveCustomer = CustomerDao.getInstance().save(
                Customer.builder()
                        .firstName(customer.getFirstName())
                        .lastName(customer.getLastName())
                        .email(customer.getEmail())
                        .password(customer.getPassword())
                        .address(customer.getAddress())
                        .phone(customer.getPhone())
                        .build());

        return new ViewCustomerBasicInfo(saveCustomer.getId(), saveCustomer.getFirstName(), saveCustomer.getLastName());
    }

    public static CustomerService getInstance() {
        return INSTANCE;
    }
}
