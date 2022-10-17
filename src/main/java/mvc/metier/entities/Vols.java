package mvc.metier.entities;


public class Vols {
    private int id, nbr_place;
    private String date_dep, date_arr;
    private float prix;
    private int ville_dep, ville_arr;
    private String nVille_dep,nVille_arr;

    public String getnVille_dep() {
        return nVille_dep;
    }

    public void setnVille_dep(String nVille_dep) {
        this.nVille_dep = nVille_dep;
    }

    public String getnVille_arr() {
        return nVille_arr;
    }

    @Override
    public String toString() {
        return "Vols{" +
                "id=" + id +
                ", nbr_place=" + nbr_place +
                ", date_dep=" + date_dep +
                ", date_arr=" + date_arr +
                ", prix=" + prix +
                ", ville_dep=" + ville_dep +
                ", ville_arr=" + ville_arr +
                ", nVille_dep='" + nVille_dep + '\'' +
                ", nVille_arr='" + nVille_arr + '\'' +
                '}';
    }

    public void setnVille_arr(String nVille_arr) {
        this.nVille_arr = nVille_arr;
    }

    public Vols(int id, int nbr_place, String date_dep, String date_arr, float prix, String nVille_dep, String nVille_arr) {
        this.id = id;
        this.nbr_place = nbr_place;
        this.date_dep = date_dep;
        this.date_arr = date_arr;
        this.prix = prix;
        this.nVille_dep = nVille_dep;
        this.nVille_arr = nVille_arr;
    }

    public Vols() {
    }

    public Vols(int id, int nbr_place, String date_dep, String date_arr, float prix, int ville_dep, int ville_arr) {


        this.id = id;
        this.nbr_place = nbr_place;
        this.date_dep = date_dep;
        this.date_arr = date_arr;
        this.prix = prix;
        this.ville_dep = ville_dep;
        this.ville_arr = ville_arr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbr_place() {
        return nbr_place;
    }

    public void setNbr_place(int nbr_place) {
        this.nbr_place = nbr_place;
    }

    public String getDate_dep() {
        return date_dep;
    }

    public void setDate_dep(String date_dep) {
        this.date_dep = date_dep;
    }

    public String getDate_arr() {
        return date_arr;
    }

    public void setDate_arr(String date_arr) {
        this.date_arr = date_arr;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getVille_dep() {
        return ville_dep;
    }

    public void setVille_dep(int ville_dep) {
        this.ville_dep = ville_dep;
    }

    public int getVille_arr() {
        return ville_arr;
    }

    public void setVille_arr(int ville_arr) {
        this.ville_arr = ville_arr;
    }
}
