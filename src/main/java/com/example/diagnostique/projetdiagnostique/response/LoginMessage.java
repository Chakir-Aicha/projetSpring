package com.example.diagnostique.projetdiagnostique.response;

import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class LoginMessage {
    private String message;
    private Boolean status;
}
