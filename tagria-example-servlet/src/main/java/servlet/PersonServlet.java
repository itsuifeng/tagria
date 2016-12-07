package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import dao.PersonDao;
import model.Person;

@WebServlet(name="person",urlPatterns="/person/*")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonDao personDao;

	public PersonServlet() {
		super();
		personDao = PersonDao.getInstance();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String[] tokens = request.getRequestURI().split("/");
		String url = tokens[tokens.length - 1];
		if (url.equals("list")) {
			request.setAttribute("personList", personDao.list());
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/WEB-INF/jsp/person/list.jsp");
			dispatcher.forward(request, response);
		} else if (url.equals("form")) {
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/WEB-INF/jsp/person/form.jsp");
			dispatcher.forward(request, response);
		} else if (url.equals("delete")) {
			personDao.delete(new Person(Long.valueOf(request.getParameter("id"))));
			response.sendRedirect(getServletContext() + "/person/list");
		} else if (url.equals("edit")) {
			request.setAttribute("person",
					personDao.load(new Person(Long.valueOf(request.getParameter("id")))));
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/WEB-INF/jsp/person/form.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Long id = (!StringUtils.isEmpty(request.getParameter("id")) ? new Long(
				request.getParameter("id")) : null);
		String name = request.getParameter("name");
		Integer age = Integer.valueOf(request.getParameter("age"));
		personDao.saveOrUpdate(new Person(id, name, age));
		response.sendRedirect(getServletContext().getContextPath()
				+ "/person/list");
	}

}
