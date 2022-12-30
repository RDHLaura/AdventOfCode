package main.adventOfCode.year2022;

import java.util.List;

import static java.util.Collections.reverse;
import static java.util.Collections.sort;
import static main.adventOfCode.year2022.Day1Part1.file;

public class Day1Part2 {
    public static void main(String[] args) {
       Day1Part2 part2 = new Day1Part2();
       part2.mostsCalories();

    }
    void mostsCalories(){
        Day1Part1 part1 = new Day1Part1();
        List<Integer> listCalories = part1.calculateCalories(file);
        sort(listCalories);
        reverse(listCalories);
        System.out.println(listCalories.get(0)+ listCalories.get(1) +listCalories.get(2));
    }
}
