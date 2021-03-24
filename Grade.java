// --== CS400 File Header Information ==--
// Name: Ethan McKellips
// Email: emckellips@wisc.edu
// Team: Red
// Group: IG
// TA: Sid
// Lecturer: Florian
// Notes to Grader: N/A

import java.util.Scanner;

/**
 * Grade class that acts as an object that stores a student's name and grade
 * 
 * @author Ethan McKellips
 *
 */
public class Grade implements GradeInterface {
	// Instance fields
	private String student;
	private int grade;
	private String firstName;
	private String lastName;

	/**
	 * Constructor that collects the student's name and grade
	 * 
	 * @param student
	 * @param grade
	 */
	public Grade(String student, int grade) {
		Scanner nameScan = new Scanner(student);
		this.student = student;
		this.grade = grade;
		firstName = nameScan.next();
		lastName = nameScan.next();
	}

	/**
	 * Returns the student's grade
	 * @return grade
	 */
	@Override
	public Integer getGrade() {
		return grade;
	}

	@Override
	/**
	 * Retrieves the first name of the student
	 * 
	 * @return first name of student
	 */
	public String getFirstName() {
		return firstName;
	}

	@Override
	/**
	 * Retrieves the last name of the student
	 * 
	 * @return last name of student
	 */
	public String getLastName() {
		return lastName;
	}

	@Override
	/**
	 * Sets this student's grade
	 * 
	 * @param grade grade being assigned to this student
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	/**
	 * Sets the name for this student
	 * 
	 * @param name the name being assigned to this student
	 */
	public void setStudent(String name) {
		this.student = name;
	}

	/**
	 * Returns this student in a string format
	 * @return student's name
	 */
	public String toString() {
		return "Student: " + student + " Grade: " + grade;
	}

	/**
	 * Returns the student's name
	 */
	@Override
	public String getStudent() {
		return student;
	}

	/**
	 * Compares two grades
	 * @return 0 if equal, 1 if greater, -1 if lesser
	 */
	@Override
	public int compareTo(Grade otherGrade) {
		if (grade == otherGrade.getGrade()) {
			return 0;
		} else if (otherGrade.getGrade() > grade) {
			return 1;
		} else {
			return -1;
		}
	}

	/**
	 * IGNORE THIS METHOD... is only used to comply with Comparable<> extended by GradeInterface
	 * However, has the same idea as the other compareTo() method
	 */
	@Override
	public int compareTo(GradeInterface otherGrade) {
		if (grade == otherGrade.getGrade()) {
			return 0;
		} else if (otherGrade.getGrade() > grade) {
			return 1;
		} else {
			return -1;
		}
	}


}
