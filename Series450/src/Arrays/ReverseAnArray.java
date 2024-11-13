/**
 * Author:  Waquar Shamsi
 * Date:    May 02, 2024
 */
package Arrays;

public class ReverseAnArray {

    public static void reverseArray(final int[] array, int start, int end) {
        if (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
    }
    public static int[] reverseArray(final int[] array) {
        reverseArray(array, 0, array.length-1);
        return array;
    }
}
