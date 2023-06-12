package com.service;

import com.domain.Adminauthority;
import com.domain.Trackorder;
import com.repository.AuthorityRepository;
import com.repository.TrackOrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TrackOrderImplService implements TracOrderService {

    private TrackOrderRepository trackOrderRepository;

    public TrackOrderImplService(TrackOrderRepository trackOrderRepository) {
        this.trackOrderRepository = trackOrderRepository;
    }

    @Transactional
    public Trackorder insert(Trackorder trackorder) {
        return trackOrderRepository.create(trackorder);
    }

    @Transactional(readOnly = true)
    public Trackorder get(Long id) {
        return trackOrderRepository.get(id);
    }

    @Transactional(readOnly = true)
    public List<Trackorder> getAll() {
        return trackOrderRepository.getAll();
    }

    @Transactional
    public Trackorder update(Trackorder trackorder) {
        return trackOrderRepository.update(trackorder);
    }

    @Transactional
    public void delete(Long id) {
        trackOrderRepository.delete(id);
    }
}
