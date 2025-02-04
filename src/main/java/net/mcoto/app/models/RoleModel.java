package net.mcoto.app.models;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles", schema = "EcommerceDB")
public class RoleModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1234564564651547433L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Basic
    @Column(name = "roleName")
    private String roleName;

    @Basic
    @Column(name = "roleDescription")
    private String roleDescription;

    @Basic
    @Column(name = "isActive")
    private boolean isActive;


    @JsonIgnoreProperties({"roles", "hibernateLazyInitializer", "handler"})
/*    @Fetch(FetchMode.JOIN)
    @JoinTable(name = "usersRoles",
            joinColumns = @JoinColumn(name = "idRole", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "idUser", referencedColumnName = "id"))
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)*/
    @ManyToMany(mappedBy = "roles")
    @Fetch(FetchMode.JOIN)
    private List<UserModel> users;


}
