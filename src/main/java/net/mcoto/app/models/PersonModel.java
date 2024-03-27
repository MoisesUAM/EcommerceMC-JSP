package net.mcoto.app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Moises Coto Salazar
 */

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "persons", schema = "EcommerceDB")
public class PersonModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 2L;


    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "BINARY(16)")
    private UUID id;

    @Basic(optional = false)
    @Column(name = "DNI")
    private String dni;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "lastName")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "birthDate")
    private Timestamp birthDate;
    @Column(name = "citizenship")
    private String citizenship;

    @JsonIgnoreProperties({"persons", "user", "person", "hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private List<UserModel> users;

    public PersonModel() {
        this.users = new ArrayList<>();
    }

}
