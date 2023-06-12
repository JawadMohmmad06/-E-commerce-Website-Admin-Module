package com.repository;

import com.domain.Adminauthority;
import com.domain.Busgrowth;

import java.util.List;

public interface BusGrowthRepository {

    public List<Busgrowth> getAll();

    public Busgrowth create(Busgrowth busgrowth);

    public Busgrowth get(Long id);

    public Busgrowth update(Busgrowth busgrowth);

    public void delete(String year);
    public Busgrowth getbyyear(String year);
}
