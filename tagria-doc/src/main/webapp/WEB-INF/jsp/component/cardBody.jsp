<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="cardBody"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a body in the card																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info" label="{tag.empty.attributes}"></html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:card>
				<html:cardBody>
					Componentes
				</html:cardBody>
				 <html:toolbar>
					Componentes
				</html:toolbar>
			</html:card> 
																									</html:tab>																									<html:tab label="{source}">																					<html:code>&ly;html:view&gt;
			&lt;html:card&gt;
				&lt;html:cardBody&gt;
					Componentes
				&lt;/html:cardBody&gt;
				 &lt;html:toolbar&gt;
					Componentes
				&lt;/html:toolbar&gt;
			&lt;/html:card&gt; 
		&ly;/html:view&gt;</html:code>																				</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			