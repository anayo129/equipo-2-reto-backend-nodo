package com.backend.retoequipo2.services;

import com.backend.retoequipo2.dto.CourseNameAndDescriptionsDto;
import com.backend.retoequipo2.dto.MaterialNameAndDescriptionsDto;
import com.backend.retoequipo2.model.Course;
import com.backend.retoequipo2.model.Material;
import com.backend.retoequipo2.repositories.BodyRepository;
import com.backend.retoequipo2.repositories.CourseRepository;
import com.backend.retoequipo2.repositories.MaterialRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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
                .orElseThrow(() -> new NoSuchElementException("no hay un material con este id: " + materialId));
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
