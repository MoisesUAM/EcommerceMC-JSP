package net.mcoto.app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "users", schema = "EcommerceDB")
public class UserModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "BINARY(16)")
    private UUID id;

    @Basic
    @Column(name = "userName")
    private String userName;
    @Basic
    @Column(name = "isActive")
    private boolean isActive;
    @Basic
    @Column(name = "idPerson", nullable = false)
    private UUID idPerson;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "email")
    private String email;

    @JsonIgnoreProperties({"users", "hibernateLazyInitializer", "handler"})
    @ManyToOne
    @JoinColumn(name = "idPerson", referencedColumnName = "id", insertable = false, updatable = false)
    private PersonModel person;

}
