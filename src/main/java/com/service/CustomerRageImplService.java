package com.service;

import com.domain.Adminauthority;
import com.domain.Customerreg;
import com.repository.AuthorityRepository;
import com.repository.CustomerRegRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerRageImplService implements CustomerRegService {

    private CustomerRegRepository customerRegRepository;

    public CustomerRageImplService(CustomerRegRepository customerRegRepository) {
        this.customerRegRepository = customerRegRepository;
    }

    @Transactional
    public Customerreg insert(Customerreg customerreg) {
        return customerRegRepository.create(customerreg);
    }

    @Transactional(readOnly = true)
    public Customerreg get(Long id) {
        return customerRegRepository.get(id);
    }

    @Transactional(readOnly = true)
    public List<Customerreg> getAll() {
        return customerRegRepository.getAll();
    }

    @Transactional
    public Customerreg update(Customerreg customerreg) {
        return customerRegRepository.update(customerreg);
    }

    @Transactional
    public void delete(Long id) {
        customerRegRepository.delete(id);
    }
}
