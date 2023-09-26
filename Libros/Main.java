import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Books> libros = new ArrayList<>();
        libros.add(new Books("Harry Potter", "J.K. Rowling", 470));
        libros.add(new Books("Los tres cerditos", "Paco Paquito", 30));
        libros.add(new Books("Don Quijote", "Cervantes", 340));
        libros.add(new Books("El señor de los anillos", "J.R.R. Tolkien", 576));

        /*long cont1 = libros.stream().filter(l -> l.getNumeroPaginas() > 500).count();
        System.out.println("Hay " + cont1 + " libros con más de 500 páginas");*/
        int cont1 = 0;
        for (Books b : libros) {
            if (b.getNumeroPaginas() >= 500) {
                cont1++;
            }
        }
        System.out.println("Hay " + cont1 + " libro(s) con más de 500 páginas");

        /*long cont2 = libros.stream().filter(l -> l.getNumeroPaginas() < 300).count();
        System.out.println("Hay " + cont2 + " libros con menos de 300 páginas");*/
        int cont2 = 0;
        for (Books b : libros) {
            if (b.getNumeroPaginas() <= 300) {
                cont2++;
            }
        }
        System.out.println("Hay " + cont2 + " libro(s) con menos de 300 páginas");

        for (Books b : libros) {
            if (b.getNumeroPaginas() >= 500) {
                System.out.println(b.getTitulo() + " tiene más de 500 páginas");
            }
        }

    }
}
