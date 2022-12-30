package main.adventOfCode.year2022;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day2Part1 {
    final static File file = new File("src/main/resources/year2022/Day2.txt");

    public static void main(String[] args) {
        Day2Part1 solution = new Day2Part1();
        int result = solution.getTotalScore();
        System.out.println(result);
    }
    public int getTotalScore ( ){
        int totalScore = getScores(file)
                .stream()
                .reduce(0, (a,b)-> a + b);
        return totalScore;
    }
    public int calculateScore (String line){
        List<String> listLine = new ArrayList<String>(Arrays.asList(line.split(" ")));
        int score = 0;
        if(listLine.get(1).equals("X")){
            score += 1;
            switch (listLine.get(0)){
                case "A":
                    score += 3; //empate
                    break;
                case "B":
                    score += 0; //pierde
                    break;
                case "C":
                    score += 6; //gana
                    break;
            }
            
        } else if (listLine.get(1).equals("Y")) {
            score += 2;
            switch (listLine.get(0)){
                case "A":
                    score += 6;
                    break;
                case "B":
                    score += 3;
                    break;
                case "C":
                    score += 0; //pierde
                    break;
            }
            
        } else if (listLine.get(1).equals("Z")) {
            score += 3;
            switch (listLine.get(0)){
                case "A":
                    score += 0;
                    break;
                case "B":
                    score += 6;
                    break;
                case "C":
                    score += 3;
                    break;
            }
        }
        return score;
    }
    public List<Integer> getScores (File file){
        List<Integer> listScores = new ArrayList<>();
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                listScores.add(calculateScore(line));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return  listScores;
    }
}
