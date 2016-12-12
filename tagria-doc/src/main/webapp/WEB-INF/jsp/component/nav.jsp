<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="nav"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders a horizontal menu																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info" label="{tag.empty.attributes}"></html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:nav>
				<html:menuButton icon="cog" align="right">
					<html:menuItem label="Item 1" url="#"/>
					<html:menuSeparator/>
					<html:menuItem label="Item 2" url="#"/>
					<html:menuItem label="Item 3" url="#"/>
				</html:menuButton>
			</html:nav> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:nav&gt;
				&lt;html:menuButton icon="cog" align="right"&gt;
					&lt;html:menuItem label="Item 1" url="#"/&gt;
					&lt;html:menuSeparator/&gt;
					&lt;html:menuItem label="Item 2" url="#"/&gt;
					&lt;html:menuItem label="Item 3" url="#"/&gt;
				&lt;/html:menuButton&gt;
			&lt;/html:nav&gt; &lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			