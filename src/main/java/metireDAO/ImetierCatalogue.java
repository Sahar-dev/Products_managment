package metireDAO;

import java.util.List;

public interface ImetierCatalogue {
public List<Produit> produitParMC(String mc);
public void save(Produit p);
public Produit getProduit(int id);
public void updateProduit(Produit p);
public void deleteProduit(int id);

}
