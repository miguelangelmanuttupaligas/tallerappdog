package com.api.appdogapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "solicitud")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Solicitud implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idUsuario;
    private Long idMascota;
    private int estado;
    private String mensaje;
    private String fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    private Mascota mascota;

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Solicitud))
            return false;
        Solicitud solicitud = (Solicitud) o;
        return Objects.equals(this.id, solicitud.id)
                && Objects.equals(this.estado, solicitud.estado)
                && Objects.equals(this.mensaje, solicitud.mensaje)
                && Objects.equals(this.fecha,solicitud.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id,
                this.estado,
                this.mensaje,
                this.fecha);
    }
}
