package com.backend.retoequipo2.services;

import com.backend.retoequipo2.dto.BodyNamesAndDescriptionsDto;
import com.backend.retoequipo2.model.Body;
import com.backend.retoequipo2.repositories.BodyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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

    public List<Body> getAllBodies() {
        return bodyRepository.findAll();
    }

    public Body getBodyById(Long bodyId) {
        return bodyRepository.findById(bodyId)
                .orElseThrow(() -> new NoSuchElementException("no hay un cuerpo con este id: " + bodyId));
    }

    public List<BodyNamesAndDescriptionsDto> getBodyNamesAndDescriptions() {
        List<Body> bodies = bodyRepository.findAll();
        List<BodyNamesAndDescriptionsDto> result = new ArrayList<>();

        for (Body body : bodies) {
            BodyNamesAndDescriptionsDto dto = new BodyNamesAndDescriptionsDto(body.getNombre(), body.getDescripcion());
            result.add(dto);
        }

        return result;
    }
}
