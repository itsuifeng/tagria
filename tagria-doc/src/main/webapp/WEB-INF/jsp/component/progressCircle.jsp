<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="progressCircle"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a progress bar circular																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table><html:tableLine><html:tableColumn header="true"><fmt:message key="tag.attribute"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.required"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.type"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.description"/></html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>color</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the circular progress color. Default blue. Options: red, green, yellow, blue</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>size</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Integer</html:tableColumn><html:tableColumn>Indicates the circular progress size. Default big. Options: big, small, medium</html:tableColumn></html:tableLine></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:progressCircle></html:progressCircle> 
			<html:progressCircle color="red" size="small"></html:progressCircle> 
			<html:progressCircle color="yellow" size="medium"></html:progressCircle> 
																									</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:progressCircle&gt;&lt;/html:progressCircle&gt; 
			&lt;html:progressCircle color="red" size="small"&gt;&lt;/html:progressCircle&gt; 
			&lt;html:progressCircle color="yellow" size="medium"&gt;&lt;/html:progressCircle&gt; 
		&lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			