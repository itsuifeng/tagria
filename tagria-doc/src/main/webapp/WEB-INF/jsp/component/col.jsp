<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="col"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a column within a row																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table><html:tableLine><html:tableColumn header="true"><fmt:message key="tag.attribute"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.required"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.type"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.description"/></html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>size</html:tableColumn><html:tableColumn>true</html:tableColumn><html:tableColumn>java.lang.Integer</html:tableColumn><html:tableColumn>Indicates the number of columns to fill. Options: 1 to 12</html:tableColumn></html:tableLine></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:form action="#">
				<html:formGroup forElement="field1" label="Campo 1" required="true">
					<html:row>
						<html:col size="3">
							<html:input required="true" name="field1"/>
						</html:col>
						<html:col size="9">
							<html:input name="field2"/>
						</html:col>
					</html:row>
				</html:formGroup>
			</html:form> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>&ly;html:view&gt;
			&lt;html:form action="#"&gt;
				&lt;html:formGroup forElement="field1" label="Campo 1" required="true"&gt;
					&lt;html:row&gt;
						&lt;html:col size="3"&gt;
							&lt;html:input required="true" name="field1"/&gt;
						&lt;/html:col&gt;
						&lt;html:col size="9"&gt;
							&lt;html:input name="field2"/&gt;
						&lt;/html:col&gt;
					&lt;/html:row&gt;
				&lt;/html:formGroup&gt;
			&lt;/html:form&gt; &ly;/html:view&gt;</html:code>																				</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			