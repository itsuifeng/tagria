<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="import"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders importing a js file or css																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table><html:tableLine><html:tableColumn header="true"><fmt:message key="tag.attribute"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.required"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.type"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.description"/></html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>type</html:tableColumn><html:tableColumn>true</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the type of file to be imported. Options: js, css</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>url</html:tableColumn><html:tableColumn>true</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the URL where the file</html:tableColumn></html:tableLine></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:import type="css" url="/css/example.css"/>
			<html:import type="js" url="/js/example.js"/> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>&ly;html:view&gt;
			&lt;html:import type="css" url="/css/example.css"/&gt;
			&lt;html:import type="js" url="/js/example.js"/&gt; &ly;/html:view&gt;</html:code>																				</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			