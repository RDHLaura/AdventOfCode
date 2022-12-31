package main.adventOfCode.year2022;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day3Part2 extends Day3Part1{
    //hago grupos de 3 líneas
    //recorro una y compruebo que el elemento esté en las otras dos
    //calculo el valor del item repetido
    //lo almaceno en una lista
    //sumo los valores de la lista

    public static void main(String[] args) {
        Day3Part2 solution = new Day3Part2();
        int result = solution.backpackValues(file)
                .stream()
                .reduce(0, (a,b)-> a + b);
        System.out.println(result);
    }
    @Override
    public List<Integer> backpackValues(File file) {
        List<Integer> listBackpackValues = new ArrayList<>();

        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                List<String > lines = new ArrayList<>();
                for(int i = 0; i <= 2; i++){
                    String line = sc.nextLine();
                    lines.add(line);
                }
                listBackpackValues.add(compareBackpacks(lines));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return listBackpackValues;
    }

    public int compareBackpacks(List<String> lines) {
        int valuebackpack = 0;
        for (Character c : lines.get(0).toCharArray()){
            if(lines.get(1).contains(c.toString()) && lines.get(2).contains(c.toString())){
                valuebackpack += getValue(c);
                break;
            }
        }
        return valuebackpack;
    }
}
