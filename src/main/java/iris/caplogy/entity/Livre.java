package iris.caplogy.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Livre extends Document {
    @NotBlank(message = "nbPages is mandatory")
    private Integer nbPages;
    @NotBlank(message = "genre is mandatory")
    private String genre;

    // Getters et Setters
}
