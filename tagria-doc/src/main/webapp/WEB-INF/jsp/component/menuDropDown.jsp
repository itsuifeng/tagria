<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="menuDropDown"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a dropdown menu																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table><html:tableLine><html:tableColumn header="true"><fmt:message key="tag.attribute"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.required"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.type"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.description"/></html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>label</html:tableColumn><html:tableColumn>true</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>It indicates the label to be used in dropdown root</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>align</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the alignment of the button on the menu. Default: left. Options: left, right</html:tableColumn></html:tableLine></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
				<html:menuDropDown label="Menu dropdown" >
					<html:menuItem label="Item 1" url="#"/>
				</html:menuDropDown> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
				&lt;html:menuDropDown label="Menu dropdown" &gt;
					&lt;html:menuItem label="Item 1" url="#"/&gt;
				&lt;/html:menuDropDown&gt; &lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			