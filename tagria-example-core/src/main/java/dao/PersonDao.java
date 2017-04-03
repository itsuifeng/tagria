package dao;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import model.Person;

@ApplicationScoped
public class PersonDao {

	private static PersonDao instance;
	private List<Person> persons = new ArrayList<Person>();

	public PersonDao() {

	}

	public static PersonDao getInstance() {
		if (instance == null)
			instance = new PersonDao();
		return instance;
	}

	public List<Person> list() {
		return this.persons;
	}

	public Person load(Person person) {
		return persons.get(persons.indexOf(person));
	}

	public void saveOrUpdate(Person person) {
		if (person.getId() == null) {
			person.setId(Long.valueOf(persons.size()));
			persons.add(person);
		} else {
			Person load = load(person);
			load.setName(person.getName());
			load.setAge(person.getAge());
		}
	}

	public void delete(Person produto) {
		persons.remove(produto);
	}
	
}
