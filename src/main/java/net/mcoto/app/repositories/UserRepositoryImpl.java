package net.mcoto.app.repositories;

import jakarta.ejb.Stateless;
import net.mcoto.app.models.UserModel;

import java.util.UUID;

@Stateless
public class UserRepositoryImpl extends GenericRepositoryImpl<UserModel, UUID> implements IUserRepository {

    public UserRepositoryImpl() {
        super(UserModel.class);
    }

    @Override
    public void saveUpdate(UserModel user) {
        if (user.getId() == null) {
            save(user);
        } else {
            update(user);
        }
    }
}
