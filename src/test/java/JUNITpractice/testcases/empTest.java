 /* @author Divya 
 illustrating testing of hrms from database using junit test cases.
 *
 */

package JUNITpractice.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.demoConJdbc.empDaoController;
import com.demoConJdbc.empl;



/**
 * Unit test for simple App.
 */
public class empTest {
	// CREATING OBJECT OF  Employee DAO
	empDaoController empdao= new empDaoController();

	// CREATING OBJECT OF EMPLOYEE
	empl e1 = new empl();
	
	@Test
	void testAddEmployee() throws Exception {
	    empdao.connect();
		e1.eName="Mercy";
		e1.eDomain="Java";
		e1.eDesignation="Developer";
		e1.eLocation="Bengalore";
		e1.eContact ="976891987";
		e1.eSalary=200000;
		
		//Testing for existed employee in data base
		assertEquals(-1,empdao.addEmp( e1));	
		
		e1.eName="Shubham";
		e1.eDomain="AWS";
		e1.eDesignation="Programmer";
		e1.eLocation="Delhi";
		e1.eContact ="654321987";
		e1.eSalary=45000;
		
		//Testing for new employee in data base
		assertEquals(1,empdao.addEmp(e1));	
	}
	
	@Test
	void testHikeSalary() throws Exception{
		empdao.connect();
		
		// Testing for new employee in data base
		assertEquals(49500,empdao.hikeSlry(103,10));

		// Testing for non existing employee in data base
		assertEquals(0,empdao.hikeSlry(111, 20));
		
	}
	
	@Test
	void testRemoveEmployee() throws Exception{

		empdao.connect();
		
		// Testing to delete non existing employee
		assertEquals(0,empdao.deltEmp(122));
		
		// Testing to delete existing employee
		assertEquals(1,empdao.deltEmp(106));
	}

}