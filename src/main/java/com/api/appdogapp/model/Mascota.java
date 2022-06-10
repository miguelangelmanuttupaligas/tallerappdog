package com.api.appdogapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="mascota")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mascota implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fechaNacimiento;
    private char sexo;
    private String especie;
    private int estado;
    private String nombre;
    private String imagen;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    private Estado state;

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Mascota))
            return false;
        Mascota mascota = (Mascota) o;
        return Objects.equals(this.id, mascota.id)
                && Objects.equals(this.fechaNacimiento, mascota.fechaNacimiento)
                && Objects.equals(this.sexo, mascota.sexo)
                && Objects.equals(this.especie,mascota.especie)
                && Objects.equals(this.estado,mascota.estado)
                && Objects.equals(this.nombre,mascota.nombre)
                && Objects.equals(this.imagen,mascota.imagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id,
                this.fechaNacimiento,
                this.sexo,
                this.especie,
                this.estado,
                this.nombre,
                this.imagen);
    }

}
