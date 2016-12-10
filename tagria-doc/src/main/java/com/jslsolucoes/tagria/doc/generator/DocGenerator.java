/*******************************************************************************
 * Copyright 2016 JSL Solucoes LTDA - https://jslsolucoes.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.jslsolucoes.tagria.doc.generator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;

import com.thoughtworks.xstream.XStream;

import br.com.caelum.vraptor.util.StringUtils;


public class DocGenerator {
	
	public static void main(String[] args) throws IOException {
		
		
		String workspace = args[0];
		Map<String,List<Tag>> groupments = new HashMap<String,List<Tag>>();
		
		String html = FileUtils.readFileToString(new File(workspace + "/tagria-lib/src/main/resources/META-INF/html.tld"),"utf-8");
		String ajax = FileUtils.readFileToString(new File(workspace + "/tagria-lib/src/main/resources/META-INF/ajax.tld"),"utf-8");
		XStream xStream = new XStream();
		xStream.processAnnotations(Taglib.class);
		Taglib taglibForHtml = (Taglib) xStream.fromXML(html);
		Taglib taglibForAjax = (Taglib) xStream.fromXML(ajax);
		List<Tag> tags = new ArrayList<Tag>();
		tags.addAll(taglibForHtml.getTags());
		tags.addAll(taglibForAjax.getTags());
		
		for(Tag tag : tags){
			
			List<Tag> groups = groupments.get(tag.getGroup());
			if(groups == null){
				groupments.put(tag.getGroup(), new ArrayList<Tag>());
			}
			groupments.get(tag.getGroup()).add(tag);
			
			String template = "<%@include file=\"../app/taglibs.jsp\"%>										"+
					"<html:view title=\"{title}\">											"+
"						<html:panel>																		"+
"							<html:panelHead label=\""+tag.getName()+"\"></html:panelHead>					"+
"							<html:panelBody>																"+
"								<html:tabPanel>																"+
"									<html:tab label=\"{about}\" active=\"true\">							"+
"										<html:alert state=\"warning\">										"+
"										     	"+tag.getDescription()+"									"+	
"										</html:alert>														"+
"									</html:tab>																"+
"									<html:tab label=\"{attributes}\">										";
			
			if(CollectionUtils.isEmpty(tag.getAttributes())){
				template += "<html:alert state=\"info\" label=\"{tag.empty.attributes}\"></html:alert>"; 
			} else {
				
				
				template += "<html:table><html:tableLine>"+
					"<html:tableColumn header=\"true\"><fmt:message key=\"tag.attribute\"/></html:tableColumn>"+
					"<html:tableColumn header=\"true\"><fmt:message key=\"tag.required\"/></html:tableColumn>"+
					"<html:tableColumn header=\"true\"><fmt:message key=\"tag.type\"/></html:tableColumn>"+
					"<html:tableColumn header=\"true\"><fmt:message key=\"tag.description\"/></html:tableColumn>"+
					
				"</html:tableLine>";
				
				for(Attribute attribute : tag.getAttributes()){
					
					template += "<html:tableLine>"+
							"<html:tableColumn>"+attribute.getName()+"</html:tableColumn>"+
							"<html:tableColumn>"+(attribute.getRequired() == null ? false : true)+"</html:tableColumn>"+
							"<html:tableColumn>"+attribute.getType()+"</html:tableColumn>"+
							"<html:tableColumn>"+attribute.getDescription()+"</html:tableColumn>"+
							
						"</html:tableLine>";
				}
				
				template += "</html:table>";
			}
			
template += "																								"+
"									</html:tab>																"+
"									<html:tab label=\"{demo}\">												"+
"										"+tag.getExample()	+"														"+
"									</html:tab>																"+
"									<html:tab label=\"{source}\">											"+
"										<html:code>															"+
"											&lt;html:view&gt;"+tag.getExampleEscaped()+"&lt;/html:view&gt;											"+
"										</html:code>														"+
"									</html:tab>																"+
"								</html:tabPanel>															"+
"							</html:panelBody>																"+
"						</html:panel>																		"+
"					</html:view>																			";
			FileUtils.writeStringToFile(new File(workspace + "/tagria-doc/src/main/webapp/WEB-INF/jsp/component/"+tag.getName()+".jsp"), template,"iso-8859-1");
		}
		
		for(String key : groupments.keySet()){
			Collections.sort(groupments.get(key),new Comparator<Tag>() {
				@Override
				public int compare(Tag o1, Tag o2) {
					return o1.getName().compareTo(o2.getName());
				}
			});
		}
	
		
		String menu = "<html:div cssClass=\"menu\"><html:listGroup>";
		for(String key : new TreeSet<String>(groupments.keySet())){
			menu +="<html:listGroupItem><html:collapsable label=\""+key+"\"><html:listGroup>";
			for(Tag tag : groupments.get(key)){
				menu +="<html:listGroupItem><html:link label=\""+StringUtils.capitalize(tag.getName())+"\" target=\"conteudo\" url=\"/component/"+tag.getName()+"\"></html:link></html:listGroupItem>";
			}
			menu +="</html:listGroup></html:collapsable></html:listGroupItem>";
		}
		menu +="</html:listGroup></html:div>";
		
		File home = new File(workspace + "/tagria-doc/src/main/webapp/WEB-INF/jsp/app/index.jsp");
		FileUtils.writeStringToFile(home, FileUtils.readFileToString(home,"iso-8859-1").replaceAll("<html:div cssClass=\"menu\">[\\s\\S]*?</html:div>", menu),"iso-8859-1");
		
		
	}
}
