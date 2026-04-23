package com.example.lab1.repository;

import com.example.lab1.common.MaterialList;
import com.example.lab1.domain.entity.Material;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MaterialRepository {
    private final MaterialList materialList;
    public List<Material> findAll(){
        return materialList.getMaterials();
    }

}
