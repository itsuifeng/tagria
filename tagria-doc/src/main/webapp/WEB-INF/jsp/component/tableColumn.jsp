<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="tableColumn"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renderiza uma coluna de tabela																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table><html:tableLine><html:tableColumn header="true"><fmt:message key="tag.attribute"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.required"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.type"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.description"/></html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>header</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>Indica se a coluna deve ser renderizada com um destaque</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>format</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indica um format em que o value deve ser convertido . Opções : date,timestamp,hour,currency,cep,cnpj,tel,cpf</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>colspan</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Integer</html:tableColumn><html:tableColumn>Indica o numero de colunas que essa coluna deve preencher</html:tableColumn></html:tableLine></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:table>
				<html:tableLine>
					<html:tableColumn header="true">Coluna 1</html:tableColumn>
					<html:tableColumn header="true">Coluna 2</html:tableColumn>
				</html:tableLine>
				<html:tableLine>
					<html:tableColumn>Valor 1</html:tableColumn>
					<html:tableColumn>Valor 2</html:tableColumn>
				</html:tableLine>
				<html:tableLine>
					<html:tableColumn colspan="2">Valor 3</html:tableColumn>
				</html:tableLine>
			</html:table>
																									</html:tab>																									<html:tab label="{source}">																					<html:code>
			&lt;html:table&gt;
				&lt;html:tableLine&gt;
					&lt;html:tableColumn header="true"&gt;Coluna 1&lt;/html:tableColumn&gt;
					&lt;html:tableColumn header="true"&gt;Coluna 2&lt;/html:tableColumn&gt;
				&lt;/html:tableLine&gt;
				&lt;html:tableLine&gt;
					&lt;html:tableColumn&gt;Valor 1&lt;/html:tableColumn&gt;
					&lt;html:tableColumn&gt;Valor 2&lt;/html:tableColumn&gt;
				&lt;/html:tableLine&gt;
				&lt;html:tableLine&gt;
					&lt;html:tableColumn colspan="2"&gt;Valor 3&lt;/html:tableColumn&gt;
				&lt;/html:tableLine&gt;
			&lt;/html:table&gt;
		</html:code>																				</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			