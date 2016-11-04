<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="code"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renderiza um bloco de código fonte de uma determinada linguagem sem executá-la																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info" label="{tag.empty.attributes}"></html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:code>
				private class Java {
					private String id;
					private String name;
				}
			</html:code> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>
			&lt;html:code&gt;
				private class Java {
					private String id;
					private String name;
				}
			&lt;/html:code&gt; </html:code>																				</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			