<%@include file="../app/taglibs.jsp"%>										<html:view title="{title}">																	<html:panel>																									<html:panelHead label="onError"></html:panelHead>												<html:panelBody>																								<html:tabPanel>																									<html:tab label="{about}" active="true">																	<html:alert state="warning">																				     	Renders the error block if they occur in ajax request																			</html:alert>																							</html:tab>																									<html:tab label="{attributes}">										<html:alert state="info" label="{tag.empty.attributes}"></html:alert>																																	</html:tab>																									<html:tab label="{demo}">																						
			<ajax:function name="data" url="/app/url/does/not/exists" executeOnDocumentLoad="true">
			    <ajax:onSuccess>
			    	      
			    </ajax:onSuccess>
			    <ajax:onError>
			           /*Available is this part javascript variables ( jqXHR jqXHR, String textStatus, String errorThrown )*/
			           alert(textStatus);
			           alert(errorThrown);
			           alert(jqXHR);
			    </ajax:onError>
			</ajax:function>
																									</html:tab>																									<html:tab label="{source}">																					<html:code>
			&lt;ajax:function name="data" url="/app/url/does/not/exists" executeOnDocumentLoad="true"&gt;
			    &lt;ajax:onSuccess&gt;
			    	      
			    &lt;/ajax:onSuccess&gt;
			    &lt;ajax:onError&gt;
			           /*Available is this part javascript variables ( jqXHR jqXHR, String textStatus, String errorThrown )*/
			           alert(textStatus);
			           alert(errorThrown);
			           alert(jqXHR);
			    &lt;/ajax:onError&gt;
			&lt;/ajax:function&gt;
		</html:code>																				</html:tab>																								</html:tabPanel>																						</html:panelBody>																						</html:panel>																							</html:view>																			