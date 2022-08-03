import java.util.Scanner;
public class StringSort{
    public static void main(String[] args){
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            in.nextLine();
            String[] nums = in.nextLine().split(" ");
            quickSort(nums, 0, n - 1);
            for(int i = 0; i < n; i++){
                System.out.print(nums[i] + " ");
            }
        }

    }
    
    public static void quickSort(String[] nums, int l, int r){
        if(l >= r){
            return;
        }
        int l1 = l, r1 = r;
        int site = l;
        String tmp;
        while(l < r){
            while(l < r && nums[r].compareTo(nums[site]) >= 0){
                r--;
            }
            if(l < r){
                tmp = nums[r];
                nums[r] = nums[site];
                nums[site] = tmp;
                site = r;
            }
            while( l < r && nums[l].compareTo(nums[site]) <= 0){
                l++;
            }
            if(l < r){
                tmp = nums[l];
                nums[l] = nums[site];
                nums[site] = tmp;
                site = l;
            }
        }
        quickSort(nums, l1, l - 1);
        quickSort(nums, r + 1, r1);
        
    }
}