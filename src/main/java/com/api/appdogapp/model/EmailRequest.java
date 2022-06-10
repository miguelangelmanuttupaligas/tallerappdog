package com.api.appdogapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailRequest {
    private String email;//para quien envias
    private String tema;
    private String mensaje;
}
