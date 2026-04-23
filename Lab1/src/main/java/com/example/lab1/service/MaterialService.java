package com.example.lab1.service;

import com.example.lab1.domain.entity.Material;
import com.example.lab1.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaterialService {

    private final MaterialRepository materialRepository;
    public List<Material> findAll(){
        return  materialRepository.findAll();
    }
    //ordenar precio de mayor a menor
    public List<Material> ordenarPorPrecio() {
        return materialRepository.findAll().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getPrecio(), e1.getPrecio())) // De mayor a menor
                .toList();
    }

    public Material obtenerCaro(){
        return ordenarPorPrecio().stream()
                .findFirst()
                .orElse(null);
    }

    public List<Material> filtrarLegendario() {
        return materialRepository.findAll().stream()
                .filter(obj -> obj.getRareza() == "Legendario")
                .toList();
    }
    public List<String> filtrarUbicaciones() {
        return materialRepository.findAll().stream()
                .map(Material::getUbicacion)
                .distinct()
                .toList();
    }
}
