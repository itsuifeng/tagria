<%@include file="../app/taglibs.jsp"%>										<html:view title="TagriaLib Documenta��o">																	<html:panel>																									<html:panelHead label="row"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renderiza uma linha de subdivisao de colunas (dividida em 12 se��es combinada com a tag col)																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info">Essa tag n�o possui atributos</html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:form action="#">
				<html:formGroup forElement="field1" label="Campo 1" required="true">
					<html:row>
						<html:col size="6">
							<html:input required="true" name="field1"/>
						</html:col>
						<html:col size="6">
							<html:input name="field2"/>
						</html:col>
					</html:row>
				</html:formGroup>
			</html:form> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>
			&lt;html:form action="#"&gt;
				&lt;html:formGroup forElement="field1" label="Campo 1" required="true"&gt;
					&lt;html:row&gt;
						&lt;html:col size="6"&gt;
							&lt;html:input required="true" name="field1"/&gt;
						&lt;/html:col&gt;
						&lt;html:col size="6"&gt;
							&lt;html:input name="field2"/&gt;
						&lt;/html:col&gt;
					&lt;/html:row&gt;
				&lt;/html:formGroup&gt;
			&lt;/html:form&gt; </html:code>																				</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			