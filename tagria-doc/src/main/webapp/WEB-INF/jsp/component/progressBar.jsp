<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="progressBar"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a progress bar																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table><html:tableLine><html:tableColumn header="true"><fmt:message key="tag.attribute"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.required"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.type"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.description"/></html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>determinate</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates whether the bar should have a certain position. default false</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>value</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Integer</html:tableColumn><html:tableColumn>It indicates the value that the bar should take a percentage. Default 0.Op��es: 0 to 100</html:tableColumn></html:tableLine></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:progressBar determinate="true" value="70"></html:progressBar> 
			<html:progressBar determinate="true" value="30"></html:progressBar> 
			<html:progressBar></html:progressBar> 
																									</html:tab>																									<html:tab label="{source}">																					<html:code>&ly;html:view&gt;
			&lt;html:progressBar determinate="true" value="70"&gt;&lt;/html:progressBar&gt; 
			&lt;html:progressBar determinate="true" value="30"&gt;&lt;/html:progressBar&gt; 
			&lt;html:progressBar&gt;&lt;/html:progressBar&gt; 
		&ly;/html:view&gt;</html:code>																				</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			