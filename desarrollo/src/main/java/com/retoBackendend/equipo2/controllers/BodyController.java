package com.retoBackendend.equipo2.controllers;

import com.retoBackendend.equipo2.repositories.BodyRepository;
import com.retoBackendend.equipo2.services.BodyService;
import com.retoBackendend.equipo2.dto.BodyNamesAndDescriptionsDto;
import com.retoBackendend.equipo2.dto.BodyRequestDto;
import com.retoBackendend.equipo2.models.Body;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping
public class BodyController {

    private  final BodyService bodyService;

    @Autowired
    public BodyController(BodyService bodyService){

        this.bodyService = bodyService;
    }

    @PostMapping("/api/body")
    public ResponseEntity<Body> createBody(@RequestBody BodyRequestDto bodyRequestDto) {
        Body body = new Body();
        body.setNombre(bodyRequestDto.getNombre());
        body.setImagen(bodyRequestDto.getImagen());
        body.setDescripcion(bodyRequestDto.getDescripcion());

        Body createdBody = bodyService.saveBody(body);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdBody);
    }

    @GetMapping("/api/body")
    public List<Body> getAllBodies() {
        return bodyService.getAllBodies();
    }

    @GetMapping("/api/body/{bodyId}")
    public Body getBodyById(@PathVariable Long bodyId) {
        return bodyService.getBodyById(bodyId);
    }

    @GetMapping("/api/body/names-descriptions")
    public List<BodyNamesAndDescriptionsDto> getBodyNamesAndDescriptions() {
        return bodyService.getBodyNamesAndDescriptions();
    }

    

}
