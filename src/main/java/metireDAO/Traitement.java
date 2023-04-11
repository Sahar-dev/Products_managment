package metireDAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Traitement implements ImetierCatalogue { 
	 public void save(Produit p) {
	        Connection con = Connect.getConnection();
	        try {
	        	PreparedStatement ps = con.prepareStatement(" insert into produit (id,libelle, prix)  values (?,?,?)");
	            ps.setString(2,p.getLibelle());
	            ps.setDouble(3, p.getPrix());
	            ps.setInt(1,p.getId());
	            ps.executeUpdate();
	            
	        }
	        catch (SQLException e) {
	                e.printStackTrace();
	            } 
	    }
	 public List<Produit> produitParMC(String mc){
		 	Connection con = Connect.getConnection();
	        List<Produit> lProduit=new ArrayList<Produit>();

	        try {
	            PreparedStatement stmt = con.prepareStatement("SELECT * FROM produit WHERE libelle like  '%"+ mc +"%' ");
	            final ResultSet rs = stmt.executeQuery();
	            	while (rs.next()) {
	            		Produit produit=new Produit(rs.getInt("id"),rs.getString("libelle"),rs.getDouble("prix"));
		                 lProduit.add(produit);
		            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
	        return lProduit;
	 }
	 public ArrayList<Produit> getAll(){
		 	Connection con = Connect.getConnection();
		 	ArrayList<Produit> lProduit=new ArrayList<Produit>();

	        try {
	            PreparedStatement stmt = con.prepareStatement("SELECT * FROM produit ");
	            final ResultSet rs = stmt.executeQuery();
	            	while (rs.next()) {
	            		Produit produit=new Produit(rs.getInt("id"),rs.getString("libelle"),rs.getDouble("prix"));
		                 lProduit.add(produit);
		            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
	        return lProduit;
	 }
	 public Produit getProduit(int id) {
		 Connection con = Connect.getConnection();
	        Produit produit=null;
	        try {
	        	PreparedStatement  stmt = con.prepareStatement("SELECT * FROM produit WHERE id = ? ");
	            stmt.setInt(1, id);

	            final ResultSet rs = stmt.executeQuery();
	            	while (rs.next()) {
	            		produit=new Produit(rs.getInt("id"),rs.getString("libelle"),rs.getDouble("prix"));
		            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return produit;
	    }

	 
	 public void updateProduit(Produit p) {
	        Connection con = Connect.getConnection();
	        try {
	        	PreparedStatement ps = con.prepareStatement("update produit set libelle= ? , prix= ?   where id=?");
	            ps.setString(1, p.getLibelle());
	            ps.setDouble(2, p.getPrix());
	            ps.setInt(3, p.getId());
	            ps.executeUpdate();
	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        } 
	    }
	 
	 public void deleteProduit(int id) {
	        Connection con = Connect.getConnection();
	        
	        try {
	            PreparedStatement  ps = con.prepareStatement(" delete from produit  where id=? ");
	            ps.setInt(1, id);
	            ps.executeUpdate();
	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        } 
	    }

}


