package net.mcoto.app.repositories;

import jakarta.ejb.Local;
import net.mcoto.app.models.UserModel;

import java.util.UUID;

@Local
public interface IUserRepository extends IGenericRepository<UserModel, UUID> {

    void saveUpdate(UserModel user);
}
