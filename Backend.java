import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.lang.Math;
import RedBlackTree.Node;

public class Backend implements BackendInterface  {
    
    private RedBlackTree<Grade> rbt = new RedBlackTree<Grade>();
    private int rbtSum;
    
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
        Node<Grade> curr = rbt.root, pre = null, prev = null;
        
        while (curr != null) {
            if (curr.leftChild == null) {
                currCount++;
                // if current node is the median
                // middle node
                if ((count % 2) != 0 && currCount == (count + 1) / 2) {
                    return prev.data;
                } 
                // split middle node
                else if ((count % 2) == 0 && currCount == (count / 2) + 1) {
                    return (prev.data + curr.data) / 2;
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
                    if ((count % 2) != 0 && currCount == (count + 1)/2) {
                        return curr.data;
                    } else if ((count % 2) == 0 && currCount == (count / 2) + 1) {
                        return (prev.data + curr.data) / 2;
                    }
                    prev = curr;
                    curr = curr.rightChild;
                }
            }
        }
        
        
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
     * stdDev = sqrt( (SIGMA(x_i - x_bar)^2) / (n-1) )
     */
    public float getSDev() {
        int sumStdError; // SIGMA(x_i - x_bar)
        int size = rbt.size() - 1;
        float mean = getMean();
        List<Integer> rbtArray = createArray(rbt.root);
        
        // calculate sumStdError
        for (int i = 0; i < rbtArray.size(); i++) {
            float gradeData = rbtArray.get(i);
            float error = gradeData - mean;
            sumStdError += error;
        }
        
        return (float) Math.sqrt((sumStdError^2) / size); 
    }
    /**
     * creates an inorder array of the rbt for stat analysis
     */
    public List<Integer> createArray(Node<Grade> n) {
        List<Integer> result = new ArrayList<>();
        
        if (n.leftChild != null) {
            result.addAll(createArray(n.leftChild));
        }
        
        if (n.rightChild != null) {
            result.addAll(createArray(n.rightChild));
        }
        
        result.add(n.data.getGrade);
        
        return result;
       
    }
    
    
    /**
     * returns the sum of the rbt
     * @return the sum
     */
    public int getSum(Node<Grade> root) {
        int sum, leftSum, rightSum;
        if (root == null) {
            sum = 0;
            return sum;
        } else {
            leftSum = sum(root.leftChild);
            rightSum = sum(root.rightChild);
            sum = root.data.getGrade() + leftSum + rightSum;
            return sum;
        }
    }
}
