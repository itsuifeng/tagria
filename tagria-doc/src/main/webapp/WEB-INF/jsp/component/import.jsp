<%@include file="../app/taglibs.jsp"%>										<html:view title="TagriaLib Documenta��o">																	<html:panel>																									<html:panelHead label="import"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renderiza a importacao de um arquivo js ou css																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table><html:tableLine><html:tableColumn header="true">Atributo</html:tableColumn><html:tableColumn header="true">Obrigat�rio</html:tableColumn><html:tableColumn header="true">Tipo</html:tableColumn><html:tableColumn header="true">Descri��o</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>type</html:tableColumn><html:tableColumn>true</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indica o tipo do arquivo a ser importado. Op��es : js,css</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>url</html:tableColumn><html:tableColumn>true</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indica a url onde se encontra o arquivo</html:tableColumn></html:tableLine></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:import type="css" url="/css/example.css"/>
			<html:import type="js" url="/js/example.js"/> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>
			&lt;html:import type="css" url="/css/example.css"/&gt;
			&lt;html:import type="js" url="/js/example.js"/&gt; </html:code>																				</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			