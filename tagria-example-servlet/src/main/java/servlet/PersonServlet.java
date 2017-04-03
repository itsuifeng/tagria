package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.PersonDao;
import model.Person;

@WebServlet(name = "person", urlPatterns = "/person/*")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PersonDao personDao;
	private static Logger logger  = LoggerFactory.getLogger(PersonServlet.class);

	public PersonServlet() {
		super();
		personDao = PersonDao.getInstance();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String[] tokens = request.getRequestURI().split("/");
			String url = tokens[tokens.length - 1];
			if ("list".equals(url)) {
				request.setAttribute("personList", personDao.list());
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/person/list.jsp");
				dispatcher.forward(request, response);
			} else if ("form".equals(url)) {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/person/form.jsp");
				dispatcher.forward(request, response);
			} else if ("delete".equals(url)) {
				personDao.delete(new Person(Long.valueOf(request.getParameter("id"))));
				response.sendRedirect(getServletContext() + "/person/list");
			} else if ("edit".equals(url)) {
				request.setAttribute("person", personDao.load(new Person(Long.valueOf(request.getParameter("id")))));
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/person/form.jsp");
				dispatcher.forward(request, response);
			}
		} catch (IOException|ServletException exception) {
			logger.error("could not execute get logic ",exception);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Long id = !StringUtils.isEmpty(request.getParameter("id")) ? new Long(request.getParameter("id")) : null;
			String name = request.getParameter("name");
			Integer age = Integer.valueOf(request.getParameter("age"));
			personDao.saveOrUpdate(new Person(id, name, age));
			response.sendRedirect(getServletContext().getContextPath() + "/person/list");
		} catch (IOException|NumberFormatException exception) {
			logger.error("Could not save person",exception);
		}
	}

}
