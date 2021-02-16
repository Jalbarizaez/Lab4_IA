package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsDemo {

    public static List<Integer> createRandomList(int qty){
        var random = new Random();
        List<Integer> numbers = new LinkedList<>();
        for(int i = 0; i< qty;i++ ) {
            numbers.add(random.nextInt(100));
        }
        return numbers;
    }
    public static Long Fibonacci(int n) {
        long num1 = 0;
        long num2 = 1;
        long auxiliar = 0;

        for (int i = 0; i < n; i++) {

            auxiliar = num1;
            num1 = num2;
            num2 = auxiliar + num1;

        }
        return num2;
    }

    public static List<Integer> sortList(List<Integer> unsortedList){
        Collections.sort(unsortedList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        return unsortedList;
    }
    public static List<Integer> sortLambdaList(List<Integer> unsortedList){
        Collections.sort(unsortedList, ( o1,  o2) -> o1.compareTo(o2));
        return unsortedList;
    }
    public static boolean isPrimeNumber(int n ){
        if(n <= 1)
            return false;
        var contador = 0 ;
        for (int i = n - 1; i > 1; i--) {
            if(n % i == 0){
                contador++;
            }
        }
        return contador <= 0;
    }
    public static void main (String args[]){

        System.out.println("Iniciando calculo primos");
        //var listadoPrimos = createRandomList(Integer.valueOf(args[0])).parallelStream()
                //.filter(n -> isPrimeNumber(n))
                //.sorted()
                //.collect(Collectors.toList());

        var listadoPrimos = createRandomList(Integer.valueOf(args[0])).stream()
                .filter(n -> isPrimeNumber(n))
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Finalizando calculo primos");
        System.out.println(listadoPrimos);
        System.out.println("Cantidad numeros primos " +listadoPrimos.size());
        System.out.println("Iniciando calculo fibonacci");
        List<Long> listadoFibonaci = new ArrayList<Long>();
        listadoPrimos.forEach(n -> listadoFibonaci.add(Fibonacci(n)));
        System.out.println("Finalizando calculo fibonacci");
        System.out.println(listadoFibonaci);
        System.out.println("Cantidad numeros fibonacci " + listadoFibonaci.size());



        /*var primos = IntStream.range(0,100).boxed()
                .filter(n -> isPrimeNumber(n))
                .collect(Collectors.toList());
        System.out.println(primos);

         var randomNumbers = createRandomList(10);
        System.out.println(randomNumbers);
        sortLambdaList(randomNumbers);
        System.out.println(randomNumbers);*/

    }
}
