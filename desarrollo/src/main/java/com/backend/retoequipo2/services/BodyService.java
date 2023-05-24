package com.backend.retoequipo2.services;

import com.backend.retoequipo2.model.Body;
import com.backend.retoequipo2.repositories.BodyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BodyService {

    private  final BodyRepository bodyRepository;

    @Autowired
    public BodyService(BodyRepository bodyRepository){
        this.bodyRepository = bodyRepository;
    }

    public Body saveBody(Body body) {
        return bodyRepository.save(body);
    }

    public List<Body> getAllBodys() {
        return bodyRepository.findAll();
    }
}
