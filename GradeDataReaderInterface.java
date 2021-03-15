// --== CS400 File Header Information ==--
// Name: Ethan McKellips
// Email: emckellips@wisc.edu
// Team: Red
// Group: IG
// TA: Sid
// Lecturer: Florian
// Notes to Grader: N/A

import java.util.List;
import java.util.zip.DataFormatException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public interface GradeDataReaderInterface {
	public List<GradeInterface> readDataSet(Reader inputFileReader)
			throws FileNotFoundException, IOException, DataFormatException;
}
