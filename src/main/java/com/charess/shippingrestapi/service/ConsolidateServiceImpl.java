package com.charess.shippingrestapi.service;

import com.charess.shippingrestapi.model.Consolidate;
import com.charess.shippingrestapi.repository.ConsolidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("consolidateService")
public class ConsolidateServiceImpl implements ConsolidateService {

    private ConsolidateRepository consolidateRepository;

    @Autowired
    public ConsolidateServiceImpl(ConsolidateRepository consolidateRepository){
        this.consolidateRepository = consolidateRepository;
    }

    @Override
    public Consolidate create(Consolidate consolidate) {
        if(consolidate.getDispatches().size()>0)
            this.consolidateRepository.save(consolidate);
        return null;
    }

    @Override
    public Consolidate getById(Integer id) {
        return this.consolidateRepository.getOne(id);
    }

    @Override
    public List<Consolidate> findAll() {
        return this.consolidateRepository.findAll();
    }

    @Override
    public Consolidate update(Consolidate consolidate) {
        return create(consolidate);
    }
}
