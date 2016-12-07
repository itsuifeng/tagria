package action;

import org.mentawai.core.BaseAction;

import dao.PersonDao;
import model.Person;

public class PersonAction extends BaseAction {

	private PersonDao personDao;

	public PersonAction(PersonDao personDao) {
		this.personDao = personDao;
	}

	public void list() {
		output.setValue("personList", personDao.list());
	}

	public void form() {

	}

	public void edit() {
		output.setValue("person", personDao.load(input.getObject(Person.class)));
	}

	public void saveOrUpdate() {
		personDao.saveOrUpdate(input.getObject(Person.class));
	}

	public void delete() {
		personDao.delete(input.getObject(Person.class));
	}
}
