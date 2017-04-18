<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="autoCompleteOnSelect"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders an auto complete select trigger																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info" label="{tag.empty.attributes}"></html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:autoComplete name="autocomplete" url="/app/autoComplete" dataValue="id" dataText="nome">
				<html:autoCompleteOnSelect>
					// select: function( item ) {  your block is render here  }
				</html:autoCompleteOnSelect>
			</html:autoComplete>
																									</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:autoComplete name="autocomplete" url="/app/autoComplete" dataValue="id" dataText="nome"&gt;
				&lt;html:autoCompleteOnSelect&gt;
					// select: function( item ) {  your block is render here  }
				&lt;/html:autoCompleteOnSelect&gt;
			&lt;/html:autoComplete&gt;
		&lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			