package com.company;
import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String args[]) {
        Scanner sc =new Scanner(System.in);
        int len =sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i]=sc.nextInt();
        }
        int[] result = mergeSort(arr,len);
        System.out.println(Arrays.toString(result));
    }
    public static int[] mergeSort(int[] arr, int len) {
        int[] buf1 = Arrays.copyOf(arr, len);
        int[] buf2 = new int[len];
        int[] result = mergeSortInner(buf1, buf2, 0, len);
        return result;
    }
    public static int[] mergeSortInner(int[] buf1, int[] buf2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buf1;
        }
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(buf1, buf2, startIndex, middle);
        int[] sorted2 = mergeSortInner(buf1, buf2, middle, endIndex);
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buf1 ? buf2 : buf1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }

}