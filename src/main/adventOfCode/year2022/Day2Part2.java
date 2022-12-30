package main.adventOfCode.year2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2Part2 extends Day2Part1{
    public static void main(String[] args) {
        Day2Part2 d2p2 = new Day2Part2();
        int result= d2p2.getTotalScore();
        System.out.println(result);
    }

    @Override
    public int calculateScore(String line) {
        List<String> listLine = new ArrayList<String>(Arrays.asList(line.split(" ")));
        int score = 0;
        if(listLine.get(1).equals("X")){ //debe perder
            score += 0;
            switch (listLine.get(0)){
                case "A":
                    score += 3; //usa Z
                    break;
                case "B":
                    score += 1; //usa X
                    break;
                case "C":
                    score += 2; //usa Y
                    break;
            }

        } else if (listLine.get(1).equals("Y")) { //debe empatar
            score += 3;
            switch (listLine.get(0)){
                case "A":
                    score += 1; //usa X
                    break;
                case "B":
                    score += 2;//usa Y
                    break;
                case "C":
                    score += 3; //usa Z
                    break;
            }

        } else if (listLine.get(1).equals("Z")) { //debe ganar
            score += 6;
            switch (listLine.get(0)){
                case "A":
                    score += 2; //usa Y
                    break;
                case "B":
                    score += 3;//usa Z
                    break;
                case "C":
                    score += 1;//usa X
                    break;
            }
        }
        return score;
    }
}
