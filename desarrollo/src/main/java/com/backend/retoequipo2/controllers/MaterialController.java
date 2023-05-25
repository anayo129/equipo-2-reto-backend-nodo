package com.backend.retoequipo2.controllers;
import com.backend.retoequipo2.dto.MaterialNameAndDescriptionsDto;
import com.backend.retoequipo2.dto.MaterialRequestDto;
import com.backend.retoequipo2.model.Course;
import com.backend.retoequipo2.model.Material;
import com.backend.retoequipo2.repositories.CourseRepository;
import com.backend.retoequipo2.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
//@RequestMapping("/api/material")
public class MaterialController {

    private final CourseRepository courseRepository;
    private final MaterialService materialService;

    @Autowired
    public MaterialController(CourseRepository courseRepository, MaterialService materialService) {
        this.courseRepository = courseRepository;
        this.materialService = materialService;
    }

    @PostMapping("/api/material")
    public ResponseEntity<Material> createMaterial(@RequestBody MaterialRequestDto materialRequestDto) {
        Material material = new Material();
        material.setNombre(materialRequestDto.getNombre());
        material.setPrecio(materialRequestDto.getPrecio());
        material.setImagen(materialRequestDto.getImagen());
        material.setDescripcion(materialRequestDto.getDescripcion());

        // Obtener el Body correspondiente al ID recibido en el DTO
        Long courseId = materialRequestDto.getId_curso();
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new NoSuchElementException("No existe un cuerpo con este id: " + courseId));

        material.setId_curso(course);

        Material createdMaterial = materialService.createMaterial(material);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdMaterial);
    }

    @GetMapping("/api/material")
    public List<Material> getAllMaterial() {

        return materialService.getAllMaterial();
    }

    @GetMapping("/api/material/{materialId}")
    public Material getMaterialById(@PathVariable Long materialId) {
        return materialService.getMaterialById(materialId);
    }

    @GetMapping("/api/material/names-descriptions")
    public List<MaterialNameAndDescriptionsDto> getMaterialNamesAndDescriptions() {
        return materialService.getMaterialNamesAndDescriptions();
    }


}
