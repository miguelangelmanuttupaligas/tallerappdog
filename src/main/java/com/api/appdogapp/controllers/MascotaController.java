package com.api.appdogapp.controllers;

import com.api.appdogapp.model.Mascota;
import com.api.appdogapp.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("mascotas")
public class MascotaController {

    private final MascotaService mascotaService;

    @Autowired
    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @PostMapping("/guardar")
    public Mascota addMascota(@RequestBody Mascota mascota) {
        System.out.println(mascota.toString());
        return mascotaService.saveMascota(mascota);
    }

    @GetMapping("/listar")
    public ArrayList<Mascota> getMascotas(){
        return mascotaService.getMascotas();
    }

    @GetMapping("/buscar/{id}")
    public Optional<Mascota> showMascota(@PathVariable int id){
        return mascotaService.showMascota(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public String removeMascota(@PathVariable int id){
        System.out.println("id: "+id);
        return mascotaService.removeMascota(id);
    }

    @PutMapping("/actualizar")
    public Mascota updateMascota(@RequestBody Mascota mascota){
        return mascotaService.updateMascota(mascota);
    }
}
