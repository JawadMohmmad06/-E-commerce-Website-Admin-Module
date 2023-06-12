package com.service;

import com.domain.Adminauthority;
import com.domain.Busgrowth;

import java.util.List;

public interface BussGrowthService {

    public Busgrowth insert(Busgrowth busgrowth);

    public Busgrowth get(Long id);

    public List<Busgrowth> getAll();

    public Busgrowth update(Busgrowth busgrowth);

    public void delete(String year);
}
