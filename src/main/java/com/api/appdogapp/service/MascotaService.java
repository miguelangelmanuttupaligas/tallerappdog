package com.api.appdogapp.service;

import com.api.appdogapp.model.Mascota;
import com.api.appdogapp.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MascotaService {

    private final MascotaRepository repository;

    @Autowired
    public MascotaService(MascotaRepository repository) {
        this.repository = repository;
    }

    public  Mascota saveMascota(Mascota mascota){
        return repository.save(mascota);
    }

    public ArrayList<Mascota> getMascotas(){
        return (ArrayList<Mascota>) repository.findAll();
    }

    public Optional<Mascota> showMascota(int id){
        return repository.findById(id);
    }

    public String removeMascota(int id){
        System.out.println("id: "+id);
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Remove successful";
        }
        else return "Remove not success, pet not exits in database";
    }

    public Mascota updateMascota(Mascota mascota){
        return repository.save(mascota);
    }
}
