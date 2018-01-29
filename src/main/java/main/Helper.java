package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Shelk on 1/29/2018.
 */
public class Helper {

    private static FileReader fileReader;
    private static Scanner scanner;

    static List<String> readFile(String path) {
        List<String> list = new ArrayList<>();
        try {
            fileReader = new FileReader(path);
            scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                list.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Упс, а файла-то и нет");
        }
        return list;
    }

    static List<Integer> lettersToDigits(List<String> letters) {
        List<Integer> digits = new ArrayList<>();
        letters.forEach(n -> digits.add(Integer.parseInt(n)));
        return digits;
    }

    static List<Integer> sort(List<Integer> list, boolean reverse) {
        if (!reverse) {
            Collections.sort(list);
        } else {
            Collections.sort(list, Collections.reverseOrder());
        }
        return list;
    }
}
