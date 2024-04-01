package net.mcoto.app.services;

import jakarta.ejb.Singleton;
import jakarta.inject.Inject;
import net.mcoto.app.repositories.IPersonRepository;
import net.mcoto.app.repositories.IUserRepository;

@Singleton
public class UnitWorkImpl implements IUnitWork {

    @Inject
    private IPersonRepository persons;
    @Inject
    private IUserRepository users;


    @Override
    public IPersonRepository persons() {

        return persons;
    }

    @Override
    public IUserRepository users() {
        return users;
    }
    
}
