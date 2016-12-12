<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="datePickerOnSelect"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders an event to select a date																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info" label="{tag.empty.attributes}"></html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
			<html:input name="input1" placeholder="Data" />
			<html:datePicker attachTo="input1" min="0">
				<html:datePickerOnSelect>
					/* Nesse ponto fica disponivel as variaveis dateText,inst  */
					alert(dateText);
				</html:datePickerOnSelect>
			</html:datePicker> 																							</html:tab>																									<html:tab label="{source}">																					<html:code>																										&lt;html:view&gt;
			&lt;html:input name="input1" placeholder="Data" /&gt;
			&lt;html:datePicker attachTo="input1" min="0"&gt;
				&lt;html:datePickerOnSelect&gt;
					/* Nesse ponto fica disponivel as variaveis dateText,inst  */
					alert(dateText);
				&lt;/html:datePickerOnSelect&gt;
			&lt;/html:datePicker&gt; &lt;/html:view&gt;																					</html:code>																							</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			