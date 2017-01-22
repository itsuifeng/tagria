/*******************************************************************************
 * Copyright 2016 JSL Solucoes LTDA - https://jslsolucoes.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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
	public ComponentController(Result result,PessoaRepository pessoaRepository) {
		this.result = result;
		this.pessoaRepository = pessoaRepository;	
	}
	
	@Path("{component}")
	public void component(String component){
		
		if(component.equals("pieChart")){
			PieChartData pieChartData = new PieChartData();
			pieChartData.addLabel("Label 1");
			pieChartData.addLabel("Label 2");
			PieChartDataSet pieChartDataSet = new PieChartDataSet();
			pieChartDataSet.addData(1L);
			pieChartDataSet.addData(5L);
			pieChartData.addDataSet(pieChartDataSet );
			this.result.include("pieDataSet",pieChartData);
		} else if(component.equals("barChart")){
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
			
			this.result.include("barDataSet",barChartData);
		} else if(component.equals("grid") || component.equals("gridColumn") || component.equals("treeViewNodeSelect")){
			this.result.include("pessoas",pessoaRepository.listAll());
		}
		this.result.forwardTo("/WEB-INF/jsp/component/"+component+".jsp");
	}
}
