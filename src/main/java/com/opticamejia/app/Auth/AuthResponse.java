package com.opticamejia.app.Auth;

import com.opticamejia.app.User.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    String token;
    String email;
    String firstname;
    String lastname;
    Role role;
}
