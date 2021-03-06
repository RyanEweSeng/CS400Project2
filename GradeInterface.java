// --== CS400 File Header Information ==--
// Name: Ethan McKellips
// Email: emckellips@wisc.edu
// Team: Red
// Group: IG
// TA: Sid
// Lecturer: Florian
// Notes to Grader: N/A
import java.util.List;


public interface GradeInterface extends Comparable<Grade>{
	public String getStudent();
	public Integer getGrade();

	public String getFirstName();
	public String getLastName();
	public void setGrade(int grade);
	public void setStudent(String name);
	
	public int compareTo(GradeInterface otherGrade);
	public String toString(); 
}

