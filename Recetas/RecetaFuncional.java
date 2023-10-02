import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RecetaFuncional {
    public static void main(String[] args) {
        ArrayList<Receta> recetas = new ArrayList<>();
        recetas.add(new Receta("Macarrnes bolonesa", "Pasta", 100));
        recetas.add(new Receta("Ensalada", "Verduras", 50));
        recetas.add(new Receta("Solomillo", "Carnes", 500));
        recetas.add(new Receta("Merluza", "Pescado", 300));
        recetas.add(new Receta("Pechuga rebozada", "Carnes", 820));
        recetas.add(new Receta("Pure de verduras", "Verduras", 230));

        String recetasMenos500Calorias = recetas.stream().filter(r -> r.getCalorias() < 500).map(Receta::getNombre).collect(Collectors.joining(", ", "Receta(s) con menos de 500 calorías: ", "."));
        System.out.println(recetasMenos500Calorias);
        /*System.out.println("Recetas de menos de 500 calorías: ");
        recetas.stream().filter(r -> r.getCalorias() < 500).map(r -> r.getNombre()).forEach(System.out::println);*/

        /*String recetasCarnes = recetas.stream().filter(r -> r.getCategoria() == "Carnes").map(Receta::getNombre).collect(Collectors.joining(", ", "Receta(s) de Carnes: ", "."));
        System.out.println(recetasCarnes);*/
        //recetas.stream().sorted(Compar).filter(r -> r.getCategoria() == "Carnes").map(r -> r.getNombre()).forEach(System.out::println);
        System.out.println("Recetas de Carnes: ");
        recetas.stream().sorted((r1, r2) -> r1.getNombre().compareTo(r2.getNombre())).filter(r -> r.getCategoria() == "Carnes").map(r -> r.getNombre()).forEach(System.out::println);

        double mediaCaloriasVerduras = recetas.stream().filter(r -> r.getCategoria() == "Verduras").mapToInt(Receta::getCalorias).average().getAsDouble();
        System.out.println("La media de calorias en la categoria de verdura es: " + mediaCaloriasVerduras + "cal");

        long contMas800Calorias = recetas.stream().filter(r -> r.getCalorias() > 800).count();
        System.out.println("Hay " + contMas800Calorias + " receta(s) con mas de 800 calorías.");
    }
}
