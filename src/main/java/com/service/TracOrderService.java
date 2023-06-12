package com.service;

import com.domain.Adminauthority;
import com.domain.Trackorder;

import java.util.List;

public interface TracOrderService {

    public Trackorder insert(Trackorder trackorder);

    public Trackorder get(Long id);

    public List<Trackorder> getAll();

    public Trackorder update(Trackorder trackorder);

    public void delete(Long id);
}
