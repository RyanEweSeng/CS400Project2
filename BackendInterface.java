
public interface BackendInterface {
    boolean add(int grade, String student);
    String get(int grade);
    float getMedian();
    float getMean();
    int getMin();
    int getMax();
    int getMode();
    float getSDev();
}
