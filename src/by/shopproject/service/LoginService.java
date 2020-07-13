package by.shopproject.service;

import by.shopproject.dao.CustomerDao;
import by.shopproject.dto.CustomerLoginDto;

import java.util.Optional;

public class LoginService {

    public boolean CustomerExist(CustomerLoginDto customerLoginDto) {
        boolean result = false;
        Optional<Integer> idIfExist = CustomerDao.getInstance().getIdIfExist(customerLoginDto);
        if (idIfExist.isPresent()) {
            result = true;
        }
        return result;
    }

    private static final LoginService INSTANCE = new LoginService();

    public static LoginService getInstance() {
        return INSTANCE;
    }
}
