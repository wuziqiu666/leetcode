package util;
import java.util.Random;

public class Sort {

    /**
     * 快速排序
     * 
     * @param nums
     * @param l
     * @param r
     */
    public static void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int tmpSite = new Random().nextInt(l, r);
            swap(nums, l, tmpSite);
            int q = partation_new(nums, l, r);
            quickSort(nums, l, q);
            quickSort(nums, q + 1, r);

        }
    }

    /**
     * 数组的划分_Hoare
     * 
     * @param nums
     * @param l
     * @param r
     * @return
     */
    public static int partation(int[] nums, int l, int r) {
        int x = nums[l];
        int i = l;
        int j = r - 1;
        while (i < j) {
            while (nums[j] >= x && j > i) {
                j--;
            }
            nums[i] = nums[j];
            while (nums[i] < x && j > i) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = x;
        return i;
    }

    /**
     * 数组的划分
     * 
     * @param nums
     * @param l
     * @param r
     * @return
     */
    public static int partation_new(int[] nums, int l, int r) {
        int x = nums[l];
        int i = l;
        for (int j = l + 1; j < r; j++) {
            if (nums[j] < x) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, l, i);
        return i;
    }

    /**
     * 堆排序
     * 
     * @param nums
     */
    public static void heapSort(int[] nums) {
        int heapSize = nums.length;
        buildMaxHeapify(nums, heapSize);
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapSize--;
            maxHeapify(nums, 0, heapSize);

        }
    }

    /**
     * 建堆
     * 
     * @param nums
     * @param heapSize
     */
    public static void buildMaxHeapify(int[] nums, int heapSize) {
        for (int i = (heapSize / 2); i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }

    /**
     * 维护堆的性质
     * 
     * @param nums
     * @param i
     * @param heapSize
     */
    public static void maxHeapify(int[] nums, int i, int heapSize) {
        int l = (i + 1) * 2 - 1;
        int r = (i + 1) * 2;
        int largest = i;
        if (l < heapSize && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < heapSize && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(nums, i, largest);
            maxHeapify(nums, largest, heapSize);
        }
    }

    /**
     * util
     * 
     * @param nums
     * @param a
     * @param b
     */
    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
