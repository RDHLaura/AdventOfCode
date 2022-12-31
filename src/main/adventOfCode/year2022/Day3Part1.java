package main.adventOfCode.year2022;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day3Part1 {
    //leer una línea
    //dividirla en 2
    //buscar coincidencias
    //sacar valor de la coincidencia
    //almacenar el valor en una lista de todas las mochilas
    //sumar valores

    final static File file = new File("src/main/resources/year2022/Day3.txt");
    public static void main(String[] args) {
        Day3Part1 solution = new Day3Part1();
        int result = solution.backpackValues(file)
                .stream()
                .reduce(0, (a,b)-> a + b);
        System.out.println(result);
    }


    public List<Integer> backpackValues(File file){
        List<Integer> listBackpackValues = new ArrayList<>();

        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                listBackpackValues.add(calculateBackpack(line));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return listBackpackValues;
    }

    public int calculateBackpack (String line){
        int middle = line.length()/2;
        String part1 = line.substring(0, middle);
        String part2 = line.substring(middle);
        int valuebackpack = 0;
        for (Character c : part1.toCharArray()){
            if(part2.contains(c.toString())){
                valuebackpack += getValue(c);
                break;
            }
        }

        return valuebackpack;
    }

    //calcula el valor ascii y resta 96 o 38 para que cuadre con los valores asiganados por el reto
    // [a-z] -> 1-26
    // [A-Z] -> 97-52
    public int getValue (Character c){
        int value = 0;
        if((int) c >= 97){
            value = (int)c - 96;
        }else{
            value = (int)c - 38;
        }
        return value;
    }

}
