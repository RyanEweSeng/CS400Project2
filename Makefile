# --== CS400 File Header Information ==--
# Name: Ryan Toh
# Email: retoh@wisc.edu
# Team: IG
# Role: Integration Manager
# TA: Sid
# Lecturer: Gary Dahl
# Notes to Grader: N/A

run: compile
	java Frontend

compile:
	javac Grade.java
	javac GradeInterface.java
	javac GradeDataReader.java
	javac GradeDataReaderInterface.java
	javac Backend.java
	javac BackendInterface.java
	javac -cp .:./junit5.jar GradeTest.java GradeDataReaderTest.java
	javac -cp .:./junit5.jar BackendTest.java 

test: testData testBackend testFrontend

testFrontend: 
	

testBackend: compile
	java -jar junit5.jar -cp . --scan-classpath BackendTest

testData: compile
	java -jar junit5.jar -cp . --scan-classpath GradeTest
	java -jar junit5.jar -cp . --scan-classpath GradeDataReaderTest

clean:
	rm *.class
