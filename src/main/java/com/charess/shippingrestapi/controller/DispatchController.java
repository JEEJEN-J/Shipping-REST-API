package com.charess.shippingrestapi.controller;

import com.charess.shippingrestapi.model.Colis;
import com.charess.shippingrestapi.model.Consolidate;
import com.charess.shippingrestapi.model.Dispatch;
import com.charess.shippingrestapi.service.DispatchService;
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
@RequestMapping("/api/dispatch")
public class DispatchController {

    private DispatchService dispatchService;

    @Autowired
    public DispatchController(DispatchService dispatchService) {
        this.dispatchService = dispatchService;
    }


    @Operation(summary = "Créer un dispatch, vous devez spécifier les propriétés ci-dessous dans la demande. Si vous n'êtes pas connecté pour effectuer cette action, un 401 Unauthorized état est renvoyé.")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody Dispatch dispatch) {
        HttpHeaders textPlainHeaders = new HttpHeaders();
        textPlainHeaders.setContentType(MediaType.TEXT_PLAIN);
        try {
            if (dispatch == null) {
                return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
            }
            if (dispatch.getId() == null) {
                if (dispatch.getColis().size() == 0) {
                    return new ResponseEntity<>("Error dispatch can't null : " + HttpStatus.CONFLICT, textPlainHeaders, HttpStatus.CONFLICT);
                }
            }
            Object object = this.dispatchService.create(dispatch);
            System.out.println("Object : " + object);
            return ResponseEntity.ok(object);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Operation(summary = "")
    @RequestMapping(value = "/{ID}", method = RequestMethod.GET)
    public ResponseEntity<?> getDispatchById(@PathVariable("ID") Integer id) {
        Object object = this.dispatchService.getById(id);
        return ResponseEntity.ok(object);
    }

    @Operation(summary = "")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllDispatches() {
        List<?> objects = this.dispatchService.findAll();
        return ResponseEntity.ok(objects);
    }

    @Operation(summary = "Modifier un dispatch, vous devez spécifier les propriétés ci-dessous dans la demande. Si vous n'êtes pas connecté pour effectuer cette action, un 401 Unauthorized état est renvoyé.")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Dispatch dispatch) {
        try {
            return ResponseEntity.ok(dispatchService.update(dispatch));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

}
