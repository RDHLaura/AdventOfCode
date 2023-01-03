package main.adventOfCode.year2022;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day4Part2 extends Day4Part1{
    public static void main(String[] args) {
        Day4Part2 day4Part2 = new Day4Part2();
        System.out.println(day4Part2.readFile(file));
    }

    @Override
    public boolean isFullyContains(String line) {
        String[] pair = line.split(",");
        List elf1 =  getRange(pair[0]);
        List elf2 =  getRange(pair[1]);
        if(elf1.isEmpty() || elf2.isEmpty()){
            return false;
        }
        return  (!Collections.disjoint(elf1, elf2));
    }
}
