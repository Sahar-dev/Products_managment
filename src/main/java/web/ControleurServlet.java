package web;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metireDAO.ImetierCatalogue;
import metireDAO.Traitement;
import metireDAO.Produit;

@WebServlet(name="cs",urlPatterns={"/controleur","*.do"}) 
public class ControleurServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
private ImetierCatalogue metier;
@Override
public void init() throws ServletException {
metier=new Traitement();
}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	
	request.getRequestDispatcher("ProduitsView.jsp").forward(request, response);
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
	String path= request.getServletPath();
	if (path.equals("chercher.do")) {
	String mc=request.getParameter("motCle");
	ProduitModele mod = new ProduitModele();
	mod.setMotCle(mc);
	List<Produit> prods = metier.produitParMC(mc);
	mod.setProduits(prods);
	request.setAttribute("modele", mod);
	request.getRequestDispatcher("ProduitsView.jsp").forward(request,response);
	}
else {
	String id=request.getParameter("id");
	String nom=request.getParameter("nom");
	String prix=request.getParameter("prix");
	ProduitModele mod = new ProduitModele();
	double p = Double.valueOf(prix);
	Produit prod= new Produit (Integer.valueOf(id), nom,p);
	metier.save(prod);
	request.setAttribute("produit", prod);
	request.getRequestDispatcher("confirmation.jsp").forward(request,response);
}
	}
	}
