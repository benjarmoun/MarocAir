package mvc.model;

import mvc.metier.entities.Ville;

import java.util.ArrayList;

public class VilleModel {
    private ArrayList<Ville> villes = new ArrayList<>();

    public ArrayList<Ville> getVilles() {
        return villes;
    }

    public void setVilles(ArrayList<Ville> villes) {
        this.villes = villes;
    }
}
