//Given an array of integers numbers sorted in ascending order, find the starting and ending position of several given target values. If a target is not found in the array, return [-1, -1]. You must write an algorithm with O(logn)O(logn) runtime complexity for each given target.

import java.util.Scanner;

public class FirstandLastPositionSearch {
    public int[] twoSplitSearch(int length, int target, int[] num){
        int[] result = new int[2];
        int left = 0;
        int right = length - 1;
        int mid = 0;
        if(num[0] == target){
            left = 0;
        } else {
            while(left < right){
                mid = left + (right - left) / 2;
                if(num[mid] < target){
                    left = mid + 1;
                } else{
                    right = mid;
                }
            }
            if(num[left] != target){
                return new int[] {-1, -1};
            }
        }
        result[0] = left;
        left = 0;
        right = length - 1;
        if(num[length - 1] == target){
            right = length - 1;
        } else {
            while(left < right){
                if(((right - left) % 2) == 1){
                    mid = left + (right - left) / 2 + 1;
                } else {
                    mid = left + (right - left) / 2;
                }
                if(num[mid] <= target){
                    left = mid;
                } else{
                    right = mid - 1;
                }
            }
        }
        result[1] = right;
        return result;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int length;
        int targetNum;
        length = input.nextInt();
        targetNum = input.nextInt();
        int[] num = new int[length];
        for(int i=0; i<length; i++){
            num[i] = input.nextInt();
        }
        FirstandLastPositionSearch res = new FirstandLastPositionSearch();
        int[][] ans = new int[targetNum][2];
        for(int i=0; i<targetNum; i++){
            int target = input.nextInt();
            ans[i] = res.twoSplitSearch(length, target, num);
        }
        for(int i=0; i<targetNum; i++){
            System.out.print(ans[i][0]);
            System.out.print(" ");
            System.out.print(ans[i][1]);
            System.out.print("\n");
        }
    }
}
