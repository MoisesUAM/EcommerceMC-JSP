package net.mcoto.app.repositories;


import jakarta.ejb.Local;
import net.mcoto.app.models.RoleModel;

import java.util.UUID;

@Local
public interface IRoleRepository extends IGenericRepository<RoleModel, UUID> {

    void saveUpdate(RoleModel role);
}
