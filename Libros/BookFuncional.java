import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookFuncional {
    public static void main(String[] args) {
        ArrayList<Books> libros = new ArrayList<>();
        libros.add(new Books("Harry Potter", "J.K. Rowling", 600));
        libros.add(new Books("Los tres cerditos", "Paco Paquito", 30));
        libros.add(new Books("Don Quijote", "Cervantes", 340));
        libros.add(new Books("El señor de los anillos", "J.R.R. Tolkien", 576));
        libros.add(new Books("Caperucita roja", "Paco Paquito", 120));

        //1
        long cont500pag = libros.stream()
                .filter(l -> l.getNumeroPaginas() > 500)
                .count();
        System.out.println("Hay " + cont500pag + " libros con más de 500 páginas");
        System.out.println();

        //2
        long cont300pag = libros.stream()
                .filter(l -> l.getNumeroPaginas() < 300)
                .count();
        System.out.println("Hay " + cont300pag + " libros con menos de 300 páginas");
        System.out.println();

        //3
        String librosMas500 = libros.stream()
                .filter(l -> l.getNumeroPaginas() > 500)
                .map(l -> l.getTitulo())
                .collect(Collectors.joining(", ", "Los libros con más de 500 páginas son: ", "."));
        System.out.println(librosMas500);
        System.out.println();

        //4
        String tresMayorNumPag = libros.stream()
                .sorted((l1, l2) -> Integer.compare(l2.getNumeroPaginas(), l1.getNumeroPaginas()))
                .limit(3)
                .map(l -> l.getTitulo())
                .collect(Collectors.joining(", ", "Los 3 libros con más páginas son: ", "."));
        System.out.println(tresMayorNumPag);
        System.out.println();

        //5
        int paginas = libros.stream()
                .map(l -> l.getNumeroPaginas())
                .reduce(0, (a, b) -> a + b);
        /*int paginas2 = libros.stream()
                .mapToInt(Books::getNumeroPaginas)
                .sum();*/
        System.out.println("La suma total del número de paǵinas es: " + paginas);
        System.out.println();

        //6
        double media = libros.stream()
                .mapToInt(Books::getNumeroPaginas)
                .average().getAsDouble();
        String mayorPagQueMedia = libros.stream()
                .filter(l -> l.getNumeroPaginas() > media)
                .map(Books::getTitulo)
                .collect(Collectors.joining(", ", "Los libros que superan el promedio en cuanto a número de páginas son: ", "."));
        System.out.println(mayorPagQueMedia);
        System.out.println();


        //7
        String autores = libros.stream()
                .map(Books::getAutor)
                .distinct()
                .collect(Collectors.joining(", ", "Los autores de la lista son: ", "."));
        System.out.println(autores);
        System.out.println();

        //8
        String autoresRepetidos = libros.stream()
                .collect(Collectors.groupingBy(Books::getAutor, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(b -> b.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(", ", "Los autores con más de 1 libro son: ", "."));
        System.out.println(autoresRepetidos);
        System.out.println();

        //9
        String titulo = libros.stream()
                .max(Comparator.comparingInt(Books::getNumeroPaginas))
                .get()
                .getTitulo();
        System.out.println("El libro con más páginas es " + titulo);
        System.out.println();

        //10
        System.out.println("Lista de libros:");
        List<Books> listaLibros = libros.stream()
                .toList();
        for (Books b : listaLibros) {
            System.out.println(b);
        }
    }
}

