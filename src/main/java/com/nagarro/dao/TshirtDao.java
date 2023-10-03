package com.nagarro.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nagarro.entities.Tshirt;
import com.nagarro.utility.TshirtUtility;
import com.nagarro.validation.InvalidCategoryException;

public class TshirtDao {
	public final Session session;
	
	

	/**
	 * @param session
	 */
	public TshirtDao(Session session) {
		super();
		this.session = session;
	}



	public void saveTshirt(Tshirt tshirt) {
		
	
		Transaction tx=session.beginTransaction();
		try {
			
			//checking if object already present or not
			if(session.find(Tshirt.class, tshirt.getId())==null)
				session.save(tshirt);
		tx.commit();
		}catch(PersistenceException e) {
			
			//System.out.println("entry alredy present in db");
			tx.rollback();
		}
	}
	
	public List<Tshirt> getTshirts(String color,String size,String gender) throws InvalidCategoryException{
		TshirtUtility tsu=new TshirtUtility();
		String queryString = "from Tshirt t where t.color = :color and t.size = :size and t.gender = :gender and t.availability= :available"; 
		Query query = session.createQuery(queryString);
		query.setParameter("color", color);
		query.setParameter("size", tsu.getTSize(size) );
		query.setParameter("gender", tsu.getGender(gender));
		query.setParameter("available", tsu.getTAvailability("Y"));
		List<Tshirt> t = (List<Tshirt>)query.list();
		
		return t;
	}
}
