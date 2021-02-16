package org.example;

import org.example.functional.MyFunctionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void doSomethingTraditional(){
        //Primer nivel implementacion completa
        var instanciaTux = new Tux();
        System.out.println(instanciaTux.doSomething("Que divertida es la progra funcional"));

    }
    public static void doSomethingClassy(){
        //Clase anonima
        MyFunctionalInterface duke = new MyFunctionalInterface() {
            @Override
            public String doSomething(String param) {
                return "Hola soy duke y recibi " + param;
            }
        };
        System.out.println(duke.doSomething("clase anonima"));
    }
    public static void doSomethingFuncional(){
        //Expresiones lambda
        MyFunctionalInterface clippy = (String param) ->{
            return "Hola soy clippy y recibi "+ param;
        };

        MyFunctionalInterface wilbert = (p)->"Hola soy wilbert y recibi " + p;

        doSomethingHighOrder(clippy);
        doSomethingHighOrder(wilbert);
        doSomethingHighOrder(x -> "Hola soy anonimus y recibi " + x);
        
        var tux = new Tux();
        doSomethingHighOrder(tux::doSomething);

        var pickachu = new Pickachu();
        doSomethingHighOrder(pickachu::pika);
        doSomethingHighOrder(pickachu::impactrueno);

        //System.out.println(clippy.doSomething("parametro funcional"));
    }
    public static void doSomethingHighOrder(MyFunctionalInterface comportamiento){

        //Ejecuto el comportamiento que recibi como argumento
        var respuesta = comportamiento.doSomething("Java 11 es genial");
        System.out.println(respuesta);
    }
    public static void main( String[] args )
    {
        //doSomethingTraditional();
        //doSomethingClassy();
        //doSomethingFuncional();

        //List jedis = new ArrayList();
        //jedis.add("Anakin");
        //jedis.add("Leia");
        //jedis.add("Luke");
        //jedis.add("Rey");
        List jedis =  List.of("Anakin", "Leia", "Luke", "Rey");
        var filterjedis = jedis.stream()
                .filter(s -> !s.equals("Rey"))//Map
                .map(j -> j.toString().toUpperCase())//Map
                .collect(Collectors.toList());//Reduce

        var theJedi  = jedis.stream()
                .peek(System.out::println)
                .filter(s -> !s.equals("Rey"))//Map
                .peek(System.out::println)
                .map(j -> j.toString().toUpperCase())//Map
                .peek(System.out::println)
                .findFirst();//Reduce

        //System.out.println(filterjedis);
        System.out.println("Resultado --- " + theJedi.get());
        //jedis.forEach( param -> System.out.println(param) );

        //jedis.forEach(System.out::println);

        //Predicate<String> isNotJedi = s -> !s.equals("Rey");

        //jedis.removeIf(s-> s.equals("Rey"));
        //System.out.println(jedis);
    }
}
