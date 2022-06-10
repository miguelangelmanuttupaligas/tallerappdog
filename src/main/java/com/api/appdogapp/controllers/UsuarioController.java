package com.api.appdogapp.controllers;

import com.api.appdogapp.model.Login;
import com.api.appdogapp.model.Usuario;
import com.api.appdogapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService userService;

    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Bean
    public static PasswordEncoder passwordencoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public UsuarioController(UsuarioService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public Usuario login(@RequestBody Login loginDto){
        // add check for username exists in a DB
        System.out.println(loginDto);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("Login success");
        return userService.getUsuario(loginDto.getUsername());
    }
    @DeleteMapping("/{id}")
    public String removeUsuario(@PathVariable Long id){
        // add check for username exists in a DB

        return userService.removeUsuario(id);
    }
    @PostMapping()
    public Usuario saveUsuario(@RequestBody Usuario usuario){
        // add check for username exists in a DB
        if(userService.existsByUsername(usuario.getUsername())){
            return null;
        }

        System.out.println(usuario);
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return userService.saveUser(usuario);
    }
    @GetMapping("/{id}")
    public Optional<Usuario> getUsuario(@PathVariable Long id){
    return userService.getUsuario(id);
    }
}
