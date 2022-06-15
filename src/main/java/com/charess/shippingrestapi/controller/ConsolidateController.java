package com.charess.shippingrestapi.controller;

import com.charess.shippingrestapi.model.Colis;
import com.charess.shippingrestapi.model.Consolidate;
import com.charess.shippingrestapi.service.ConsolidateService;
import io.swagger.v3.oas.annotations.Operation;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/consolidate")
public class ConsolidateController {

    private ConsolidateService consolidateService;

    @Autowired
    public ConsolidateController(ConsolidateService consolidateService) {
        this.consolidateService = consolidateService;
    }

    @Operation(summary = "Créer un consolidate, vous devez spécifier les propriétés ci-dessous dans la demande. Si vous n'êtes pas connecté pour effectuer cette action, un 401 Unauthorized état est renvoyé.")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody Consolidate consolidate) {
        HttpHeaders textPlainHeaders = new HttpHeaders();
        textPlainHeaders.setContentType(MediaType.TEXT_PLAIN);
        try {
            if (consolidate == null) {
                return new ResponseEntity<>("Error consolidate can't null : ", HttpStatus.BAD_REQUEST);
            }
            if (consolidate.getId() == null) {
                if (consolidate.getDispatches().size() == 0) {
                    return new ResponseEntity<>("Error consolidate exist : " + HttpStatus.CONFLICT, textPlainHeaders, HttpStatus.CONFLICT);
                }
            }
            Object object = this.consolidateService.create(consolidate);
            System.out.println("Object : " + object);
            return ResponseEntity.ok(object);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Operation(summary = "")
    @RequestMapping(value = "/{ID}", method = RequestMethod.GET)
    public ResponseEntity<?> getConsolidateById(@PathVariable("ID") Integer id) {
        Object object = this.consolidateService.getById(id);
        return ResponseEntity.ok(object);
    }


    @Operation(summary = "")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllConsolidates() {
        List<?> objects = this.consolidateService.findAll();
        return ResponseEntity.ok(objects);
    }

    @Operation(summary = "Modifier un consolidate, vous devez spécifier les propriétés ci-dessous dans la demande. Si vous n'êtes pas connecté pour effectuer cette action, un 401 Unauthorized état est renvoyé.")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Consolidate consolidate) {
        try {
            return ResponseEntity.ok(consolidateService.update(consolidate));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

}
