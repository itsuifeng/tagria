package example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.PersonDao;
import model.Person;

@Controller
@RequestMapping("/person")
public class PersonController {

	private PersonDao daoPerson;

	public PersonController() {
		daoPerson = PersonDao.getInstance();
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		return new ModelAndView("/person/list", "personList",
				this.daoPerson.list());
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form() {
		return "person/form";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable Long id) {
		return new ModelAndView("/person/form", "person",
				this.daoPerson.load(new Person(id)));
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deactive(@PathVariable Long id) {
		this.daoPerson.delete(new Person(id));
		return "redirect:/person/list";
	}

	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public String saveOrUpdate(Person person) {
		this.daoPerson.saveOrUpdate(person);
		return "redirect:/person/list";
	}
}
