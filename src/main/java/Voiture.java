public class Voiture {

    private String marque;
    private double prix;

    public Voiture(String marque, double prix){
        this.marque = marque;
        this.prix = prix;
    }

    public double getPrix() {
        return prix;
    }

    public String getMarque() {
        return marque;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    @Override
    public String toString() {
        return "Voiture: " + this.getMarque() + " | Prix: " + this.getPrix();
    }
}
