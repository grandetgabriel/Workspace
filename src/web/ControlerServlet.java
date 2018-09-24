package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "cs", urlPatterns = { "/controleur", "*.php" })
public class ControlerServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("VueCredit.jsp").forward(request, response);

	}

}
