<%@include file="../app/taglibs.jsp"%>										<html:view title="TagriaLib Documentação">																	<html:panel>																									<html:panelHead label="tabPanel"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renderiza um painel de abas																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info">Essa tag não possui atributos</html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:tabPanel>
				<html:tab label="Aba 1" active="true">
					Conteúdo aba 1
				</html:tab>
				<html:tab label="Aba 2" url="/app/welcome"/>
			</html:tabPanel> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>
			&lt;html:tabPanel&gt;
				&lt;html:tab label="Aba 1" active="true"&gt;
					Conteúdo aba 1
				&lt;/html:tab&gt;
				&lt;html:tab label="Aba 2" url="/app/welcome"/&gt;
			&lt;/html:tabPanel&gt; </html:code>																				</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			