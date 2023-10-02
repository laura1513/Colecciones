import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HotelFuncional {
    public static void main(String[] args) {
        ArrayList<Hotel> hoteles= new ArrayList<>();
        hoteles.add(new Hotel("Gran Via", "Madrid", 5));
        hoteles.add(new Hotel("Juanito", "Santander", 2));
        hoteles.add(new Hotel("Casa Pep", "Valencia", 4));
        hoteles.add(new Hotel("Casa maria", "Santander", 3));
        hoteles.add(new Hotel("Alcora", "Santander", 2));

        System.out.println("Hoteles ocn al menos 3 estrellas:");
        Stream<Hotel> tresEstrellas = hoteles.stream().filter(h -> h.getRating() >= 3);
        tresEstrellas.map(h -> h.getNombre()).forEach(System.out::println);
        System.out.println();

        String hotelesSantander = hoteles.stream().filter(h -> h.getCiudad() == "Santander").map(h -> h.getNombre()).collect(Collectors.joining(", ", "Hoteles de Santander: ", "."));
        System.out.println(hotelesSantander);
        System.out.println();

        double mediaRating = hoteles.stream().mapToInt(Hotel::getRating).average().getAsDouble();
        System.out.println("La media de rating de los hoteles es: " + mediaRating);
        System.out.println();

        long contHotelesSantander = hoteles.stream().filter(h -> h.getCiudad() == "Santander").count();
        System.out.println("Hay " + contHotelesSantander + " hoteles en Santander");
    }
}
