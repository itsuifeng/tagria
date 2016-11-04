<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="mask"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renderiza uma mascara em um determinado componente																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table><html:tableLine><html:tableColumn header="true"><fmt:message key="tag.attribute"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.required"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.type"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.description"/></html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>mask</html:tableColumn><html:tableColumn>true</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indica a mascara a ser utilizada</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>attachTo</html:tableColumn><html:tableColumn>true</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indica o name do componente a ser incorporado a mascara</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>reverse</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>Indica se o preenchimento deve ocorrer de tras pra frente</html:tableColumn></html:tableLine></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:input name="teste"/>
			<html:mask mask="99/99/9999" attachTo="teste"/> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>
			&lt;html:input name="teste"/&gt;
			&lt;html:mask mask="99/99/9999" attachTo="teste"/&gt; </html:code>																				</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			