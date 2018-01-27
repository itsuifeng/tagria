
package com.jslsolucoes.tagria.doc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang.RandomStringUtils;
import org.joda.time.DateTime;

import com.jslsolucoes.tagria.doc.model.Pessoa;
import com.jslsolucoes.tagria.doc.repository.PessoaRepository;
import com.jslsolucoes.tagria.lib.calendar.CalendarEvent;
import com.jslsolucoes.tagria.lib.tree.view.TreeViewNode;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Controller
public class AppController {

	private Result result;
	private PessoaRepository pessoaRepository;

	public AppController() {

	}

	@Inject
	public AppController(Result result, PessoaRepository pessoaRepository) {
		this.result = result;
		this.pessoaRepository = pessoaRepository;
	}

	@Path("/")
	public void index() {

	}

	@Path("/app/welcome")
	public void welcome() {

	}

	@Path("/app/calendar")
	public void calendar() {

		List<CalendarEvent> events = new ArrayList<CalendarEvent>();
		CalendarEvent event1 = new CalendarEvent();
		event1.setBeginIn(new Date());
		event1.setTitle("Titulo 1");
		event1.setDescription("Evento com dia todo");
		event1.setAllDay(true);
		events.add(event1);

		CalendarEvent event2 = new CalendarEvent();
		event2.setBeginIn(new Date());
		event2.setEndAt(new DateTime().plusDays(2).toDate());
		event2.setTitle("Titulo 2");
		event2.setDescription("Evento com periodo");
		events.add(event2);

		this.result.use(Results.json()).withoutRoot().from(events).serialize();

	}

	@Path("/app/ajax")
	public void ajax(String input1) {
		this.result.use(Results.json()).from(input1, "field").serialize();
	}

	@Path("/app/ajax/list")
	public void ajaxList() {
		this.result.use(Results.json()).from(pessoaRepository.listAll()).serialize();
	}

	@Path("/app/autoComplete")
	public void autoComplete() {
		this.result.use(Results.json()).from(pessoaRepository.listAll()).serialize();
	}

	@Path("/app/treeView")
	public void treeView(String id) {
		List<TreeViewNode> nodes = new ArrayList<TreeViewNode>();
		for (Pessoa pessoa : pessoaRepository.listAll()) {
			TreeViewNode node = new TreeViewNode();
			node.setText(pessoa.getNome());
			node.setId(RandomStringUtils.randomAlphanumeric(15));
			if (pessoa.getId() % 2 == 0)
				node.setChildren(true);
			nodes.add(node);
		}
		this.result.use(Results.json()).withoutRoot().from(nodes).serialize();
	}

}
