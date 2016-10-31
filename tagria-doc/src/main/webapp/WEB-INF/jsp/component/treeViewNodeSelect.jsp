<%@include file="../app/taglibs.jsp"%>										<html:view title="TagriaLib Documentação">																	<html:panel>																									<html:panelHead label="treeViewNodeSelect"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renderiza a selecao de nos de uma arvore																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table><html:tableLine><html:tableColumn header="true">Atributo</html:tableColumn><html:tableColumn header="true">Obrigatório</html:tableColumn><html:tableColumn header="true">Tipo</html:tableColumn><html:tableColumn header="true">Descrição</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>id</html:tableColumn><html:tableColumn>true</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indica o id do no selecionado</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>text</html:tableColumn><html:tableColumn>true</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indica o texto do no selecionado</html:tableColumn></html:tableLine></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:treeView url="/app/treeView" name="treeview" data="${ pessoas }" var="pessoa">
				<html:treeViewNodeSelect id="${ pessoa.id }" text="${ pessoa.nome }"/>
			</html:treeView> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>
			&lt;html:treeView url="/app/treeView" name="treeview" data="\${ pessoas }" var="pessoa"&gt;
				&lt;html:treeViewNodeSelect id="\${ pessoa.id }" text="\${ pessoa.nome }"/&gt;
			&lt;/html:treeView&gt; </html:code>																				</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			