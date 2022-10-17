package mvc.model;

import mvc.metier.entities.Vols;

import java.util.ArrayList;

public class VolModel {

    private ArrayList<Vols> vols = new ArrayList<>();

    public ArrayList<Vols> getVols() {
        return vols;
    }

    public void setVols(ArrayList<Vols> vols) {
        this.vols = vols;
    }
}
