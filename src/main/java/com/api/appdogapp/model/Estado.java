package com.api.appdogapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="estado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Estado))
            return false;
        Estado estado = (Estado) o;
        return Objects.equals(this.id, estado.id)
                && Objects.equals(this.nombre, estado.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id,
                this.nombre);
    }

}
