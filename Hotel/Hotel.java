public class Hotel {
    String nombre;
    String ciudad;
    int rating;

    public Hotel(String nombre, String ciudad, int rating) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.rating = rating;
    }

    public Hotel() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
