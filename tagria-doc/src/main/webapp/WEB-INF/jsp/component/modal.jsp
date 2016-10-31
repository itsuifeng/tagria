<%@include file="../app/taglibs.jsp"%>										<html:view title="TagriaLib Documentação">																	<html:panel>																									<html:panelHead label="modal"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renderiza um bloco modal																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table><html:tableLine><html:tableColumn header="true">Atributo</html:tableColumn><html:tableColumn header="true">Obrigatório</html:tableColumn><html:tableColumn header="true">Tipo</html:tableColumn><html:tableColumn header="true">Descrição</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>id</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indica o id do modal para manipulacao direta de eventos</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>label</html:tableColumn><html:tableColumn>true</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indica o label do titulo do modal</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>attachTo</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indica o componente que dispara a tela de modal</html:tableColumn></html:tableLine></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
		    <html:button id="botao" label="Abrir modal"/>
			<html:modal label="Titulo do modal" attachTo="botao">
				Outros componentes 
			</html:modal> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>
		    &lt;html:button id="botao" label="Abrir modal"/&gt;
			&lt;html:modal label="Titulo do modal" attachTo="botao"&gt;
				Outros componentes 
			&lt;/html:modal&gt; </html:code>																				</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			