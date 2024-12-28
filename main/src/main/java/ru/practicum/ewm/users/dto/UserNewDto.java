package ru.practicum.ewm.users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserNewDto {

    @NotBlank
    @Size(min = 2, max = 250)
    private String name;

    @NotEmpty
    @Email
    @Size(min = 6, max = 254)
    private String email;
}
