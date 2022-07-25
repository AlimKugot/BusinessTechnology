package com.alim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Java 11. Interview from Business Technology company
 * https://spb.hh.ru/vacancy/68033966?hhtmFrom=vacancy_response
 *
 * My CV: https://spb.hh.ru/resume/42063d5bff090416c10039ed1f415239587049
 * @by Alim Kugot
 */
public class InterviewBusinessTechnology {

    /**
     * My function to pass interview.
     *
     * @param arr to merge
     * @param p   left
     * @param q   mid (splits left and right arrays)
     * @param r   right
     */
    public static void merge(List<Integer> arr, int p, int q, int r) {
        int left = p;
        int right = q + 1;
        List<Integer> res = new ArrayList<>(r);
        r++;
        if (r >= arr.size()) {
            r = arr.size();
        }

        while (left <= q && right < r) {
            int a = arr.get(left);
            int b = arr.get(right);

            if (a < b) {
                res.add(a);
                left++;
            } else {
                res.add(b);
                right++;
            }
        }

        while (left <= q) {
            res.add(arr.get(left));
            left++;
        }
        while (right < r) {
            res.add(arr.get(right));
            right++;
        }


        for (int i = p, z = 0; i < r; i++, z++) {
            arr.set(i, res.get(z));
        }
    }


    public static void sort(List<Integer> arr, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            sort(arr, p, q);
            sort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }


    public static void main(String[] args) {
        test(5, 2, 4, 6, 1, 3, 2);
        test(5, 2, 4, 6, 1, 3, 2, 8);
        test(5, 2);
        test(5, 2, 3);
        test(1, 2, 3, 4, 5, 6);
        test(1, 2, 3, 4, 5, 6, 7);
        test(1, 2, 3, 4, 5, 6, 7);
        test(7, 6, 5, 4, 3, 2, 1);
        test(7, 6, 5, 4, 3, 2);
    }

    public static void test(int... arg) {
        List<Integer> arr = Arrays.stream(arg).boxed().collect(Collectors.toList());
        List<Integer> expected = new ArrayList<>(arr);

        sort(arr, 0, arr.size());
        Collections.sort(expected);


        System.out.print(expected.equals(arr) + ": ");
        arr.forEach(el -> System.out.print(el + " "));
        System.out.println(); // \n
    }
}
