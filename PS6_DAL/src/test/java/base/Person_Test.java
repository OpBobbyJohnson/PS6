package base;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
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
		person1.setFirstName("Dylan");
		person1.setLastName("Martin");
		person1.setCity("Newark DE");
		person1.setBirthday(LocalDate.now());
		person1.setPostalCode(19711);
		person1.setStreet("804 North Country Club Dr.");
		PersonDAL.addPerson(person1);
		PersonDomainModel person2 = PersonDAL.getPerson(person1.getPeronID());
		
		assertNotNull(person2);
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		PersonDAL.deletePerson(person1.getPeronID());
	}
	
	@Test
	public void TestGetAllPersons(){
		ArrayList<PersonDomainModel> pers = PersonDAL.getPersons();
		assertNotNull(pers);
	}
	
	@Test
	public void AddPersonTest(){
		PersonDAL.addPerson(person1);
		assertNotNull(PersonDAL.getPerson(person1.getPeronID()));
	}
	
	@Test
	public void GetPersonTest(){
		PersonDomainModel person2 = PersonDAL.getPerson(person1.getPeronID());
		assertEquals(person1.getFirstName(), person2.getFirstName());
	}
	
	@Test
	public void UpdatePersonTest(){
		PersonDomainModel person2 = PersonDAL.getPerson(person1.getPeronID());
		assertEquals(person1.getPeronID(),  person2.getPeronID());
		person2.setLastName("Dope");
		PersonDAL.updatePerson(person2);
		PersonDomainModel person3 = PersonDAL.getPerson(person1.getPeronID());
		assertEquals(person2.getLastName(), person3.getLastName());
		assertNotEquals(person1.getLastName(), person2.getLastName());
	}
	
	@Test
	public void deletePersontest(){
		PersonDAL.deletePerson(person1.getPeronID());
		PersonDomainModel person4 = PersonDAL.getPerson(person1.getPeronID());
		assertNull(person4);
	}

	
}
