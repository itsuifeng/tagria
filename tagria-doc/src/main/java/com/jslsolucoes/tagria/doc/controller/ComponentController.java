
package com.jslsolucoes.tagria.doc.controller;

import javax.inject.Inject;

import com.jslsolucoes.tagria.doc.repository.PessoaRepository;
import com.jslsolucoes.tagria.lib.chart.BarChartData;
import com.jslsolucoes.tagria.lib.chart.BarChartDataSet;
import com.jslsolucoes.tagria.lib.chart.PieChartData;
import com.jslsolucoes.tagria.lib.chart.PieChartDataSet;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
@Path("component")
public class ComponentController {

	private Result result;
	private PessoaRepository pessoaRepository;

	public ComponentController() {

	}

	@Inject
	public ComponentController(Result result, PessoaRepository pessoaRepository) {
		this.result = result;
		this.pessoaRepository = pessoaRepository;
	}

	@Path("{component}")
	public void component(String component) {

		if ("pieChart".equals(component)) {
			PieChartData pieChartData = new PieChartData();
			pieChartData.addLabel("Label 1");
			pieChartData.addLabel("Label 2");
			PieChartDataSet pieChartDataSet = new PieChartDataSet();
			pieChartDataSet.addData(1L);
			pieChartDataSet.addData(5L);
			pieChartData.addDataSet(pieChartDataSet);
			this.result.include("pieDataSet", pieChartData);
		} else if ("barChart".equals(component)) {
			BarChartData barChartData = new BarChartData();
			barChartData.addLabel("Label 1");
			barChartData.addLabel("Label 2");
			BarChartDataSet barChartDataSet = new BarChartDataSet();
			barChartDataSet.setLabel("Series 1");
			barChartDataSet.addData(1L);
			barChartDataSet.addData(5L);
			barChartData.addDataSet(barChartDataSet);

			BarChartDataSet barChartDataSet2 = new BarChartDataSet();
			barChartDataSet2.setLabel("Series 2");
			barChartDataSet2.addData(3L);
			barChartDataSet2.addData(10L);
			barChartData.addDataSet(barChartDataSet2);

			this.result.include("barDataSet", barChartData);
		} else if ("grid".equals(component) || "gridColumn".equals(component)
				|| "treeViewNodeSelect".equals(component)) {
			this.result.include("pessoas", pessoaRepository.listAll());
		}
		this.result.forwardTo("/WEB-INF/jsp/component/" + component + ".jsp");
	}
}
