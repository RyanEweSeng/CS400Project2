import java.util.LinkedList;
import java.util.List;

public class Backend implements BackendInterface  {
    
    private RedBlackTree<Grade> rbt = new RedBlackTree<Grade>();
    
    /**
     * Adds student name to the grade node specified
     * @param grade     grade node to add to
     * @param student   student to add to grade node
     * @return          true if successfull
     */
    public boolean add(int grade, String student) {
        Grade toInsert = new Grade(student, grade);
        boolean ret = rbt.insert(toInsert);
        if (ret == true) {
            return true;
        }
        return false;
    }
    
    /**
     * Gets the specified grade node and returns the list of students
     * with that grade
     * @param grade     grade to get
     * @return          student list
     */
    public String get(int grade) {
        Node root = rbt.root;
        }
    
    /**
     * Gets the median of the rbt dataset
     */
    public float getMedian() {
        
    }
    
    /**
     * Gets the mean of the rbt dataset
     */
    public float getMean() {
        
    }
    
    /**
     * Gets the min value of the rbt dataset
     */
    public int getMin() {
        // get root
        Node<Grade> min = rbt.root;
        // loop to left of tree
        while (min.leftChild != null) {
            min = min.leftChild;
        }
        
        return min.data.getGrade();
    }
    
    /**
     * Gets the max value of the rbt dataset
     */
    public int getMax() {
        // get root
        Node<Grade> max = rbt.root;
        // loop to right of tree
        while (max.rightChild != null) {
            max = max.rightChild;
        }
        
        return max.data.getGrade();
    }
    
    /**
     * Gets the mode of the rbt dataset
     */
    public int getMode() {
        
    }
    
    /**
     * Gets the standard deviation of the dataset
     */
    public float getSDev() {
        
    }

}
