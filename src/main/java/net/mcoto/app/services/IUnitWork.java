package net.mcoto.app.services;

import jakarta.ejb.Local;
import net.mcoto.repositories.IPersonRepository;

@Local
public interface IUnitWork {

    IPersonRepository persons();

}
