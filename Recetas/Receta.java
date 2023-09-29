public class Receta {
    String nombre;
    String categoria;
    int calorias;

    public Receta(String nombre, String categoria, int calorias) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.calorias = calorias;
    }

    public Receta() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }
}
