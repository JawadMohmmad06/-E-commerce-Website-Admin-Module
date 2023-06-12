package com.service;

import com.domain.Adminauthority;
import com.domain.Customerreg;

import java.util.List;

public interface CustomerRegService {

    public Customerreg insert(Customerreg customerreg);

    public Customerreg get(Long id);

    public List<Customerreg> getAll();

    public Customerreg update(Customerreg customerreg);

    public void delete(Long id);
}
