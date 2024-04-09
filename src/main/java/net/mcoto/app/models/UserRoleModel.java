package net.mcoto.app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "usersRoles", schema = "EcommerceDB")
public class UserRoleModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1234564564651547433L;

    @Id
    private UUID idUser;

    @Id
    private UUID idRole;
}
