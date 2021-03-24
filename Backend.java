// --== CS400 File Header Information ==--
// Name: Aidan Lonergan
// Email: alonergan@wisc.edu
// Team: IG Red
// Role: Backend
// TA: Sid
// Lecturer: Gary Dahl
// Notes to Grader: n/a
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.io.Reader;
import java.lang.Math;

public class Backend implements BackendInterface {

    private RedBlackTree<Grade> rbt = new RedBlackTree<Grade>();
    
    /**
     * default constructor that takes the list of grades and adds them to
     * the rbt
     */
    public Backend(Reader r) throws IOException {
        GradeDataReader reader = new GradeDataReader();
        List<Grade> data = null;
        // read data
        try {
            data = reader.readDataSet(r);
        } catch (IOException | DataFormatException e) {
            System.out.println("Error parsing file");
        }
        // input into rbt
        for (int i = 0; i < data.size(); i++) {
            rbt.insert(data.get(i));
        }
    }
    
    
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
    
    public List<Grade> getStudents(int grade) {
        
        return null;
    }

    /**
     * Gets the median of the rbt dataset
     */
    public float getMedian() {
        // if empty tree
        if (rbt.root == null) {
            return 0;
        }
        int count = rbt.size();
        int currCount = 0;
        // current node, inorder direct predecessor (87 -> 88), and previous node
        RedBlackTree.Node<Grade> curr = rbt.root, pre = null, prev = null;

        while (curr != null) {
            if (curr.leftChild == null) {
                currCount++;
                // if current node is the median
                // middle node
                if ((count % 2) != 0 && currCount == (count + 1) / 2) {
                    return prev.data.getGrade();
                }
                // split middle node
                else if ((count % 2) == 0 && currCount == (count / 2) + 1) {
                    return (prev.data.getGrade() + curr.data.getGrade()) / 2;
                }
                prev = curr;
                curr = curr.rightChild;
            } else {
                // get inorder predecessor
                pre = curr.leftChild;
                while (pre.rightChild != null && pre.rightChild != curr) {
                    pre = pre.rightChild;
                }
                if (pre.rightChild == null) {
                    pre.rightChild = curr;
                    curr = curr.leftChild;
                } else {
                    pre.rightChild = null;
                    prev = pre;
                    currCount++;
                    // if node is middle of set
                    if ((count % 2) != 0 && currCount == (count + 1) / 2) {
                        return curr.data.getGrade();
                    } else if ((count % 2) == 0 && currCount == (count / 2) + 1) {
                        return (prev.data.getGrade() + curr.data.getGrade()) / 2;
                    }
                    prev = curr;
                    curr = curr.rightChild;
                }
            }
        }
        return -1;
    }

    /**
     * Gets the mean of the rbt dataset
     * x_bar = SIGMA(x_i) / size
     */
    public float getMean() {
        int sum = getSum(rbt.root);
        float mean = sum / rbt.size();
        return mean;
    }

    /**
     * Gets the min value of the rbt dataset
     */
    public int getMin() {
        // get root
        RedBlackTree.Node<Grade> min = rbt.root;
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
        RedBlackTree.Node<Grade> max = rbt.root;
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
        List<Integer> rbtList = createArray(rbt.root);
        int n = rbtList.size();
        int max = 0;
        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (rbtList.get(j) == rbtList.get(i)) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                max = rbtList.get(i);
            }
        }
        return max;
    }

    /**
     * Gets the standard deviation of the dataset
     * stdDev = sqrt( (SIGMA(x_i - x_bar)^2) / (n-1) )
     */
    public float getSDev() {
        int sumStdError = 0; // SIGMA(x_i - x_bar)
        int size = rbt.size() - 1;
        float mean = getMean();
        List<Integer> rbtArray = createArray(rbt.root);

        // calculate sumStdError
        for (int i = 0; i < rbtArray.size(); i++) {
            float gradeData = rbtArray.get(i);
            float error = gradeData - mean;
            sumStdError += error;
        }

        return (float) Math.sqrt((sumStdError ^ 2) / size);
    }

    /**
     * creates an inorder array of the rbt for stat analysis
     */
    public List<Integer> createArray(RedBlackTree.Node<Grade> n) {
        List<Integer> result = new ArrayList<>();

        if (n.leftChild != null) {
            result.addAll(createArray(n.leftChild));
        }

        if (n.rightChild != null) {
            result.addAll(createArray(n.rightChild));
        }

        result.add(n.data.getGrade());

        return result;

    }


    /**
     * returns the sum of the rbt
     * @return the sum
     */
    public int getSum(RedBlackTree.Node<Grade> root) {
        int sum, leftSum, rightSum;
        if (root == null) {
            sum = 0;
            return sum;
        } else {
            leftSum = getSum(root.leftChild);
            rightSum = getSum(root.rightChild);
            sum = root.data.getGrade() + leftSum + rightSum;
            return sum;
        }
    }
}
