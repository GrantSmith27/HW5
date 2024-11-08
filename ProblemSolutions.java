/******************************************************************
 *
 *   YOUR NAME / SECTION NUMBER
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;
//Grant Smith Comp 272
class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {

        //create a HashSet for list1's values
        HashSet<Integer> set = new HashSet<>();
        //puts all list1's value into new HashSet
        for (int num : list1) {
            set.add(num);
        }
        //checks if all values from list2 is in HashSet
        for (int num : list2) {
            //if there are any values from list2 that aren't in list1, it's not a subset
            if (!set.contains(num)) {
                return false;
            }
        }
        //if all values in list2 are also in list1, it's a subset
        return true;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        //create a min-heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        //add the first k elements to the min-heap
        for (int i = 0; i < k; i++) {
            minHeap.add(array[i]);
        }

        //check to add them to the heap
        for (int i = k; i < array.length; i++) {
            //if the current element is larger than the smallest in the min-heap, remove the smallest element
            if (array[i] > minHeap.peek()) {
                minHeap.poll();
                //add the current element
                minHeap.add(array[i]);
            }
        }

        //top of min-heap is largest k element
        return minHeap.peek();
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {
        //create an array that can hold elements from both arrays
        int combinedLength = array1.length + array2.length;
        int[] combinedArray = new int[combinedLength];
        //copy elements from array1 and array2 into combined array
        System.arraycopy(array1, 0, combinedArray, 0, array1.length);
        System.arraycopy(array2, 0, combinedArray, array1.length, array2.length);
        //sort combined array
        Arrays.sort(combinedArray);

        return combinedArray;
    }
}