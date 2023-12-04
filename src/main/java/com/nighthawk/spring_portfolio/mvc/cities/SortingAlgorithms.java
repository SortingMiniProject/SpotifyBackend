package com.nighthawk.spring_portfolio.mvc.cities; // Adjust the package name as per your project structure
import java.util.ArrayList;
import java.util.List;

public class SortingAlgorithms {

    // Bubble Sort
    public static List<String> bubbleSort(List<String> data) {
        int n = data.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data.get(j).length() > data.get(j + 1).length()) {
                    String temp = data.get(j);
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, temp);
                }
            }
        }
        return data;
    }

    // Insertion Sort
    public static List<String> insertionSort(List<String> data) {
        for (int i = 1; i < data.size(); i++) {
            String key = data.get(i);
            int j = i - 1;

            while (j >= 0 && data.get(j).length() > key.length()) {
                data.set(j + 1, data.get(j));
                j = j - 1;
            }
            data.set(j + 1, key);
        }
        return data;
    }

    // Merge Sort
    public static List<String> mergeSort(List<String> data) {
        if (data.size() <= 1) {
            return data;
        }

        int mid = data.size() / 2;
        List<String> left = new ArrayList<>(data.subList(0, mid));
        List<String> right = new ArrayList<>(data.subList(mid, data.size()));

        return merge(mergeSort(left), mergeSort(right));
    }

    private static List<String> merge(List<String> left, List<String> right) {
        List<String> result = new ArrayList<>();
        int leftIndex = 0, rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex).length() <= right.get(rightIndex).length()) {
                result.add(left.get(leftIndex++));
            } else {
                result.add(right.get(rightIndex++));
            }
        }

        result.addAll(left.subList(leftIndex, left.size()));
        result.addAll(right.subList(rightIndex, right.size()));

        return result;
    }

    // Selection Sort
    public static List<String> selectionSort(List<String> data) {
        for (int i = 0; i < data.size() - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < data.size(); j++) {
                if (data.get(j).length() < data.get(minIdx).length()) {
                    minIdx = j;
                }
            }

            String temp = data.get(minIdx);
            data.set(minIdx, data.get(i));
            data.set(i, temp);
        }
        return data;
    }
}
