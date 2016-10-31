package br.com.jslsolucoes.tagria.doc.generator;

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
import org.apache.commons.lang.SystemUtils;

import com.thoughtworks.xstream.XStream;

import br.com.caelum.vraptor.util.StringUtils;


public class DocGenerator {
	
	public static void main(String[] args) throws IOException {
		
		
		Map<String,List<Tag>> groupments = new HashMap<String,List<Tag>>();
		
		
		String workspace = "/Volumes/Macintosh HD 2/workspace/jslsolucoes";
		if(SystemUtils.IS_OS_WINDOWS){
			workspace = "D:/workspace/gov-stack/tagria";
		} 
		
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
					"<html:view title=\"TagriaLib Documentação\">											"+
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
				template += "<html:alert state=\"info\">Essa tag não possui atributos</html:alert>"; 
			} else {
				
				
				template += "<html:table><html:tableLine>"+
					"<html:tableColumn header=\"true\">Atributo</html:tableColumn>"+
					"<html:tableColumn header=\"true\">Obrigatório</html:tableColumn>"+
					"<html:tableColumn header=\"true\">Tipo</html:tableColumn>"+
					"<html:tableColumn header=\"true\">Descrição</html:tableColumn>"+
					
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
"										<html:code>"+tag.getExampleEscaped()+"</html:code>											"+
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
