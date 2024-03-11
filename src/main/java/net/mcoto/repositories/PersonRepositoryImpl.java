package net.mcoto.repositories;

import jakarta.ejb.Stateless;
import java.util.UUID;
import net.mcoto.app.models.PersonModel;

@Stateless
public class PersonRepositoryImpl extends GenericRepositoryImpl<PersonModel, UUID> implements IPersonRepository {

    public PersonRepositoryImpl() {
        super(PersonModel.class);
    }

    @Override
    public void saveUpdate(PersonModel person) {

        if (person.getId() == null) {
            save(person);
        } else {
            update(person);
        }
    }

}
