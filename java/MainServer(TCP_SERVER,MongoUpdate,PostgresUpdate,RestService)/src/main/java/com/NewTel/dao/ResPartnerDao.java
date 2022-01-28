package com.NewTel.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import eus.uni.dam.HrEmployee;
import org.springframework.stereotype.Repository;


/**
 *  DAO class to manage the upload of data to PostgreSQL
 * 
 * @author kalboetxeaga.ager
 *
 */
@Repository
@Transactional
public class ResPartnerDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	/**
	 * Datubasean objetua sortzeko metodoa
	 * @param respartner
	 */
	public void create(HrEmployee respartner) {
		entityManager.persist(respartner);

	}
	
	
	/**
	 * Datubaseko objetu bat ezabatzeko
	 * @param respartner
	 */
	public void delete(HrEmployee respartner) {
		if(entityManager.contains(respartner)) entityManager.remove(respartner);
		else entityManager.remove(entityManager.merge(respartner));
		return;
	}
	
	
	/**
	 * produktu guztiak itzultzen ditu lista batean
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<HrEmployee> getAll(){
		return entityManager.createQuery("from ResPartner").getResultList();
	}
	
	
	/**
	 * Produktua itzultzen du bere id-a sartuta
	 * @param id
	 * @return
	 */
	public HrEmployee getById(long id) {
		return entityManager.find(HrEmployee.class, id);
	}
	
	
	
	/**
	 * Produktua datubasean aktualizatzeko metodoa
	 * @param respartner
	 */
	public void update(HrEmployee respartner) {
		entityManager.merge(respartner);

	}
}
