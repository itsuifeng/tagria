<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="grid"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a grid																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table><html:tableLine><html:tableColumn header="true"><fmt:message key="tag.attribute"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.required"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.type"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.description"/></html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>data</html:tableColumn><html:tableColumn>true</html:tableColumn><html:tableColumn>java.util.Collection</html:tableColumn><html:tableColumn>It indicates the collection to be iterated by the component</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>var</html:tableColumn><html:tableColumn>true</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>It indicates the name of the variable java to be made available the object of iteration</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>varStatus</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>It indicates the name of the variable to be available to current iteration</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>label</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the label component</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>totalResults</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Integer</html:tableColumn><html:tableColumn>Indicates the total number of records in component</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>resultsPerPage</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Integer</html:tableColumn><html:tableColumn>It indicates the default number of results per page. Default: 60. Options: 20,40,60,80,100</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>simple</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates whether the grid is simple without standard widgets (pagination, exportacao, search, etc.). Default: false</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>search</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates whether the component should be search feature. Default: false</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>paginate</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates whether the component should be paginated. Default: true</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>export</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates whether the component should be export feature. Default: true</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>url</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the url component a ser utilizada caso haja pagina��o</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>rendered</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates whether the component should be rendered</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>noRowText</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the component title when there are no lines available</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>checkAll</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>Indicates whether the support is activated mark all</html:tableColumn></html:tableLine></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:grid label="Pessoas" url="/component/grid" data="${ pessoas }" var="pessoa" noRowText="N�o h� pessoas dispon�veis">
				<html:gridColumn label="Identifica��o" exportable="true">
					${ pessoa.id }
				</html:gridColumn>
				<html:gridColumn label="Nome" exportable="true">
					${ pessoa.nome }
				</html:gridColumn>
			</html:grid> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>&ly;html:view&gt;
			&lt;html:grid label="Pessoas" url="/component/grid" data="\${ pessoas }" var="pessoa" noRowText="N�o h� pessoas dispon�veis"&gt;
				&lt;html:gridColumn label="Identifica��o" exportable="true"&gt;
					\${ pessoa.id }
				&lt;/html:gridColumn&gt;
				&lt;html:gridColumn label="Nome" exportable="true"&gt;
					\${ pessoa.nome }
				&lt;/html:gridColumn&gt;
			&lt;/html:grid&gt; &ly;/html:view&gt;</html:code>																				</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			