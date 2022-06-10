package com.api.appdogapp.service;

import com.api.appdogapp.model.Usuario;
import com.api.appdogapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository userRepository;

    @Autowired
    public UsuarioService(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Usuario saveUser(Usuario user){
        return userRepository.save(user);
    }
    public Optional<Usuario> getUsuario(Long id){
        return userRepository.findById(id);
    }
    public Usuario getUsuario(String username){
        return userRepository.findByUsername(username);
    }
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
    public String removeUsuario(Long id){
        userRepository.deleteById(id);
        return "Remove successful";
    }
}
