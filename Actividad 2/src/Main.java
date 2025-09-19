import java.util.Locale;
import java.util.Scanner;

class Estudiante {
    String nombre;
    double[] califs = new double[5];

    Estudiante(String nombre, double[] califs) {
        this.nombre = nombre;
        if (califs.length != 5) throw new IllegalArgumentException("Deben ser 5 calificaciones");
        this.califs = califs;
    }

    // a) Metodo que calcula el promedio de las cinco calificaciones
    static double calcularPromedio(double[] arr) {
        double s = 0;
        for (double x : arr) s += x;
        return s / arr.length;
    }

    // b) Metodo que devuelve la calificación final A–F a partir del promedio
    static char calificacionFinal(double promedio) {
        if (promedio <= 50) return 'F';
        else if (promedio <= 60) return 'E';
        else if (promedio <= 70) return 'D';
        else if (promedio <= 80) return 'C';
        else if (promedio <= 90) return 'B';
        else return 'A'; // 91–100
    }

    // c) Metodo que imprime en el formato solicitado
    static void imprimirResultados(String nombre, double[] califs, double promedio, char califLetra) {
        System.out.println("Nombre del estudiante: " + nombre);
        System.out.println("Calificación 1: " + califs[0]);
        System.out.println("Calificación 2: " + califs[1]);
        System.out.println("Calificación 3: " + califs[2]);
        System.out.println("Calificación 4: " + califs[3]);
        System.out.println("Calificación 5: " + califs[4]);
        System.out.printf(Locale.US, "Promedio: %.2f%n", promedio);
        System.out.println("Calificación: " + califLetra);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        double[] califs = new double[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Calificación " + (i + 1) + " (0-100): ");
            califs[i] = sc.nextDouble();
        }

        Estudiante e = new Estudiante(nombre, califs);
        double promedio = Estudiante.calcularPromedio(e.califs);
        char letra = Estudiante.calificacionFinal(promedio);
        Estudiante.imprimirResultados(e.nombre, e.califs, promedio, letra);
    }
}
