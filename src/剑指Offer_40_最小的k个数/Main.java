package 剑指Offer_40_最小的k个数;

import java.util.Arrays;

/**
 * 因为要返回的是前k个最小的数，并不需要有序, 因此我们可以利用快速排序的特性求解。
 * 快速排序每进行一次后会将一个数放置到它的最终位置，
 * 也就是说它左边的数一定 <= 它, 右边的数一定 >= 它,
 * 因此我们可以直接判断每次 partition 后当前的下标位置,
 * 若当前已归为的数的下标正好为 k , 则直接将左半部分(包括当前位置)返回即可,
 * 若当前已归为的数的下标 > k , 则只对左半部分进行相同的快排操作,
 * 已归为的数的下标 < k, 同理对右半部分操作
 */
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr == null || arr.length == 0 || k == 0){
            return new int[0];
        }
        return quickSort(arr, 0, arr.length - 1, k);
    }

    int[] quickSort(int[] arr, int left, int right, int k){
        int idx = partition(arr, left, right);
        if(idx + 1 == k){
            return Arrays.copyOf(arr, k);
        }
        else if(idx + 1 > k){
            return quickSort(arr, left, idx - 1, k);
        }
        else{
            return quickSort(arr, idx + 1, right, k);
        }
    }

    int partition(int[] arr, int left, int right){
        int pivot = arr[left];
        int i = left + 1, j = right;
        while(i <= j){
            while(i <= j && arr[i] <= pivot) i++;
            while(i <= j && arr[j] >= pivot) j--;
            if(i > j) break;
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        arr[left] = arr[j];
        arr[j] = pivot;
        return j;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
