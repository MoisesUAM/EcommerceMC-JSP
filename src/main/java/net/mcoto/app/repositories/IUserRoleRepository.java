package net.mcoto.app.repositories;

import jakarta.ejb.Local;
import net.mcoto.app.models.UserRoleModel;

import java.util.UUID;

@Local
public interface IUserRoleRepository extends IGenericRepository<UserRoleModel, UUID> {

    void saveUpdate(UserRoleModel userRole);
}
