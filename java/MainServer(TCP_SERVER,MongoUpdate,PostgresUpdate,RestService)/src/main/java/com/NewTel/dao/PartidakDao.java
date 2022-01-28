package com.NewTel.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import eus.uni.dam.PartidakPartida;

import org.springframework.stereotype.Repository;


/**
 * DAO class to manage the upload of data to PostgreSQL
 * 
 * @author kalboetxeaga.ager
 *
 */
@Repository
@Transactional
public class PartidakDao {

    @PersistenceContext
    private EntityManager entityManager;


    /**
     * Datubasean objetua sortzeko metodoa
     * @param partidakPartida
     */
    public void create(PartidakPartida partidakPartida) {
        entityManager.persist(partidakPartida);

    }


    /**
     * Datubaseko objetu bat ezabatzeko
     * @param partidakPartida
     */
    public void delete(PartidakPartida partidakPartida) {
        if(entityManager.contains(partidakPartida)) entityManager.remove(partidakPartida);
        else entityManager.remove(entityManager.merge(partidakPartida));
        return;
    }


    /**
     * produktu guztiak itzultzen ditu lista batean
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<PartidakPartida> getAll(){
        return entityManager.createQuery("from PartidakPartida").getResultList();
    }


    /**
     * Produktua itzultzen du bere id-a sartuta
     * @param id
     * @return
     */
    public PartidakPartida getById(long id) {
        return entityManager.find(PartidakPartida.class, id);
    }



    /**
     * Produktua datubasean aktualizatzeko metodoa
     * @param partidakPartida
     */
    public void update(PartidakPartida partidakPartida) {
        entityManager.merge(partidakPartida);

    }
}
