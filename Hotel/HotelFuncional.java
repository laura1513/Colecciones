import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HotelFuncional {
    public static void main(String[] args) {
        ArrayList<Hotel> hoteles= new ArrayList<>();
        hoteles.add(new Hotel("Gran Via", "Madrid", 5));
        hoteles.add(new Hotel("Juanito", "Santander", 4));
        hoteles.add(new Hotel("Casa Pep", "Valencia", 4));
        hoteles.add(new Hotel("Casa maria", "Santander", 3));
        hoteles.add(new Hotel("Alcora", "Santander", 2));

        System.out.println("Hoteles con al menos 3 estrellas:");
        hoteles.stream()
                .filter(h -> h.getRating() >= 3)
                .forEach(System.out::println);

        System.out.println();

        String hotelesSantander = hoteles.stream()
                .filter(h -> h.getCiudad() == "Santander")
                .map(Hotel::getNombre)
                .collect(Collectors.joining(", ", "Hoteles de Santander: ", "."));
        System.out.println(hotelesSantander);

        System.out.println();

        double media = hoteles.stream()
                .mapToInt(Hotel::getRating)
                .average()
                .getAsDouble();
        System.out.println("La medi de rating de los hoteles es: " + media);

        System.out.println();

        long contHotelesSantander = hoteles.stream()
                .filter(h -> h.getCiudad() == "Santander")
                .count();
        System.out.println("Hay " + contHotelesSantander + " hoteles en Santander");

        System.out.println();

        hoteles.stream().
                sorted((h1, h2) -> (h2.getRating() - h1.getRating()))
                .forEach(System.out::println);
    }
}
