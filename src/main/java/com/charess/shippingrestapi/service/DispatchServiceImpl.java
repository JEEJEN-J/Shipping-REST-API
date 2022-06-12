package com.charess.shippingrestapi.service;

import com.charess.shippingrestapi.model.Dispatch;
import com.charess.shippingrestapi.repository.DispatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("dispatchService")
public class DispatchServiceImpl implements DispatchService {

    private DispatchRepository dispatchRepository;

    @Autowired
    public DispatchServiceImpl(DispatchRepository dispatchRepository) {
        this.dispatchRepository = dispatchRepository;
    }

    @Override
    public Dispatch create(Dispatch dispatch) {
        return this.dispatchRepository.save(dispatch);
    }

    @Override
    public Dispatch getById(Integer id) {
        return this.dispatchRepository.getOne(id);
    }

    @Override
    public List<Dispatch> findAll() {
        return this.dispatchRepository.findAll();
    }

    @Override
    public Dispatch update(Dispatch dispatch) {
        return create(dispatch);
    }
}
