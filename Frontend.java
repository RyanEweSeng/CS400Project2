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
    Backend = new Backend(new BufferedReader(new FileReader("gradeData.csv")));
    } catch (Exception e) {
      e.printStackTrace();
    }
    while (run) {
      System.out.println(printMainCommands());
      currentInput = sc.nextLine();

      // student mode
      if (currentInput.contentEquals("s")) {
        studentMode(sc);
      }

      // math mode
      else if (currentInput.contentEquals("m")) {
        mathMode(sc);
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

  public static String studentMode(Scanner input) {
    Scanner scnr = input;
    boolean sm = true;
    Integer numInput;
    String toReturn = null;
    while (sm) {
      numInput = -1;
      System.out.println(printSMCommands());
      if (scnr.hasNextInt()) { // if input is an int, puts it into
        numInput = scnr.nextInt();
        currentInput = numInput.toString();
      } else {
        currentInput = scnr.nextLine();
      }

      if (currentInput.contentEquals("x")) {
        sm = false;
        return toReturn;
      } else if (numInput != -1) {
        if (numInput < 0 || numInput > 100) {
          System.out.println("Number out of range, please input a number between 0 and 100");
          continue;
        } else {
          System.out.println(Backend.get(Backend.rbt.root,(int)numInput).toString());
          toReturn = Backend.get(Backend.rbt.root,(int)numInput);
        }
      }

      // wrong input
      else {
        System.out.println("User Input is not accepted");
      }
    }
    return null;
  }

  public static String mathMode(Scanner input) {
    boolean mm = true;
    String output = "";
    Scanner scnr = input;
    while (mm) {
      output += "Min: " + Backend.getMin() + "\n";
      output += "Max: " + Backend.getMax() + "\n";
      output += "Mode: " + Backend.getMode() + "\n";
      output += "Mean: " + Backend.getMean() + "\n";
      output += "Median: " + Backend.getMedian() + "\n";
      output += "Standard Deviation: " + Backend.getSDev() + "\n";
      System.out.println(output);
      System.out.println(printMMCommands());
      currentInput = scnr.nextLine();
      if (currentInput.contentEquals("x")) {
        mm = false;
        return output;
      } else {
        System.out.println("Input not accepted");
        continue;
      }
    }
    return null;
  }

  public static String printMainCommands() {
    return "User Commands:\n  's': enters student mode\n  'm': enters math mode\n  'q': exits the application";
  }

  public static String printSMCommands() {
    return "\nStudent Mode:\n  <number>: returns a list of students with the test score of <number>\n  'x': returns to the default menu\n";
  }

  public static String printMMCommands() {
    return "\nMath Mode:\n  Enter 'x' to return to default mode\n";
  }


}
