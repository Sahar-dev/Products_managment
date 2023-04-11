package metireDAO;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		Traitement metier= new Traitement();
			metier.save(new Produit(0, "iphone 8 plus",2800));

		List<Produit> prods = metier.produitParMC("pc");
		for (Produit p : prods)
		System.out.println(p.getLibelle());
		}
}
