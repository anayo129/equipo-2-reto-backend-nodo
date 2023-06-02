package com.retoBackendend.equipo2.services;


import com.retoBackendend.equipo2.repositories.CourseRepository;
import com.retoBackendend.equipo2.config.NotFoundException;
import com.retoBackendend.equipo2.dto.MaterialNameAndDescriptionsDto;
import com.retoBackendend.equipo2.models.Material;
import com.retoBackendend.equipo2.repositories.MaterialRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaterialService {

    private final CourseRepository courseRepository;
    private final MaterialRepository materialRepository;

    public MaterialService(CourseRepository courseRepository, MaterialRepository materialRepository) {
        this.courseRepository = courseRepository;
        this.materialRepository = materialRepository;
    }

    public Material createMaterial(Material material) {

        return materialRepository.save(material);
    }

    public List<Material> getAllMaterial() {

        return materialRepository.findAll();
    }

    public Material getMaterialById(Long materialId) {
        return materialRepository.findById(materialId)
                .orElseThrow(() -> new NotFoundException(materialId, "material"));
    }

    public List<MaterialNameAndDescriptionsDto> getMaterialNamesAndDescriptions() {
        List<Material> materials = materialRepository.findAll();
        List<MaterialNameAndDescriptionsDto> result = new ArrayList<>();

        for (Material material : materials) {
            MaterialNameAndDescriptionsDto dto = new MaterialNameAndDescriptionsDto(material.getNombre(), material.getDescripcion());
            result.add(dto);
        }

        return result;
    }
}
