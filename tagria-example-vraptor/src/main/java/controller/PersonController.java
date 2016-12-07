package controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import dao.PersonDao;
import model.Person;

@Controller
@Path("person")
public class PersonController {
	private Result result;
	private PersonDao daoPerson;
	
	
	public PersonController() {
		
	}
	
	@Inject
	public PersonController(Result result,PersonDao daoPerson) {
		this.result = result;
		this.daoPerson = daoPerson;
	}
	
	public void list(){
		this.result.include("personList",this.daoPerson.list());
	}
	
	public void form(){
		
	}
	
	@Path("edit/{id}")
	public void edit(Long id){
		this.result.include("person",this.daoPerson.load(new Person(id)));
		this.result.of(this).form();
	}
	
	@Post
	public void saveOrUpdate(Long id,String name,Integer age){
		this.daoPerson.saveOrUpdate(new Person(id, name, age));
		this.result.redirectTo(this).list();
	}
	
	@Path("delete/{id}")
	public void delete(Long id){
		this.daoPerson.delete(new Person(id));
		this.result.redirectTo(this).list();
	}
	
}
