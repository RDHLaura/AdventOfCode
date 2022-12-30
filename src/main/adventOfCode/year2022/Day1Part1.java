package main.adventOfCode.year2022;

import java.io.File;
import java.util.*;

import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.util.Collections.*;

public class Day1Part1 {
    final static File file = new File("src/main/resources/year2022/Day1.txt");
    public static void main(String... args) {
       Day1Part1 solution = new Day1Part1();
       solution.mostCalories();

    }

    void mostCalories (){
        List<Integer> list = calculateCalories(file);
        sort(list);
        reverse(list);
        System.out.println(list.get(0));
    }

    public  List<Integer> calculateCalories (File file){
        List<Integer> listCalories = new ArrayList<>();
        try{
            Scanner myReader = new Scanner(file);
            int sum = 0;
            //lee las líneas del input, si es un salto de línea añade la suma a la lista
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                if(line == ""){
                    listCalories.add(sum);
                    sum = 0;
                }else{
                    sum += parseInt(line);
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return listCalories;
    }

}
