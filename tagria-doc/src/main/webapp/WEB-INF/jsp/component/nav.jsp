<%@include file="../app/taglibs.jsp"%>										<html:view title="TagriaLib Documenta��o">																	<html:panel>																									<html:panelHead label="nav"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renderiza um menu horizontal																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info">Essa tag n�o possui atributos</html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:nav>
				<html:menuButton icon="cog" align="right">
					<html:menuItem label="Item 1" url="#"/>
					<html:menuSeparator/>
					<html:menuItem label="Item 2" url="#"/>
					<html:menuItem label="Item 3" url="#"/>
				</html:menuButton>
			</html:nav> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>
			&lt;html:nav&gt;
				&lt;html:menuButton icon="cog" align="right"&gt;
					&lt;html:menuItem label="Item 1" url="#"/&gt;
					&lt;html:menuSeparator/&gt;
					&lt;html:menuItem label="Item 2" url="#"/&gt;
					&lt;html:menuItem label="Item 3" url="#"/&gt;
				&lt;/html:menuButton&gt;
			&lt;/html:nav&gt; </html:code>																				</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			