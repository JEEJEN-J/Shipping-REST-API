package com.charess.shippingrestapi.service;

import com.charess.shippingrestapi.model.Colis;
import com.charess.shippingrestapi.model.Images;
import com.charess.shippingrestapi.model.Items;
import com.charess.shippingrestapi.repository.ColisRepository;
import com.charess.shippingrestapi.repository.ImagesRepository;
import com.charess.shippingrestapi.repository.ItemsRepository;
import com.charess.shippingrestapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service("colisService")
public class ColisServiceImpl implements ColisService {

    private ColisRepository colisRepository;
    private UserRepository userRepository;
    private ItemsRepository itemsRepository;
    private ImagesRepository imagesRepository;

    @Autowired
    public ColisServiceImpl(ColisRepository colisRepository, UserRepository userRepository, ItemsRepository itemsRepository, ImagesRepository imagesRepository) {
        this.colisRepository = colisRepository;
        this.userRepository = userRepository;
        this.itemsRepository = itemsRepository;
        this.imagesRepository = imagesRepository;
    }

    @Override
    public Colis create(Colis colis) {
        List<Items> items = colis.getItems();
        List<Images> images = colis.getImages();
        items.forEach((item) -> {
            this.itemsRepository.save(item);
        });
        images.forEach((image) -> {
            this.imagesRepository.save(image);
        });
        colis.setItems(items);
        colis.setImages(images);
        return this.colisRepository.save(colis);
    }

    @Override
    public Colis getById(Integer id) {
        return this.colisRepository.getOne(id);
    }

    @Override
    public List<Colis> findAll() {
        return this.colisRepository.findAll();
    }

    @Override
    public Colis update(Colis colis) {
        return create(colis);
    }

    @Override
    public boolean delete(Integer id) {
        boolean delete = false;
        Colis colis = this.colisRepository.getOne(id);
        if (colis != null) {
            this.colisRepository.delete(colis);
            delete = false;
        }
        return delete;
    }
}
