package main;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Shelk on 1/29/2018.
 */
public class Main {

    public static void main(String[] args) {
        List<String> list = Helper.readFile("src/main/resources/digits.txt");
        list.forEach(n -> System.out.println(n));
        System.out.println();

        List<String> letters = Arrays.asList(list.get(0).split(","));
        List<Integer> digits = Helper.lettersToDigits(letters);
        System.out.println(Helper.sort(digits, false).toString());
        System.out.println(Helper.sort(digits, true).toString());
        System.out.println();
    }
}
