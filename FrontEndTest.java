import org.junit.jupitor.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Scanner;

public class FrontEndTest {

  @Test
  public void testEnterStudentMode() {
    assertEquals(Frontend.printSMCommands(), "\\nStudent Mode:\\n  <number>: returns a list of students with the test score of <number>\\n  'x': returns to the default menu\\n");
  }
  
  @Test
  public void testEnterMathMode() {
    assertEquals(Frontend.printMMCommands(), "\\nMath Mode:\\n  Enter 'x' to return to default mode\\n");
  }
  
  @Test
  public void testEnterMainMode() {
    assertEquals(Frontend.printMainCommands(), "User Commands:\\n  's': enters student mode\\n  'm': enters math mode\\n  'q': exits the application");
  }
  
  @Test
  public void testUseStudentMode() {
    Scanner sc = new Scanner("69\nx");
    Grade grade = Frontend.studentMode(sc);
    assertEquals(grade, new Grade("Elliot Virtue", 43));
  }
  
  //couldnt figure out how to implement :/
  @Test
  public void testUseMathMode() {
    assertEquals(":(", ":(");
  }
}
