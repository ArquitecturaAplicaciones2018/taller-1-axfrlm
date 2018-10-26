import java.util.Comparator;
import java.util.List;
/**
 * @author Fernanado
 * @version 0.1
 * **/
public class Main {
    public static void main(String[] args) {
        var rationals = List.of(
                new Rational(1, 4),
                new Rational(1, 8),
                new Rational(3, 4),
                new Rational(9, 8));

        //Obtener todos los números racionales que sean menores a 1/2
        var unMedio= new Rational(1,2);
        System.out.println("Es menor que 1/2:");
        rationals.stream()
                .filter(r -> r.isLessThan(unMedio))
                .forEach(System.out::println);

        //Sumar todos los racionales
        rationals.stream()
                .reduce(Rational::plus)
                .ifPresent(r-> System.out.println("Suma Total: "+r));

        //Obtener el número racional mayor
        rationals.stream()
                .max(Comparator.comparing(Rational::toString))
                .ifPresent(r-> System.out.println("El mayor es: "+r));

        //Sumar todos numeradores y obtener los siguientes datos: número de elementos, la suma de los numeradores, el numerador menor, el mayor y el promedio

        //Sumar todos numeradores
        System.out.println("Suma total los numeradores: "+rationals.stream()
                .mapToInt(r-> r.getNumerator())
                .sum());

        // número de elementos
        System.out.println("Numero de elementos: "+rationals.stream()
                .mapToInt(r-> r.getNumerator())
                .count());

        // el numerador menor,
        rationals.stream()
                .mapToInt(r-> r.getNumerator())
                .min()
                .ifPresent(r-> System.out.println("El menor denominador es: "+r));

        // el mayor
        rationals.stream()
                .mapToInt(r-> r.getNumerator())
                .max().ifPresent(r-> System.out.println("El mayor denominador es: "+r));

        // y el promedio
        rationals.stream()
                .mapToInt(r-> r.getNumerator())
                .average()
                .ifPresent(r-> System.out.println("El promedio: "+r));
    }
}
