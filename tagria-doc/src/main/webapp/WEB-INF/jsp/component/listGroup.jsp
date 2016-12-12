<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="listGroup"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a list																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info" label="{tag.empty.attributes}"></html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:listGroup>
				<html:listGroupItem>
					Item 1
				</html:listGroupItem>
				<html:listGroupItem>
					Item 2
				</html:listGroupItem>
			</html:listGroup> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:listGroup&gt;
				&lt;html:listGroupItem&gt;
					Item 1
				&lt;/html:listGroupItem&gt;
				&lt;html:listGroupItem&gt;
					Item 2
				&lt;/html:listGroupItem&gt;
			&lt;/html:listGroup&gt; &lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			