package mvc.model;

import java.sql.Time;

public class Vols {
    private int id, nbr_place;
    private Time date_dep, date_arr;
    private float prix;
    private Ville ville_dep, ville_arr;

    public Vols() {
    }

    public Vols(int id, int nbr_place, Time date_dep, Time date_arr, float prix, Ville ville_dep, Ville ville_arr) {


        this.id = id;
        this.nbr_place = nbr_place;
        this.date_dep = date_dep;
        this.date_arr = date_arr;
        this.prix = prix;
        this.ville_dep = ville_dep;
        this.ville_arr = ville_arr;
    }
}
