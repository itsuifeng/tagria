<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="panelFooter"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders the footer panel																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info" label="{tag.empty.attributes}"></html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:panel>
				<html:panelHead label="Titulo"/>
				<html:panelBody>
					Outros componentes
				</html:panelBody>
				<html:panelFooter>
					Outros componentes
				</html:panelFooter>
			</html:panel>
																									</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:panel&gt;
				&lt;html:panelHead label="Titulo"/&gt;
				&lt;html:panelBody&gt;
					Outros componentes
				&lt;/html:panelBody&gt;
				&lt;html:panelFooter&gt;
					Outros componentes
				&lt;/html:panelFooter&gt;
			&lt;/html:panel&gt;
		&lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			