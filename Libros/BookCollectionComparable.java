import java.util.ArrayList;
import java.util.Collections;

public class BookCollectionComparable {
    public static void main(String[] args) {
        ArrayList<Books> libros = new ArrayList<>();
        libros.add(new Books("Harry Potter", "J.K. Rowling", 600));
        libros.add(new Books("Los tres cerditos", "Paco Paquito", 30));
        libros.add(new Books("Don Quijote", "Cervantes", 340));
        libros.add(new Books("El señor de los anillos", "J.R.R. Tolkien", 576));
        libros.add(new Books("Caperucita roja", "Paco Paquito", 120));

        System.out.println("Libros ordenados alfabeticamente: ");
        Collections.sort(libros);
        for (Books b : libros) {
            System.out.println(b.getTitulo());
        }
    }
}
