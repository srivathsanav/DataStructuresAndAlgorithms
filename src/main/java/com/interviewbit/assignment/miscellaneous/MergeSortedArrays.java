import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by avsrivathsan on 7/27/2017.
 */
public class MergeSortedArrays {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> first = new ArrayList<>();

        for (int index = 0; index < nums1.length; index++)
        {
            first.add(nums1[index]);
        }

        List<Integer> second = new ArrayList<>();

        for (int index = 0; index < nums2.length; index++)
        {
            second.add(nums2[index]);
        }

        int k = first.size()-1;
        while (m > 0 && n > 0) {
            if (first.get(m-1) >= second.get(n-1)) {
                first.set(k, first.get(m-1));
                m--;
            } else {
                first.set(k, second.get(n-1));
                n--;
            }
            k--;
        }

        while (n > 0) {
            first.set(k, second.get(n-1));
            n--;k--;
        }
        int index = 0;
        for (Integer element : first) {
            System.out.println(element);
            nums1[index++] = element;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 7, 10, 14,0 ,0,0,0,0  };
        int[] nums2 = {2, 4,  6,  8,   9};
        merge(nums1, 5, nums2, 5);

    }
}
