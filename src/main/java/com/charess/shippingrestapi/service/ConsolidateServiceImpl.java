package com.charess.shippingrestapi.service;

import com.charess.shippingrestapi.model.Consolidate;
import com.charess.shippingrestapi.repository.ConsolidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service("consolidateService")
public class ConsolidateServiceImpl implements ConsolidateService {

    private ConsolidateRepository consolidateRepository;

    @Autowired
    public ConsolidateServiceImpl(ConsolidateRepository consolidateRepository) {
        this.consolidateRepository = consolidateRepository;
    }

    @Override
    public Consolidate create(Consolidate consolidate) {
        if (consolidate.getDispatches().size() > 0) {
            consolidate.getDispatches().forEach(dispatch -> {
                consolidate.setWeight(consolidate.getWeight() + dispatch.getWeight());
                consolidate.setPrice(consolidate.getPrice() + dispatch.getPrice());
            });
            return this.consolidateRepository.save(consolidate);
        }
        return null;
    }

    @Override
    public Optional<Consolidate> getById(Integer id) {
        return this.consolidateRepository.findById(id);
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
