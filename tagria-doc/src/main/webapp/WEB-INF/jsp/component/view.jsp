<%@include file="../app/taglibs.jsp"%>										<html:view title="TagriaLib Documentação">																	<html:panel>																									<html:panelHead label="view"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renderiza a view com todo cabeçalho . Essa view deve ser declarada APENAS UMA VEZ e como tag principal em toda view utilizada																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table><html:tableLine><html:tableColumn header="true">Atributo</html:tableColumn><html:tableColumn header="true">Obrigatório</html:tableColumn><html:tableColumn header="true">Tipo</html:tableColumn><html:tableColumn header="true">Descrição</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>title</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indica o title da pagina corrente</html:tableColumn></html:tableLine></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:view>
				Todos os componentes necessários
			</html:view> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>
			&lt;html:view&gt;
				Todos os componentes necessários
			&lt;/html:view&gt; </html:code>																				</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			