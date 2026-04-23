package com.example.lab1.common;

import com.example.lab1.domain.entity.Material;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MaterialList {
    private final List<Material> materials;
    public MaterialList(){
        this.materials = new ArrayList<>();

        this.materials.add(
                Material.builder()
                .id(1L)
                .nombre("Ámbar Rojo")
                .categoria("Mineral")
                .efecto("Defensa")
                .precio(30)
                .ubicacion("Desierto Gerudo")
                .rareza("Legendario")
                        .build());


        this.materials.add(
                Material.builder()
                        .id(2L)
                        .nombre("Pimienta Ardiente")
                        .categoria("Planta")
                        .efecto("Corazones")
                        .precio(10)
                        .ubicacion("Cordillera de Hebra")
                        .rareza("Común")
                        .build());

        this.materials.add(
                Material.builder()
                        .id(3L)
                        .nombre("Ala de Keese")
                        .categoria("Parte de Monstruo")
                        .efecto("Sigilo")
                        .precio(15)
                        .ubicacion("Desierto Gerudo")
                        .rareza("Raro")
                        .build());

    }
    public List<Material> getMaterials(){
        return materials;
    }

}
