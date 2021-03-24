// --== CS400 File Header Information ==--
// Name: Aidan Lonergan
// Email: alonergan@wisc.edu
// Team: IG Red
// Role: Backend
// TA: Sid
// Lecturer: Gary Dahl
// Notes to Grader: n/a
public interface BackendInterface {
    boolean add(int grade, String student);
    float getMedian();
    float getMean();
    int getMin();
    int getMax();
    int getMode();
    float getSDev();
}
