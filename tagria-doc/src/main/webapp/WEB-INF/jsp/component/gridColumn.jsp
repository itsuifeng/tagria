<%@include file="../app/taglibs.jsp"%>										<html:view title="TagriaLib Documenta��o">																	<html:panel>																									<html:panelHead label="gridColumn"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renderiza uma coluna de grid																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table><html:tableLine><html:tableColumn header="true">Atributo</html:tableColumn><html:tableColumn header="true">Obrigat�rio</html:tableColumn><html:tableColumn header="true">Tipo</html:tableColumn><html:tableColumn header="true">Descri��o</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>label</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.util.Collection</html:tableColumn><html:tableColumn>Indica o label do componente</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>booleanType</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>Indica se o valor do componente � do tipo booleano</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>collapsable</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>Indica se a coluna deve ser collapsable</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>exportable</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>Indica se a coluna deve ser exportada</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>align</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indica o alinhamento do conteudo. Default : left. Op��es : left,center,right</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>hideOnViewport</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn></html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>format</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indica um formato em que o conteudo deve ser convertido . Op��es : date,timestamp,hour,currency,cep,cnpj,tel,cpf</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>rendered</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>Indica se o componente deve ser renderizado</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>state</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indica o estado do componente . Default : default. Op��es : danger,info,success,default</html:tableColumn></html:tableLine></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:grid label="Pessoas" url="/component/grid" data="${ pessoas }" var="pessoa" noRowText="N�o h� pessoas dispon�veis">
				<html:gridColumn label="Identifica��o" exportable="true">
					${ pessoa.id }
				</html:gridColumn>
				<html:gridColumn label="Nome" exportable="true">
					${ pessoa.nome }
				</html:gridColumn>
			</html:grid> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>
			&lt;html:grid label="Pessoas" url="/component/grid" data="\${ pessoas }" var="pessoa" noRowText="N�o h� pessoas dispon�veis"&gt;
				&lt;html:gridColumn label="Identifica��o" exportable="true"&gt;
					\${ pessoa.id }
				&lt;/html:gridColumn&gt;
				&lt;html:gridColumn label="Nome" exportable="true"&gt;
					\${ pessoa.nome }
				&lt;/html:gridColumn&gt;
			&lt;/html:grid&gt; </html:code>																				</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			