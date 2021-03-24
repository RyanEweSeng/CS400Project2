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
	javac -cp ./junit5.jar;. GradeTest.java

test: testData testBackend testFrontend

testFrontend: 
	@echo "FIXME: *make testFrontend* should compile (when needed) and run all your team's tests for this application"

testBackend: 
	@echo "FIXME: *make testFrontend* should compile (when needed) and run all your team's tests for this application"

testData: compile
	java -jar junit5.jar -cp . --scan-classpath GradeTest

clean:
	rm *.class
