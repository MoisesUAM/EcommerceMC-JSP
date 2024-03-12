package net.mcoto.app.models;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Moises Coto Salazar
 */
@Entity
@Table(name = "persons")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.UUID)
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;
    @Column(name = "citizenship")
    private String citizenship;

}
