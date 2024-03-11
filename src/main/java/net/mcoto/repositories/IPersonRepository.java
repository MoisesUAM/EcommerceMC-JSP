package net.mcoto.repositories;

import jakarta.ejb.Local;
import java.util.UUID;
import net.mcoto.app.models.PersonModel;

@Local
public interface IPersonRepository extends IGenericRepository<PersonModel, UUID> {

    void saveUpdate(PersonModel person);

}
