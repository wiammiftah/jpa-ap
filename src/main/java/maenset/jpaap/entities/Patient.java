package maenset.jpaap.entities;

import com.fasterxml.jackson.databind.DatabindException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@lombok.Data @NoArgsConstructor @AllArgsConstructor

public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private Boolean malade;
    private int score;
}
