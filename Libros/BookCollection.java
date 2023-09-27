import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BookCollection {
    public static void main(String[] args) {
        ArrayList<Books> libros = new ArrayList<>();
        libros.add(new Books("Harry Potter", "J.K. Rowling", 600));
        libros.add(new Books("Los tres cerditos", "Paco Paquito", 30));
        libros.add(new Books("Don Quijote", "Cervantes", 340));
        libros.add(new Books("El señor de los anillos", "J.R.R. Tolkien", 576));
        libros.add(new Books("Caperucita roja", "Paco Paquito", 120));

        System.out.println("1.");
        /*long cont1 = libros.stream().filter(l -> l.getNumeroPaginas() > 500).count();
        System.out.println("Hay " + cont1 + " libros con más de 500 páginas");*/
        int cont1 = 0;
        for (Books b : libros) {
            if (b.getNumeroPaginas() > 500) {
                cont1++;
            }
        }
        System.out.println("Hay " + cont1 + " libro(s) con más de 500 páginas");

        System.out.println("2.");
        /*long cont2 = libros.stream().filter(l -> l.getNumeroPaginas() < 300).count();
        System.out.println("Hay " + cont2 + " libros con menos de 300 páginas");*/
        int cont2 = 0;
        for (Books b : libros) {
            if (b.getNumeroPaginas() < 300) {
                cont2++;
            }
        }
        System.out.println("Hay " + cont2 + " libro(s) con menos de 300 páginas");

        System.out.println("3.");
        for (Books b : libros) {
            if (b.getNumeroPaginas() >= 500) {
                System.out.println(b.getTitulo() + " tiene más de 500 páginas");
            }
        }

        System.out.println("4.");
        Collections.sort(libros, new Comparator<Books>() {
            @Override
            public int compare(Books b1, Books b2) {
                if (b1.getNumeroPaginas() > b2.getNumeroPaginas()) {
                    return -1;
                } else if (b1.getNumeroPaginas() < b2.getNumeroPaginas()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        for (int i = 0; i < 3; i++) {
            System.out.println(libros.get(i).getTitulo());
        }
        //libros.stream().sorted((l1, l2) -> Integer.compare(l2.getNumeroPaginas(), l1.getNumeroPaginas())).limit(3).map(l -> l.getTitulo()).forEach(System.out::println);

        System.out.println("5.");
        int paginas = 0;
        for (Books b : libros) {
            paginas += b.getNumeroPaginas();
        }
        System.out.println("El total de páginas es " + paginas);

        System.out.println("6.");
        int librosTotal = 0;
        for (Books b : libros) {
            librosTotal++;
        }
        int media = paginas / librosTotal;
        for (Books b : libros) {
            if (b.getNumeroPaginas() > media) {
                System.out.println("El libro " + b.getTitulo() + " supera el promedio de número de páginas");
            }
        }

        System.out.println("7.");
        ArrayList<String> autores = new ArrayList<>();
        System.out.println("Autores:");
        for (Books b : libros) {
            if (!autores.contains(b.getAutor())) {
                autores.add(b.getAutor());
            }
        }
        System.out.println(autores);

        System.out.println("8.");
        ArrayList<String> autores2 = new ArrayList<>();
        ArrayList<String> autoresRepetidos = new ArrayList<>();
        System.out.println("Autores con más de 1 libro:");
        for (Books b : libros) {
            if (autores2.contains(b.getAutor())) {
                autoresRepetidos.add(b.getAutor());
            } else {
                autores2.add(b.getAutor());
            }
        }
        System.out.println(autoresRepetidos);

        System.out.println("9.");
        int mayNumPag = 0;
        for (Books b : libros) {
            if (b.getNumeroPaginas() > mayNumPag) {
                mayNumPag = b.getNumeroPaginas();
            }
        }
        for (Books b : libros) {
            if (mayNumPag == b.getNumeroPaginas()) {
                System.out.println("El libro con mayor número de páginas es " + b.getTitulo());
            }
        }
    }
}
