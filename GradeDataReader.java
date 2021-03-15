// --== CS400 File Header Information ==--
// Name: Ethan McKellips
// Email: emckellips@wisc.edu
// Team: Red
// Group: IG
// TA: Sid
// Lecturer: Florian
// Notes to Grader: N/A

//Imports
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.DataFormatException;

/**
 * This class serves as a data reader for the CSV file with the names and grades. It would be best to implement this class as follows
 * 
 * GradeDataReader reader = new GradeDataReader();
 * List<GradeInterface> gradeList = reader.readDataSet(fileReader);
 * 
 * where fileReader is a FileReader object for the CSV file
 * 
 * @author Ethan McKellips
 *
 */
public class GradeDataReader implements GradeDataReaderInterface{

	/**
	 * This method parses the CSV file and creates Grade object accordingly
	 * 
	 * @param a FileReader object for the CSV file
	 * @return an ArrayList of Grade objects
	 */
	@Override
	public List<GradeInterface> readDataSet(Reader csvReader)
			throws FileNotFoundException, IOException, DataFormatException {
		List<GradeInterface> studentGrades = new ArrayList<GradeInterface>();
		String dataLine = null;
		
		// Essentially converts the reader into a buffered reader so it can iterate through the file
		BufferedReader bufferedReader = new BufferedReader(csvReader);
		
		dataLine = bufferedReader.readLine();
		dataLine = dataLine.replace("﻿", "");
		// A loop that iterates through the CSV file
		while (dataLine != null) {
			dataLine = dataLine.replaceAll(",", " ");
			
			Scanner lineScan = new Scanner(dataLine);
			List<String> name = new ArrayList<String>();
			name.add(lineScan.next());
			name.add(lineScan.next());
			
			int grade = lineScan.nextInt();
			
			Grade student = new Grade(name, grade);
			studentGrades.add(student);
			
			lineScan.close();
			dataLine = bufferedReader.readLine();
		}
		return studentGrades;
	}

}
