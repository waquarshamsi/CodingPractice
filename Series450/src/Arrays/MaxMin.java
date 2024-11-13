package Arrays;

public class MaxMin {
    public static int findSum(int A[],int N)
    {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int element : A) {
            max = max > element ? max : element; //Could have used Math.max();
            min = min < element ? min : element;
        }
        return max + min;

    }
}
