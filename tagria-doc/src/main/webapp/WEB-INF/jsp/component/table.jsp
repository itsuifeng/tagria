<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="table"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a table																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info" label="{tag.empty.attributes}"></html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:table>
				<html:tableLine>
					<html:tableColumn>Coluna 1</html:tableColumn>
				</html:tableLine>
				<html:tableLine>
					<html:tableColumn>Valor 1</html:tableColumn>
				</html:tableLine>
			</html:table>
																									</html:tab>																									<html:tab label="{source}">																					<html:code>&ly;html:view&gt;
			&lt;html:table&gt;
				&lt;html:tableLine&gt;
					&lt;html:tableColumn&gt;Coluna 1&lt;/html:tableColumn&gt;
				&lt;/html:tableLine&gt;
				&lt;html:tableLine&gt;
					&lt;html:tableColumn&gt;Valor 1&lt;/html:tableColumn&gt;
				&lt;/html:tableLine&gt;
			&lt;/html:table&gt;
		&ly;/html:view&gt;</html:code>																				</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			