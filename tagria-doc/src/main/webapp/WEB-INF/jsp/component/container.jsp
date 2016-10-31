<%@include file="../app/taglibs.jsp"%>										<html:view title="TagriaLib Documentação">																	<html:panel>																									<html:panelHead label="container"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renderiza um bloco de container principal com uma margem padrao																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table><html:tableLine><html:tableColumn header="true">Atributo</html:tableColumn><html:tableColumn header="true">Obrigatório</html:tableColumn><html:tableColumn header="true">Tipo</html:tableColumn><html:tableColumn header="true">Descrição</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>fluid</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.Boolean</html:tableColumn><html:tableColumn>Indica se o container deve ser responsivo para 100% da tela</html:tableColumn></html:tableLine></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
			
			<html:alert state="info">
				Componente fora do container
			</html:alert>
			
			<html:container>
				<html:alert state="info">
					Componente dentro do container
				</html:alert>
			</html:container> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>
			
			&lt;html:alert state="info"&gt;
				Componente fora do container
			&lt;/html:alert&gt;
			
			&lt;html:container&gt;
				&lt;html:alert state="info"&gt;
					Componente dentro do container
				&lt;/html:alert&gt;
			&lt;/html:container&gt; </html:code>																				</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			