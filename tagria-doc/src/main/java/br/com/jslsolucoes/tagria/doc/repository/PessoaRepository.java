package br.com.jslsolucoes.tagria.doc.repository;

import java.util.List;

import br.com.jslsolucoes.tagria.doc.model.Pessoa;

public interface PessoaRepository {
	public List<Pessoa> listAll();
	public List<Pessoa> listAll(Integer firstResult,Integer maxResult);
	public Pessoa load(Pessoa pessoa);
}
