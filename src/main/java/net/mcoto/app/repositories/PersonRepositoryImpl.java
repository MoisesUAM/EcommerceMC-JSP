package net.mcoto.app.repositories;

import jakarta.ejb.Stateless;
import net.mcoto.app.models.PersonModel;

import java.util.UUID;


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
