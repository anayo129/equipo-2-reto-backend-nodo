package com.retoBackendend.equipo2.services;

import com.retoBackendend.equipo2.WebConfig.NotFoundException;
import com.retoBackendend.equipo2.dto.BodyNamesAndDescriptionsDto;
import com.retoBackendend.equipo2.models.Body;
import com.retoBackendend.equipo2.repositories.BodyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Body> getAllBodies() {
        return bodyRepository.findAll();
    }

    public Body getBodyById(Long bodyId) {
        return bodyRepository.findById(bodyId)
                .orElseThrow(() -> new NotFoundException(bodyId, "cuerpo"));
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
