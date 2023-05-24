package com.backend.retoequipo2.controllers;

import com.backend.retoequipo2.model.Body;
import com.backend.retoequipo2.services.BodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/body")
public class BodyController {

    private  final BodyService bodyService;

    @Autowired
    public BodyController(BodyService bodyService){
        this.bodyService = bodyService;
    }

    @PostMapping
    public ResponseEntity<Body> createBody(@RequestBody Body body) {
        Body savedBody = bodyService.saveBody(body);
        return new ResponseEntity<>(savedBody, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Body>> getAllBody() {
        List<Body> bodies = bodyService.getAllBodys();
        return new ResponseEntity<>(bodies, HttpStatus.OK);
    }
}
