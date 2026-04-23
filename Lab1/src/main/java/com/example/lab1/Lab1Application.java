package com.example.lab1;

import com.example.lab1.domain.entity.Material;
import com.example.lab1.service.MaterialService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab1Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab1Application.class, args);
    }

    @Bean
    public CommandLineRunner run(MaterialService materialService) {
        return args -> {
            System.out.println("=== INICIANDO APP ===");
            materialService.findAll().forEach(p ->
                    System.out.println("Nombre: " + p.getNombre() + " | "+ "Categoria: " + p.getCategoria() + " | "+ "Precio: "+ p.getPrecio()+ " Rupias" )
            );
            System.out.println("=== MATERIAL MAS CARO ===");
            Material caro = materialService.obtenerCaro();

            if (caro != null) {
                System.out.println("Nombre: " + caro.getNombre() + " | "+ "Categoria: " + caro.getCategoria() + " | "+ "Precio: "+ caro.getPrecio()+ " Rupias" );
            } else {
                System.out.println("No hay materiales disponibles");
            }
            System.out.println("=== MATERIALES DE RAREZA LEGENDARIA ===");
            materialService.filtrarLegendario().forEach(p ->
                    System.out.println("Nombre: " + p.getNombre() + " | "+ "Categoria: " + p.getCategoria() + " | "+ "Precio: "+ p.getPrecio()+ " Rupias" )
            );

            System.out.println("=== LISTA DE UBICACIONES ===");
            materialService.filtrarUbicaciones().forEach(System.out::println
            );

        };
    }


}
