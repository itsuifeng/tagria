<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="menuItem"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a menu item																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table><html:tableLine><html:tableColumn header="true"><fmt:message key="tag.attribute"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.required"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.type"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.description"/></html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>icon</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the icon to be used in the menu icon. available list http://getbootstrap.com/components/#glyphicons</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>url</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the URL to be used</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>label</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>It indicates the label to be used</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>target</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the target browser. Default: _self. Options: _self, _parent, _blank, namedeumiframe</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>rendered</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates whether the component should be rendered</html:tableColumn></html:tableLine></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:nav>
				<html:menuButton icon="cog" align="right">
					<html:menuItem label="Item 1" url="#"/>
					<html:menuSeparator/>
					<html:menuItem label="Item 2" target="_blank" url="#"/>
					<html:menuItem icon="trash" label="Item 3" url="#"/>
				</html:menuButton>
			</html:nav> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;		
			&lt;html:nav&gt;
				&lt;html:menuButton icon="cog" align="right"&gt;
					&lt;html:menuItem label="Item 1" url="#"/&gt;
					&lt;html:menuSeparator/&gt;
					&lt;html:menuItem label="Item 2" target="_blank" url="#"/&gt;
					&lt;html:menuItem icon="trash" label="Item 3" url="#"/&gt;
				&lt;/html:menuButton&gt;
			&lt;/html:nav&gt; &lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			