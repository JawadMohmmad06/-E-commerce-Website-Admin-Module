package com.service;

import com.domain.Adminauthority;
import com.domain.Busgrowth;
import com.repository.AuthorityRepository;
import com.repository.BusGrowthRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BusGrowthserviceimp implements BussGrowthService {

    private BusGrowthRepository busGrowthRepository;

    public BusGrowthserviceimp(BusGrowthRepository busGrowthRepository) {
        this.busGrowthRepository = busGrowthRepository;
    }

    @Transactional
    public Busgrowth insert(Busgrowth busgrowth) {
        return busGrowthRepository.create(busgrowth);
    }

    @Transactional(readOnly = true)
    public Busgrowth get(Long id) {
        return busGrowthRepository.get(id);
    }

    @Transactional(readOnly = true)
    public List<Busgrowth> getAll() {
        return busGrowthRepository.getAll();
    }

    @Transactional
    public Busgrowth update(Busgrowth busgrowth) {
        return busGrowthRepository.update(busgrowth);
    }

    @Transactional
    public void delete(String year) {
        busGrowthRepository.delete(year);
    }
}
