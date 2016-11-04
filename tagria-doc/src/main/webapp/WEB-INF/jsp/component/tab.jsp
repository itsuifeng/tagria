<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="tab"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a flap within a panel flaps																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table><html:tableLine><html:tableColumn header="true"><fmt:message key="tag.attribute"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.required"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.type"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.description"/></html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>label</html:tableColumn><html:tableColumn>true</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the label of the tab</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>url</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the url to be incorporated into the tab. If not indicated it renders content in the component body.</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>rendered</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates whether the tab should be rendered</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>active</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates whether the tab should be initiated selected</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>reloadOnSelect</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates whether the tab should be recharged to clicar.Default: true.</html:tableColumn></html:tableLine></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:tabPanel>
				<html:tab label="Aba 1" active="true">
					Conte�do aba 1
				</html:tab>
				<html:tab label="Aba 2" url="/app/welcome"/>
			</html:tabPanel> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>
			&lt;html:tabPanel&gt;
				&lt;html:tab label="Aba 1" active="true"&gt;
					Conte�do aba 1
				&lt;/html:tab&gt;
				&lt;html:tab label="Aba 2" url="/app/welcome"/&gt;
			&lt;/html:tabPanel&gt; </html:code>																				</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			