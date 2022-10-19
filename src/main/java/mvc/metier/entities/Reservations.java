package mvc.metier.entities;

public class Reservations {
    private int id, vol_id, user_id;

    public String getDateVoyage() {
        return dateVoyage;
    }

    public void setDateVoyage(String dateVoyage) {
        this.dateVoyage = dateVoyage;
    }

    private String dateVoyage;

    public Reservations(int id, int vol_id, int user_id) {
        this.id = id;
        this.vol_id = vol_id;
        this.user_id = user_id;
    }
    public Reservations(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVol_id() {
        return vol_id;
    }

    public void setVol_id(int vol_id) {
        this.vol_id = vol_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
