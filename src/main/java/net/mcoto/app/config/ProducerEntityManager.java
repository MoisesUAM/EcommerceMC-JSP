package net.mcoto.app.config;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RequestScoped
public class ProducerEntityManager {

    @PersistenceContext(name = "StorePU")
    private EntityManager em;


    @RequestScoped
    @Produces
    private EntityManager beanEntityManager() {
        return em;
    }
}
