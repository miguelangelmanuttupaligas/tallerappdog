package com.api.appdogapp.controllers;

import com.api.appdogapp.model.Solicitud;
import com.api.appdogapp.service.SolicitudService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SolicitudController {
    private final SolicitudService solicitudService;

    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }
    @PostMapping("/solicitud")
    public Solicitud saveSolicitud(@RequestBody Solicitud solicitud) {
        return solicitudService.saveSolicitud(solicitud);
    }
    @DeleteMapping("/solicitud/{id}")
    public void removeSolicitud(@PathVariable long id){
        solicitudService.removeSolicitud(id);
    }

    @GetMapping("/solicitud/{id}")
    public Optional<Solicitud> getSolicitud(@PathVariable long id){
        return solicitudService.getSolicitud(id);
    }
    @GetMapping("/solicitudes")
    public List<Solicitud> getSolicitudes(){
        return solicitudService.getSolicitudes();
    }
}
