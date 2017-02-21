package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(name = "app", urlPatterns = "/app/*")
public class AppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger  = LoggerFactory.getLogger(AppServlet.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/app/welcome.jsp");
			dispatcher.forward(request, response);
		} catch (IOException | ServletException exception) {
			logger.error("could not execute get logic ", exception);
		}
	}

}
