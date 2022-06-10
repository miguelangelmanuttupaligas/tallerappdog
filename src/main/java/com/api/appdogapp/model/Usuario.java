package com.api.appdogapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String apellidos;
    private String direccion;
    private String rol;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Usuario))
            return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(this.id, usuario.id)
                && Objects.equals(this.username, usuario.username)
                && Objects.equals(this.password, usuario.password)
                && Objects.equals(this.email, usuario.email)
                && Objects.equals(this.apellidos, usuario.apellidos)
                && Objects.equals(this.direccion, usuario.direccion)
                && Objects.equals(this.rol,usuario.rol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id,
                this.username,
                this.password,
                this.email,
                this.apellidos,
                this.direccion,
                this.rol);
    }
}
