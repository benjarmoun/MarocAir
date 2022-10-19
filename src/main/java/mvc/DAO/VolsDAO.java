package mvc.DAO;

import mvc.DAO.repository.DAO;
import mvc.metier.entities.Vols;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static mvc.helpers.Connexion.getConnection;


public class VolsDAO implements DAO<Vols> {

    public VolsDAO() throws SQLException, ClassNotFoundException {

    }

    public boolean addVol(Vols vol) {
        return false;
    }

    @Override
    public Vols get(int id) throws SQLException, ClassNotFoundException {
        Vols vols=null;
        PreparedStatement stm = getConnection().prepareStatement("SELECT v.id, vd.nom ville_depart, va.nom ville_arriver, date_dep, date_arr, prix, nbr_place from vol v join villes vd on v.id_depart = vd.id join villes va on va.id = v.id_arrive where v.id= ?");
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            vols=new Vols(rs.getInt("id"), rs.getInt("nbr_place"), rs.getString("date_dep"), rs.getString("date_arr"), rs.getFloat("prix"), rs.getString("ville_depart"), rs.getString("ville_arriver"));
        }
        return vols;


    }

    @Override
    public List<Vols> getAll() throws SQLException, ClassNotFoundException {
        List<Vols> vols = new ArrayList<>();
        PreparedStatement stm = getConnection().prepareStatement("SELECT v.id, vd.nom ville_depart, va.nom ville_arriver, date_dep, date_arr, prix, nbr_place from vol v join villes vd on v.id_depart = vd.id join villes va on va.id = v.id_arrive");
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            vols.add(new Vols(rs.getInt("id"), rs.getInt("nbr_place"), rs.getString("date_dep"), rs.getString("date_arr"), rs.getFloat("prix"), rs.getString("ville_depart"), rs.getString("ville_arriver")));
        }
        return vols;
    }

    @Override
    public boolean save(Vols vols) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = getConnection().prepareStatement("INSERT INTO marocair.vol (date_dep, date_arr, nbr_place, prix, id_depart, id_arrive)VALUES (?, ?, ?, ?, ?, ?)");
        stm.setString(1, vols.getDate_dep());
        stm.setString(2, vols.getDate_arr());
        stm.setInt(3, vols.getNbr_place());
        stm.setFloat(4, vols.getPrix());
        stm.setInt(5, vols.getVille_dep());
        stm.setInt(6, vols.getVille_arr());
        return stm.executeUpdate() != 0;
    }

    @Override
    public void update(Vols vols, int i) {

    }

    @Override
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = getConnection().prepareStatement("DELETE FROM marocair.vol WHERE id = ?");
        stm.setInt(1, id);
        return stm.executeUpdate() != 0;
    }

    public List<Vols> getAll(int depart, int retour) throws SQLException, ClassNotFoundException {
        List<Vols> vols = new ArrayList<>();
        PreparedStatement stm = getConnection().prepareStatement("SELECT v.id, vd.nom ville_depart, va.nom ville_arriver, date_dep, date_arr, prix, nbr_place from vol v join villes vd on v.id_depart = vd.id join villes va on va.id = v.id_arrive where (vd.id = ? and va.id =  ?)");
        stm.setInt(1, depart);
        stm.setInt(2, retour);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            vols.add(new Vols(rs.getInt("id"), rs.getInt("nbr_place"), rs.getString("date_dep"), rs.getString("date_arr"), rs.getFloat("prix"), rs.getString("ville_depart"), rs.getString("ville_arriver")));
        }
        return vols;
    }
}
