package net.mcoto.app.repositories;

import java.util.UUID;

import jakarta.ejb.Local;
import net.mcoto.app.models.PersonModel;

@Local
public interface IPersonRepository extends IGenericRepository<PersonModel, UUID> {

    void saveUpdate(PersonModel person);

}
