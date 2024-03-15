package net.mcoto.app.services;

import jakarta.ejb.Singleton;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import net.mcoto.app.repositories.IPersonRepository;
import net.mcoto.app.repositories.PersonRepositoryImpl;

@Singleton
public class UnitWorkImpl implements IUnitWork {

    @Inject
    private IPersonRepository persons;


    @Override
    public IPersonRepository persons() {

        return persons;
    }

}
