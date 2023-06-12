package com.repository;

import com.domain.Adminauthority;
import com.domain.Trackorder;

import java.util.List;

public interface TrackOrderRepository {

    public List<Trackorder> getAll();

    public Trackorder create(Trackorder trackorder);

    public Trackorder get(Long id);

    public Trackorder update(Trackorder trackorder);

    public void delete(Long id);
}
