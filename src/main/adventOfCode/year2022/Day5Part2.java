package main.adventOfCode.year2022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day5Part2 extends Day5Part1{
    public static void main(String[] args) {
        Day5Part2 solution = new Day5Part2();
        solution.getSolution();
    }

    @Override
    public Map<Integer, ArrayList<String>> followInstructions(Map<Integer, ArrayList<String>> stacks, ArrayList<Instruction> instructions) {

        for (Instruction i: instructions) {
            ArrayList<String> removed = new ArrayList<>();
            for (int j = 0; j < i.amount; j++) {
                removed.add(stacks.get(i.from).remove(0));
            }
            stacks.get(i.to).addAll(0, removed);

        }
        return stacks;
    }
}
