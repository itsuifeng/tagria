<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="tableLine"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renderiza uma linha de uma tabela																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table><html:tableLine><html:tableColumn header="true"><fmt:message key="tag.attribute"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.required"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.type"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.description"/></html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>rendered</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>Indica se o componente deve ser renderizado</html:tableColumn></html:tableLine></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:table>
				<html:tableLine>
					<html:tableColumn>Coluna 1</html:tableColumn>
				</html:tableLine>
				<html:tableLine>
					<html:tableColumn>Valor 1</html:tableColumn>
				</html:tableLine>
			</html:table>
																									</html:tab>																									<html:tab label="{source}">																					<html:code>
			&lt;html:table&gt;
				&lt;html:tableLine&gt;
					&lt;html:tableColumn&gt;Coluna 1&lt;/html:tableColumn&gt;
				&lt;/html:tableLine&gt;
				&lt;html:tableLine&gt;
					&lt;html:tableColumn&gt;Valor 1&lt;/html:tableColumn&gt;
				&lt;/html:tableLine&gt;
			&lt;/html:table&gt;
		</html:code>																				</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			