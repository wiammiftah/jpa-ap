package maenset.jpaap.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.crypto.Data;
@lombok.Data @NoArgsConstructor @AllArgsConstructor

public class Patient {
    private Long id;
    private String nom;
    private Data dateNaissance;
    private Boolean malade;
    private int score;
}
