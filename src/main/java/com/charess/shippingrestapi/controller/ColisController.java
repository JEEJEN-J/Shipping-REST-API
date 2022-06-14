package com.charess.shippingrestapi.controller;

import com.charess.shippingrestapi.model.Colis;
import com.charess.shippingrestapi.service.ColisService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/colis")
public class ColisController {

    private ColisService colisService;

    @Autowired
    public ColisController(ColisService colisService) {
        this.colisService = colisService;
    }

    @Operation(summary = "Créer un colis, vous devez spécifier les propriétés ci-dessous dans la demande. Si vous n'êtes pas connecté pour effectuer cette action, un 401 Unauthorized état est renvoyé.")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody Colis colis) {
        HttpHeaders textPlainHeaders = new HttpHeaders();
        textPlainHeaders.setContentType(MediaType.TEXT_PLAIN);
        try {
            if (colis == null) {
                return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
            }
            if (colis.getId() == null) {
                if (colis.getItems().size() == 0) {
                    return new ResponseEntity<>("Error item can't null : " + HttpStatus.CONFLICT, textPlainHeaders, HttpStatus.CONFLICT);
                }
            }
            Object object = this.colisService.create(colis);
            System.out.println("Object : "+object);
            return ResponseEntity.ok(object);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }


    @Operation(summary = "Modifier un colis, vous devez spécifier les propriétés ci-dessous dans la demande. Si vous n'êtes pas connecté pour effectuer cette action, un 401 Unauthorized état est renvoyé.")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Colis colis) {
        try {
            return ResponseEntity.ok(colisService.update(colis));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Operation(summary = "")
    @RequestMapping(value = "/{ID}", method = RequestMethod.GET)
    public ResponseEntity<?> getColisById(@PathVariable("ID") Integer id) {
        Object object = this.colisService.getById(id);
        return ResponseEntity.ok(object);
    }

    @Operation(summary = "")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllColis() {
        List<?> objects = this.colisService.findAll();
        return ResponseEntity.ok(objects);
    }

}
