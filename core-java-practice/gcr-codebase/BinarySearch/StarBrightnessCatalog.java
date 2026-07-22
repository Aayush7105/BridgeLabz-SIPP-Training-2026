package BinarySearch;

import java.util.Arrays;

public class StarBrightnessCatalog {

    public static int searchSorted(double[] stars, double target) {
        int left = 0, right = stars.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (stars[mid] == target) return mid;
            if (stars[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static int searchRotated(double[] stars, double target) {
        int left = 0, right = stars.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (stars[mid] == target) return mid;

            if (stars[left] <= stars[mid]) {
                if (target >= stars[left] && target < stars[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (target > stars[mid] && target <= stars[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }

    public static int[] findFirstAndLast(double[] stars, double target) {
        return new int[]{findBound(stars, target, true), findBound(stars, target, false)};
    }

    private static int findBound(double[] stars, double target, boolean isFirst) {
        int left = 0, right = stars.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (stars[mid] == target) {
                result = mid;
                if (isFirst) right = mid - 1;
                else left = mid + 1;
            } else if (stars[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return result;
    }

    public static double findMinimum(double[] stars) {
        int left = 0, right = stars.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (stars[mid] > stars[right]) left = mid + 1;
            else right = mid;
        }
        return stars[left];
    }

    public static void main(String[] args) {
        double[] sortedStars = {1.2, 2.5, 3.8, 3.8, 3.8, 4.1, 5.0};
        System.out.println("Search in sorted: " + searchSorted(sortedStars, 2.5));
        System.out.println("First and Last: " + Arrays.toString(findFirstAndLast(sortedStars, 3.8)));

        double[] rotatedStars = {4.1, 5.0, 1.2, 2.5, 3.8};
        System.out.println("Search in rotated: " + searchRotated(rotatedStars, 2.5));
        System.out.println("Min element: " + findMinimum(rotatedStars));
    }
}
