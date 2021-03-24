// --== CS400 File Header Information ==--
// Name: Elliot Virtue
// Email: evirtue@wisc.edu
// Team: IG: Red
// Role: Front End Developer
// TA: Sid
// Lecturer: Florian
// Notes to Grader: None

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Frontend {
  private static Boolean run = true;
  private static Scanner sc = new Scanner(System.in);
  private static String currentInput;
    private static Backend Backend;
  //private static Backend Backend = new Backend();
  public static void main(String[] args) {
    try {
    Backend = new Backend(new BufferedReader(new FileReader("Book1.csv")));
    } catch (Exception e) {
      e.printStackTrace();
    }
    while (run) {
      printMainCommands();
      currentInput = sc.nextLine();

      // student mode
      if (currentInput.contentEquals("s")) {
        studentMode();
      }

      // math mode
      else if (currentInput.contentEquals("m")) {
        mathMode();
      }

      // quit
      else if (currentInput.contentEquals("q")) {
        run = false;
        System.out.print("\n\nThank you for using our app!");
        return;
      }

      // incorrect input
      else {
        System.out.println("\nUser input is not accepted.\n\n");
      }
    }
  }

  public static void studentMode() {
    boolean sm = true;
    Integer numInput;
    while (sm) {
      numInput = -1;
      printSMCommands();
      if (sc.hasNextInt()) { // if input is an int, puts it into
        numInput = sc.nextInt();
        currentInput = numInput.toString();
      } else {
        currentInput = sc.nextLine();
      }

      if (currentInput.contentEquals("x")) {
        sm = false;
        return;
      } else if (numInput != -1) {
        if (numInput < 0 || numInput > 100) {
          System.out.println("Number out of range, please input a number between 0 and 100");
          continue;
        } else {
          //System.out.println(Backend.get(numInput).toString());
        }
      }

      // wrong input
      else {
        System.out.println("User Input is not accepted");
      }
    }
  }

  public static void mathMode() {
    boolean mm = true;
    while (mm) {
      printMMCommands();
      System.out.println("Min: " + Backend.getMin());
      System.out.println("Max: " + Backend.getMax());
      System.out.println("Mode: " + Backend.getMode());
      System.out.println("Mean: " + Backend.getMean());
      System.out.println("Median: " + Backend.getMedian());
      System.out.println("Standard Deviation: " + Backend.getSDev());
    }
    currentInput = sc.nextLine();
  }

  public static void printMainCommands() {
    System.out.println(
        "User Commands:\n  's': enters student mode\n  'm': enters math mode\n  'q': exits the application");
  }

  public static void printSMCommands() {
    System.out.println(
        "\nStudent Mode:\n  <number>: returns a list of students with the test score of <number>\n  'x': returns to the default menu\n");
  }

  public static void printMMCommands() {
    System.out.println("\nMath Mode:\n  Enter 'x' to return to default mode\n");
  }


}
