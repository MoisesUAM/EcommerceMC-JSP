package net.mcoto.app.repositories;

import jakarta.ejb.Stateless;
import net.mcoto.app.models.RoleModel;

import java.util.UUID;

@Stateless
public class RoleRepositoryImpl extends GenericRepositoryImpl<RoleModel, UUID> implements IRoleRepository {

    public RoleRepositoryImpl() {
        super(RoleModel.class);
    }

    @Override
    public void saveUpdate(RoleModel role) {

        if (role.getId() == null) {
            save(role);
        } else {
            update(role);
        }
    }
}
