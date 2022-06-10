package com.api.appdogapp.service;

import com.api.appdogapp.detail.CustomUserDetail;
import com.api.appdogapp.model.Usuario;
import com.api.appdogapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService{

    private final UsuarioRepository repository;
    @Autowired
    public CustomUserDetailService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario=repository.findByUsername(username);
        if (usuario==null)
            throw new UsernameNotFoundException("El usuario no es valida");
        return new CustomUserDetail(usuario);
    }
}
