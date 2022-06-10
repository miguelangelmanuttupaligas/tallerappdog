package com.api.appdogapp.service;

import com.api.appdogapp.model.Solicitud;
import com.api.appdogapp.repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitudService {

    private final SolicitudRepository solicitudRepository;

    @Autowired
    public SolicitudService(SolicitudRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }

    public Solicitud saveSolicitud(Solicitud solicitud){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("dd/MM/yyyy-> "+dtf.format(LocalDateTime.now()));
        solicitud.setFecha(dtf.format(LocalDateTime.now()));
        return solicitudRepository.save(solicitud);
    }
    public List<Solicitud> getSolicitudes() {

        return solicitudRepository.findAll();
    }
    public Optional<Solicitud> getSolicitud(long id){
        return solicitudRepository.findById(id);
    }

    public void removeSolicitud(long id) {
        solicitudRepository.deleteById(id);
    }
}
