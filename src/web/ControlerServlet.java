package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CreditMetierImpl;
import metier.ICreditMetier;

@WebServlet(name = "cs", urlPatterns = { "/controleur", "*.do" })
public class ControlerServlet extends HttpServlet {
	/*
	 * on déclare l'objet metier ici pour ne pas avoir à le faire à chaque fois
	 * qu'on appelle doPost
	 */
	private ICreditMetier metier;

	@Override
	public void init() throws ServletException {
		/* On instancie la couche metier */
		metier = new CreditMetierImpl();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("VueCredit.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * Lire les données de la requête
		 */
		double montant = Double.parseDouble(request.getParameter("montant"));
		double taux = Double.parseDouble(request.getParameter("taux"));
		int duree = Integer.parseInt(request.getParameter("duree"));

		/*
		 * Valider les données
		 */

		/*
		 * Stocker les données saisies dans le model
		 */

		CreditModel model = new CreditModel();
		model.setMontant(montant);
		model.setTaux(taux);
		model.setDuree(duree);

		/*
		 * Faire appel à la couche metier pour effectuer les traitements
		 */

		double res = metier.calculerMensualiteCredit(montant, taux, duree);

		/*
		 * Stocker les résultats dans le model
		 */
		model.setMensualite(res);

		/*
		 * Stocker le model dans l'objet request
		 */

		request.setAttribute("creditModel", model);

		/*
		 * Faire un forward vers la vue JSP (on transmet à la vue l'objet request et
		 * l'objet response)
		 */
		request.getRequestDispatcher("VueCredit.jsp").forward(request, response);

	}

}
