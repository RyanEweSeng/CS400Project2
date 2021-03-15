// --== CS400 File Header Information ==--
// Name: Ethan McKellips
// Email: emckellips@wisc.edu
// Team: Red
// Group: IG
// TA: Sid
// Lecturer: Florian
// Notes to Grader: N/A

import java.util.ArrayList;
import java.util.List;

/**
 * Grade class that acts as an object that stores a student's name and grade
 * @author Ethan McKellips
 *
 */
public class Grade implements GradeInterface{
	// Instance fields
	private List<String> student = new ArrayList();
	private int grade;
	
	/**
	 * Constructor that collects the student's name and grade
	 * @param student
	 * @param grade
	 */
	public Grade(List<String> student, int grade) {
		this.student = student;
		this.grade = grade;
	}
	
	/**
	 * Returns the student's name
	 */
	@Override
	public List<String> getStudent() {
		return student;
	}

	/**
	 * Returns the student's grade
	 */
	@Override
	public Integer getGrade() {
		return grade;
	}

	
	@Override
	/**Compares two different grades
	 * 
	 * @return 0 if the grades are equal, 1 if the original grade is higher, and lower if the grade is lower
	 */
	public int compareTo(GradeInterface otherGrade) {
		if (grade == otherGrade.getGrade()) {
			return 0;
		} else if (otherGrade.getGrade() > grade) {
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	/**
	 * Retrieves the first name of the student
	 * @return first name of student
	 */
	public String getFirstName() {
		String firstName = student.get(0);
		return firstName;
	}

	@Override
	/**
	 * Retrieves the last name of the student
	 * @return last name of student
	 */
	public String getLastName() {
		String lastName = student.get(1);
		return lastName;
	}

	@Override
	/**
	 * Sets this student's grade
	 * @param grade grade being assigned to this student
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	/**
	 * Sets the name for this student
	 * @param name the name being assigned to this student
	 */
	public void setStudent(List<String> name) {
		this.student = name;
	}

	/**
	 * Returns this student in a string format
	 */
	public String toString() {
		return "Student: " + student.get(0) + " " + student.get(1) + " Grade: " + grade;
	}
}
