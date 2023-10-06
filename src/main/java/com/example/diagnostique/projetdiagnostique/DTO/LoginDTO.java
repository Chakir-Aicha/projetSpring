package com.example.diagnostique.projetdiagnostique.DTO;

import jakarta.persistence.Column;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginDTO {
    private String password;
    private String email;
}
