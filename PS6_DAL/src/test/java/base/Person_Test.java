package base;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {
	static PersonDomainModel person1 = new PersonDomainModel();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		person1.getPeronID();
		person1.setFirstName("Dylan");
		person1.setLastName("Martin");
		person1.setCity("Newark DE");
		person1.setBirthday(LocalDate.now());
		person1.setPostalCode(19711);
		person1.setStreet("804 North Country Club Dr.");
		
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void AddPersonTest(){
		PersonDAL.addPerson(person1);
		assertEquals(person1.getFirstName(), "Dylan");
	}
	
	@Test
	public void GetPersonTest(){
		String LastName = person1.getLastName();
		assertEquals("Martin",LastName);
	}
	
	@Test
	public void UpdatePersonTest(){
		String FirstName = person1.getFirstName();
		person1.setFirstName("Dylan");
		
		PersonDAL.updatePerson(person1);
		assertEquals("Dylan",FirstName);
	}
	
	@Test
	public void deletePersontest(){
		PersonDAL.deletePerson(person1.getPeronID());
		assertEquals(person1, null);
	}

	
}
