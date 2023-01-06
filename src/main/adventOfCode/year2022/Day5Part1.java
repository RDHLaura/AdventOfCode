package main.adventOfCode.year2022;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Day5Part1 {

    final static File file = new File("src/main/resources/year2022/Day5.txt");

    public static void main(String[] args) {
        Day5Part1 solution = new Day5Part1();
        solution.getSolution();

    }


    public void getSolution (){


        String[] dividedInput = divideInput();

        String str_stack = dividedInput[0];
        Map<Integer, ArrayList<String>> mapStacks = getStack( str_stack);

        String str_instructions = dividedInput[1];
        ArrayList<Instruction> instructions = getInstructions(str_instructions);


        Map<Integer, ArrayList<String>> result = followInstructions(mapStacks, instructions);

        result.forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));

        result.forEach((k,v) -> System.out.print( v.get(0)));
    }

    public String[] divideInput () {
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
            String str = new String(data, "UTF-8");
            String[] dividedInput = str.split("\n\n");

            return dividedInput;



        }catch (Exception e){
            System.out.println(e);
        }

        return null;
    }

    public Map<Integer, ArrayList<String>> followInstructions (Map<Integer, ArrayList<String>> stacks,ArrayList<Instruction> instructions){
        for (Instruction i: instructions) {
            for (int j = 0; j < i.amount ; j++) {
                stacks.get(i.to).add(0,
                    stacks.get(i.from).remove(0)
                );
            }
        }
        return stacks;
    }
    public ArrayList<Instruction> getInstructions (String str_instructions){
        ArrayList<String> list_instructions = new ArrayList<> (
                Arrays.asList(str_instructions.split("\n"))
        );

        ArrayList<Instruction> instructions= new ArrayList<>();

        Pattern p = Pattern.compile("[a-zA-Z]+(\s)");

        for (String l: list_instructions) {
            ArrayList<String> formatInstructions = new ArrayList<>(Arrays.asList(p.split(l)));
            formatInstructions.remove(0);
            int a, f, t;

            a = parseInt(formatInstructions.get(0).trim());
            f = parseInt(formatInstructions.get(1).trim());
            t = parseInt(formatInstructions.get(2).trim());
            Instruction inst = new Instruction(a, f, t);
            instructions.add(inst);
        }
        return instructions;
    }

    public class Instruction {
        int amount;
        int from;
        int to;
        Instruction(int a, int f, int t){
            this.amount = a;
            this.from = f;
            this.to = t;
        }

    }

    //recibe por parámetro los stacks en formato String
    public Map<Integer, ArrayList<String>> getStack ( String str_stack) {
        Map<Integer, ArrayList<String>> mapStack = new HashMap<>();

        List list_stacks = new LinkedList<>(Arrays.asList(str_stack.split("\n"))); //divido el string por líneas y lo almaceno como LinkedList que me permite modificarla
        //de la última línea hago un split para sacar los números
        Pattern p = Pattern.compile("\s+");
        String[] numberStacks = p.split(list_stacks.get(list_stacks
                                                .size()-1)//selecciono la fila de los números
                                                .toString() //lo convierto a String para poder usar el split
                                                .trim() //elimino los espacios
                                               );


        //creo una lista con las líneas de los stacks
        List<ArrayList<String>> lines = new ArrayList<>();

        //inicializa el diccionario y crea una lista de lineas por filas
        for (Object element: numberStacks) {
            int number = parseInt(element.toString());

            //formatea cada fila para crear un arraylist
            ArrayList<String> line = new ArrayList<>(Arrays.asList(list_stacks
                    .get(number-1)
                    .toString()
                    .replaceAll("    ", " [/] ")
                    .split(" ")
                    ));
            line.removeIf (n -> (!n.contains("[")));//elimina los elementos vacios
            lines.add(line);

            //inicializo el map
            ArrayList<String> initStack = new ArrayList<>();
            mapStack.put(number, initStack);
        }
        lines.remove(lines.size()-1); //elimino la línea vacía que se crea por los números de los stacks
        
        //creo la lista de cada stack
        for (Integer key : mapStack.keySet()) { //accedo a cada stack del map
            ArrayList<String> stack = new ArrayList<>(); //creo un arraylist para crear
            for (List<String > line: lines ) {
                stack.add(line.get(key-1).trim());
            }
            stack.removeAll(Collections.singleton("[/]"));
            mapStack.put(key, stack);
        }

        return mapStack;
    }



}
