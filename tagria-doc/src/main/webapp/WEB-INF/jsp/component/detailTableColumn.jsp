<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="detailTableColumn"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renderiza uma coluna na tabela detalhe																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table><html:tableLine><html:tableColumn header="true"><fmt:message key="tag.attribute"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.required"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.type"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.description"/></html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>label</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indica o label do componente</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>required</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>Indica se o componente tem seu preenchimento obrigatório em um formulário</html:tableColumn></html:tableLine></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:form action="#" label="Formulario com detalhes">
				<html:formGroup>
					<html:detailTable atLeast="1">
						<html:detailTableColumn label="Nome" required="true">
							<html:input name="nomes[]" required="true"/>
						</html:detailTableColumn>
						<html:detailTableColumn label="Idade" required="true">
							<html:input name="idades[]" type="number" required="true"/>
						</html:detailTableColumn>
					</html:detailTable>
				</html:formGroup>
			</html:form>
																									</html:tab>																									<html:tab label="{source}">																					<html:code>
			&lt;html:form action="#" label="Formulario com detalhes"&gt;
				&lt;html:formGroup&gt;
					&lt;html:detailTable atLeast="1"&gt;
						&lt;html:detailTableColumn label="Nome" required="true"&gt;
							&lt;html:input name="nomes[]" required="true"/&gt;
						&lt;/html:detailTableColumn&gt;
						&lt;html:detailTableColumn label="Idade" required="true"&gt;
							&lt;html:input name="idades[]" type="number" required="true"/&gt;
						&lt;/html:detailTableColumn&gt;
					&lt;/html:detailTable&gt;
				&lt;/html:formGroup&gt;
			&lt;/html:form&gt;
		</html:code>																				</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			