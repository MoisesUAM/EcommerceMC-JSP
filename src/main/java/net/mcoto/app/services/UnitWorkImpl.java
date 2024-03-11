package net.mcoto.app.services;

import jakarta.ejb.Singleton;
import jakarta.inject.Inject;
import net.mcoto.repositories.IPersonRepository;

@Singleton
public class UnitWorkImpl implements IUnitWork {

    @Inject
    private IPersonRepository persons;

    @Override
    public IPersonRepository persons() {

        return persons;
    }

}
