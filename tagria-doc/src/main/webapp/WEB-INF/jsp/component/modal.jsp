<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="modal"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renderiza um bloco modal																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:table><html:tableLine><html:tableColumn header="true"><fmt:message key="tag.attribute"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.required"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.type"/></html:tableColumn><html:tableColumn header="true"><fmt:message key="tag.description"/></html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>id</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indica o id do modal para manipulacao direta de eventos</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>label</html:tableColumn><html:tableColumn>true</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indica o label do titulo do modal</html:tableColumn></html:tableLine><html:tableLine><html:tableColumn>attachTo</html:tableColumn><html:tableColumn>false</html:tableColumn><html:tableColumn>java.lang.String</html:tableColumn><html:tableColumn>Indica o componente que dispara a tela de modal</html:tableColumn></html:tableLine></html:table>																																	</html:tab>																									<html:tab label="{demo}">																						
		    <html:button id="botao" label="Abrir modal"/>
			<html:modal label="Titulo do modal" attachTo="botao">
				Outros componentes 
				
				<html:toolbar>
					Componentes
				</html:toolbar>
				
			</html:modal> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>
		    &lt;html:button id="botao" label="Abrir modal"/&gt;
			&lt;html:modal label="Titulo do modal" attachTo="botao"&gt;
				Outros componentes 
				
				&lt;html:toolbar&gt;
					Componentes
				&lt;/html:toolbar&gt;
				
			&lt;/html:modal&gt; </html:code>																				</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			