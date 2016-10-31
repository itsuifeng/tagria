<%@include file="../app/taglibs.jsp"%>										<html:view title="TagriaLib Documentação">																	<html:panel>																									<html:panelHead label="cssCode"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renderiza um bloco css																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info">Essa tag não possui atributos</html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:cssCode>
			.red  {
				border :1px solid red;
			}
			</html:cssCode>
			<html:div cssClass="red">
			    Conteudo
			</html:div> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>
			&lt;html:cssCode&gt;
			.red  {
				border :1px solid red;
			}
			&lt;/html:cssCode&gt;
			&lt;html:div cssClass="red"&gt;
			    Conteudo
			&lt;/html:div&gt; </html:code>																				</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			