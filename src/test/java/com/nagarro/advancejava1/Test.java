package com.nagarro.advancejava1;

import java.io.IOException;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.nagarro.categories.Availability;
import com.nagarro.categories.Gender;
import com.nagarro.categories.Size;
import com.nagarro.entities.Tshirt;
import com.nagarro.utility.SessionObj;
import com.opencsv.exceptions.CsvException;

public class Test {
	
	public static void main(String[] args) throws IOException, CsvException {
		try {
		Tshirt t=new Tshirt("1212ghsdsdh2", "adidas sports t", "blue", Gender.M, Size.M, 1200.45f, 4.3f, Availability.Y);
		Session session=SessionObj.getSession();
		
		Transaction tx=session.beginTransaction();
			session.save(t);
		tx.commit();
		}catch(PersistenceException e) {
			
			System.out.println("entry alredy present in db");
		}
		
//		FileReader csvFile=new FileReader("data/Adidas.csv");
//		 CSVReader csvReader=new CSVReader(csvFile);
//		 
//		 List<String[]> list=csvReader.readAll();
//		 
//		 for(String[] str:list) {
//			 for(String s:str)
//		 System.out.println(s);
//		 }
		
		
 }  	
}

