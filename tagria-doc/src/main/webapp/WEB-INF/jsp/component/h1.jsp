<%@include file="../app/taglibs.jsp"%>										<html:view title="TagriaLib Documenta��o">																	<html:panel>																									<html:panelHead label="h1"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renderiza um h1																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info">Essa tag n�o possui atributos</html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:h1> Cabecalho </html:h1> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>
			&lt;html:h1&gt; Cabecalho &lt;/html:h1&gt; </html:code>																				</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			