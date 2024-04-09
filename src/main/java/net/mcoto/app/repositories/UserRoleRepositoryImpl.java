package net.mcoto.app.repositories;

import jakarta.ejb.Stateless;
import net.mcoto.app.models.UserRoleModel;

import java.util.UUID;

@Stateless
public class UserRoleRepositoryImpl extends GenericRepositoryImpl<UserRoleModel, UUID> implements IUserRoleRepository {

    public UserRoleRepositoryImpl() {
        super(UserRoleModel.class);
    }
}
