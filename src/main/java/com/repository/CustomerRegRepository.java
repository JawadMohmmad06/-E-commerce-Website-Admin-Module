package com.repository;

import com.domain.Customerreg;

import java.util.List;

public interface CustomerRegRepository {

    public List<Customerreg> getAll();

    public Customerreg create(Customerreg customerreg);

    public Customerreg get(Long id);

    public Customerreg update(Customerreg customerreg);

    public void delete(Long id);
}
