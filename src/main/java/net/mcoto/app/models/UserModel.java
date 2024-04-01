package net.mcoto.app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFoundAction;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users", schema = "EcommerceDB")
public class UserModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Basic
    @Column(name = "userName")
    private String userName;
    @Basic
    @Column(name = "isActive")
    private boolean isActive;

    @Column(name = "idPerson", nullable = false, updatable = false, insertable = false, columnDefinition = "BINARY(16)")
    private UUID idPerson;

    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "email")
    private String email;

    @JsonIgnoreProperties({"users", "hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "idPerson", referencedColumnName = "id")
    @ManyToOne(optional = false, cascade = CascadeType.REFRESH)
    private PersonModel person;


    @JsonIgnoreProperties({"users", "hibernateLazyInitializer", "handler"})
    @Fetch(FetchMode.JOIN)
    @JoinTable(name = "usersRoles",
            joinColumns = @JoinColumn(name = "idUser", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "idRole", referencedColumnName = "id"))
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @ManyToMany
    private List<RoleModel> roles;

}
