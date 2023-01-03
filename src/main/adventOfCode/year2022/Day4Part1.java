package main.adventOfCode.year2022;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;

public class Day4Part1 {
    final static File file = new File("src/main/resources/year2022/Day4.txt");

    public static void main(String[] args) {
        Day4Part1 solution = new Day4Part1();
        System.out.println(solution.readFile(file));
    }

    public int readFile (File file){
        int sum = 0;
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                sum += (isFullyContains(line))? 1 : 0 ;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return sum;
    }


    //comprueba si uno de los rangos de la pareja contiene al otro y devuelve un boolean
    public boolean isFullyContains (String line){
        String[] pair = line.split(",");
        List elf1 =  getRange(pair[0]);
        List elf2 =  getRange(pair[1]);
        if(elf1.isEmpty() || elf2.isEmpty()){
            return false;
        }
        return  (elf1.containsAll(elf2) || elf2.containsAll(elf1));
    }
    //crea una lista con todos los valores del rango
    public List getRange(String range){
        String[] listRange = range.split("-");
        int startInclusive =parseInt(listRange[0]);
        int endInclusive =parseInt(listRange[1])+1;
        IntStream intStream = IntStream.range(startInclusive, endInclusive);
        return intStream.boxed().collect(Collectors.toList());
    }
}
