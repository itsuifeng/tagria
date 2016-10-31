package br.com.jslsolucoes.tagria.doc.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.jslsolucoes.tagria.doc.repository.PessoaRepository;

@Controller 
@Path("component")
public class ComponentController {
	
	
	private Result result;
	private PessoaRepository pessoaRepository;
	
	public ComponentController() {
		
	}

	@Inject
	public ComponentController(Result result,PessoaRepository pessoaRepository) {
		this.result = result;
		this.pessoaRepository = pessoaRepository;	
	}
	
	@Path("{component}")
	public void component(String component){
		
		if(component.equals("grid") || component.equals("gridColumn") || component.equals("treeViewNodeSelect")){
			this.result.include("pessoas",pessoaRepository.listAll());
		}
		this.result.forwardTo("/WEB-INF/jsp/component/"+component+".jsp");
	}
}
