<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="form"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a form																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table><html:tableLine><html:tableColumn header="true"><fmt:message key="tag.attribute"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.required"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.type"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.description"/></html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>action</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the action of submission</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>method</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>It indicates the method to be used. Default: post. Options: post, get</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>name</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the name of form</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>validation</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>It indicates a validation to be performed on the data form</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>label</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indicates the label of the form</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>rendered</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates whether the component should be rendered</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>multipart</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>It indicates whether the form should have file support</html:tableColumn></html:tableLine></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
		
			<html:form action="#">
				<html:formGroup label="Campo 1" required="true">
					<html:input required="true" name="field1"/>
				</html:formGroup>
				<html:formGroup label="Campo 2">
					<html:input name="field2"/>
				</html:formGroup>
			</html:form> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>
		
			&lt;html:form action="#"&gt;
				&lt;html:formGroup label="Campo 1" required="true"&gt;
					&lt;html:input required="true" name="field1"/&gt;
				&lt;/html:formGroup&gt;
				&lt;html:formGroup label="Campo 2"&gt;
					&lt;html:input name="field2"/&gt;
				&lt;/html:formGroup&gt;
			&lt;/html:form&gt; </html:code>																				</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			