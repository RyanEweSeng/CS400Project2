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
	javac RedBlackTree.java
	javac SortedCollectionInterface.java
	javac Frontend.java
	javac -cp .:./junit5.jar GradeTest.java GradeDataReaderTest.java
	javac -cp .:./junit5.jar BackendTest.java
	# javac -cp .:./junit5.jar TestFrontEnd.java

test: testData testBackend testFrontend

testFrontend: compile	
	# java -jar junit5.jar -cp . --scan-classpath TestFrontEnd

testBackend: compile
	java -jar junit5.jar -cp . --scan-classpath -n BackendTest

testData: compile
	java -jar junit5.jar -cp . --scan-classpath -n GradeTest
	java -jar junit5.jar -cp . --scan-classpath -n GradeDataReaderTest

clean:
	rm *.class
