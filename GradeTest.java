// --== CS400 File Header Information ==--
// Name: Ethan McKellips
// Email: emckellips@wisc.edu
// Team: Red
// Group: IG
// TA: Sid
// Lecturer: Florian
// Notes to Grader: N/A

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit class that tests the functionality of the Grade class
 * @author Ethan McKellips
 *
 */
class GradeTest {
	// Grade instance that is used for each test
	Grade _instance;
	
	/**
	 * Method that is used before each test method. It creates a sample student.
	 */
	@BeforeEach
	void beforeEach() {
		List<String> studentName = new ArrayList<String>();
		studentName.add("Ethan");
		studentName.add("McKellips");
		_instance = new Grade(studentName, 90);
	}
	
	/**
	 * Tests the getStudent() method
	 */
	@Test
	void testGetStudent() {
		List<String> studentName = new ArrayList<String>();
		studentName.add("Ethan");
		studentName.add("McKellips");
		assertEquals(studentName, _instance.getStudent());
	}
	
	/**
	 * Tests the getGrade() method
	 */
	@Test
	void testGetGrade() {
		int grade = 90;
		assertEquals(grade, _instance.getGrade());
	}
	
	/**
	 * Tests the getFirstName() method
	 */
	@Test
	void testGetFirstName() {
		String firstName = "Ethan";
		assertEquals(firstName, _instance.getFirstName());
	}
	
	/**
	 * Tests the getLastName() method
	 */
	@Test
	void testGetLastName() {
		String lastName = "McKellips";
		assertEquals(lastName, _instance.getLastName());
	}
	
	/**
	 * Tests the setName() method
	 */
	@Test
	void testSetName() {
		List<String> nameChange = new ArrayList<String>();
		nameChange.add("Evan");
		nameChange.add("MacDonald");
		_instance.setStudent(nameChange);
		assertEquals(nameChange, _instance.getStudent());
	}
	
	/**
	 * Tests the setGrade() method
	 */
	@Test
	void testSetGrade() {
		_instance.setGrade(47);
		assertEquals(47, _instance.getGrade());
	}
	
	/**
	 * Tests the compareTo() method
	 */
	@Test
	void testCompareTo() {
		List<String> otherName = new ArrayList<String>();
		otherName.add("Evan");
		otherName.add("MacDonald");
		Grade otherGrade = new Grade(otherName, 90);
		
		assertEquals(0, _instance.compareTo(otherGrade));
		
		otherGrade.setGrade(91);
		assertEquals(1, _instance.compareTo(otherGrade));
		
		otherGrade.setGrade(89);
		assertEquals(-1, _instance.compareTo(otherGrade));
	}

	/**
	 * Tests the toString() method
	 */
	@Test
	void testToString() {
		assertEquals("Student: Ethan McKellips Grade: 90", _instance.toString());
	}
}
