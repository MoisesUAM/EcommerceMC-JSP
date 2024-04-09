package net.mcoto.app.services;

import jakarta.ejb.Local;
import net.mcoto.app.repositories.IPersonRepository;
import net.mcoto.app.repositories.IRoleRepository;
import net.mcoto.app.repositories.IUserRepository;
import net.mcoto.app.repositories.IUserRoleRepository;

@Local
public interface IUnitWork {

    IPersonRepository persons();

    IUserRepository users();

    IRoleRepository roles();

    IUserRoleRepository userRoles();


}
