<%@include file="../app/taglibs.jsp"%>										<html:view title="TagriaLib Documentação">																	<html:panel>																									<html:panelHead label="treeView"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renderiza um componente em arvore																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table><html:tableLine><html:tableColumn header="true">Atributo</html:tableColumn><html:tableColumn header="true">Obrigatório</html:tableColumn><html:tableColumn header="true">Tipo</html:tableColumn><html:tableColumn header="true">Descrição</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>url</html:tableColumn><html:tableColumn>true</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indica a url que o componente deve executar</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>name</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indica o name do componente</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>data</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.util.Collection</html:tableColumn><html:tableColumn>Indica a colecao a ser iterada no componente</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>var</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indica o nome da variavel java a ser disponibilizada o objeto da iteracao</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>required</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>Indica se o preenchimento da arvoce deve ser obrigatório no formulário</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>multiple</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>Indica se o componente permite seleção multipla. Default : false.</html:tableColumn></html:tableLine></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
		
			<html:treeView url="/app/treeView">
			
			</html:treeView> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>
		
			&lt;html:treeView url="/app/treeView"&gt;
			
			&lt;/html:treeView&gt; </html:code>																				</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			