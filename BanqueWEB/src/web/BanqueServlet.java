package web;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.Compte;
import metier.session.IBanqueLocal;

@WebServlet(name = "cs", urlPatterns = { "*.do" })
public class BanqueServlet extends HttpServlet {
	@EJB
	private IBanqueLocal metier;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null)
			if (action.equals("del")) {
				Long code = Long.parseLong(req.getParameter("code"));
				metier.supprimerCompte(code);
			}
		req.setAttribute("comptes", metier.getAllComptes());
		req.getRequestDispatcher("Banque.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action.equals("Verser")) {
			Long code = Long.parseLong(req.getParameter("code1"));
			double montant = Double.parseDouble(req.getParameter("montant"));
			metier.verser(montant, code);
		}

		else if (action.equals("Retirer")) {
			Long code = Long.parseLong(req.getParameter("code1"));
			double montant = Double.parseDouble(req.getParameter("montant"));
			metier.retirer(montant, code);
		}

		else if (action.equals("Virement")) {
			Long code1 = Long.parseLong(req.getParameter("code1"));
			Long code2 = Long.parseLong(req.getParameter("code2"));
			double montant = Double.parseDouble(req.getParameter("montant"));
			metier.virement(montant, code1, code2);
		} else if (action.equals("Ajouter")) {
			metier.addCompte(new Compte(0, new Date(), true));
		}
		req.setAttribute("comptes", metier.getAllComptes());
		req.getRequestDispatcher("Banque.jsp").forward(req, resp);
	}

}
