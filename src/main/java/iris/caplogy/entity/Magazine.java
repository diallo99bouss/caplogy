package iris.caplogy.entity;

import jakarta.persistence.*;

@Entity
public class Magazine extends Document {
    private String editeur;
    private String frequencePub;
    private Integer numeroParution;

    // Getters et Setters
}
