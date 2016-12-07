package example.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import dao.PersonDao;
import model.Person;

@Namespace(value = "/person")
public class PersonAction {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	private Person person;
	private List<Person> persons;
	private PersonDao daoPerson;

	public PersonAction() {
		daoPerson = PersonDao.getInstance();
	}

	@Action(value = "list", results = @Result(name = Action.DEFAULT_VALUE, location = "/WEB-INF/jsp/person/list.jsp"))
	public String list() {
		persons = daoPerson.list();
		return Action.DEFAULT_VALUE;
	}

	@Action(value = "form", results = @Result(name = Action.DEFAULT_VALUE, location = "/WEB-INF/jsp/person/form.jsp"))
	public String form() {
		return Action.DEFAULT_VALUE;
	}

	@Action(value = "edit", results = @Result(name = Action.DEFAULT_VALUE, location = "/WEB-INF/jsp/person/form.jsp"))
	public String edit() {
		person = daoPerson.load(person);
		return Action.DEFAULT_VALUE;
	}

	@Action(value = "saveOrUpdate", results = @Result(name = Action.DEFAULT_VALUE, type = "redirectAction", params = {
			"actionName", "list" }))
	public String saveOrUpdate() {
		daoPerson.saveOrUpdate(person);
		return Action.DEFAULT_VALUE;
	}

	@Action(value = "delete", results = @Result(name = Action.DEFAULT_VALUE, type = "redirectAction", params = {
			"actionName", "list" }))
	public String delete() {
		daoPerson.delete(person);
		return Action.DEFAULT_VALUE;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public List<Person> getPersons() {
		return persons;
	}

}