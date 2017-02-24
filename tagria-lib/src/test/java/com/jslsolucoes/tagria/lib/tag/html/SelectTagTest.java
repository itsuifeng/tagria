package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public class SelectTagTest {

	@Mock
	private JspContext jspContext;
	
	@Mock
	private JspFragment jspFragment;
	
	@Mock
	private Writer writer;
	
	private MockJspWriter mockJspWriter;
	
	@Before
	public void tearUp(){
		MockitoAnnotations.initMocks(this);
		mockJspWriter = new MockJspWriter();
		Mockito.when(jspContext.getOut()).thenReturn(mockJspWriter);
	}
	
	@Test
	public void render() throws JspException, IOException{
		
		Set<String> values = new HashSet<>();
		values.add("1");
		values.add("2");
		values.add("3");
		
		
		SelectTag selectTag = new SelectTag();
		selectTag.setJspBody(jspFragment);
		selectTag.setJspContext(jspContext);
		selectTag.setData(values);
		selectTag.setName("preferences");
		selectTag.setValue("1");
		
		selectTag.doTag();
		
		Assert.assertEquals("<select class=\"form-control\" id=\"par_preferences\" name=\"preferences\"><option value=\"\">- - -</option></select>",mockJspWriter.output());
	}
}
