package com.charess.shippingrestapi.service;

import com.charess.shippingrestapi.model.Colis;
import com.charess.shippingrestapi.model.Images;
import com.charess.shippingrestapi.model.Items;
import com.charess.shippingrestapi.repository.ColisRepository;
import com.charess.shippingrestapi.repository.ImagesRepository;
import com.charess.shippingrestapi.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Transactional
@Service("colisService")
public class ColisServiceImpl implements ColisService {

    private ColisRepository colisRepository;
    private ItemsRepository itemsRepository;
    private ImagesRepository imagesRepository;


    @Autowired
    public ColisServiceImpl(ColisRepository colisRepository, ItemsRepository itemsRepository, ImagesRepository imagesRepository) {
        this.colisRepository = colisRepository;
        this.itemsRepository = itemsRepository;
        this.imagesRepository = imagesRepository;
    }


    @Override
    public Colis create(Colis colis) {
        if (colis != null) {
            if (colis.getItems().size() > 0) {
                colis.getItems().forEach((item) -> {
                    if (item.getId() == null) {
                        colis.setQuantity(colis.getQuantity() + item.getQuantity());
                    }
                });
                List<Items> items = colis.getItems();
                this.itemsRepository.saveAll(items);
                colis.setItems(items);
            }
            if (colis.getImages().size() > 0) {
                List<Images> images = colis.getImages();
                this.imagesRepository.saveAll(images);
                colis.setImages(images);
            }
            return this.colisRepository.save(colis);
        }
        return null;
    }


    @Override
    public Optional<Colis> getById(Integer id) {
        return this.colisRepository.findById(id);
    }


    @Override
    public List<Colis> findAll() {
        return this.colisRepository.findAll();
    }


    @Override
    public Colis update(Colis colis) {
        Colis colis1 = create(colis);
        System.out.println("Colis : " + colis1.getQuantity());
        return colis1;
    }


    @Override
    public boolean delete(Integer id) {
        boolean delete = false;
        Colis colis = this.colisRepository.getOne(id);
        if (colis != null) {
            this.colisRepository.delete(colis);
            delete = true;
        }
        return delete;
    }

}
