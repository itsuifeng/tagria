# tagria
Tagria is an open source component suit framework that help build beautiful view in minutes. Tagria integrates perfectly with any action based mvc framework for java : 
Tagria it`s easy , fast and productive.

Tested at moment in MVC frameworks and specs :
<ul>
	<li>Spring MVC</li>
	<li>Vraptor</li>
	<li>Struts</li>
	<li>Servlet</li>
	<li>Mentawai</li>
</ul>

Tested at moment in applications servers :
<ul>
	<li>Tomcat</li>
	<li>Jetty</li>
	<li>Wildfly</li>
	<li>Jboss</li>
	<li>Websphere</li>
</ul>


Features :
<ul>
	<li>Full html5,css3 support</li>
	<li>Cross browser support components</li>
	<li>Responsive</li>
	<li>Over 50 projects in production</li>
	<li>W3C compatible</li>
	<li>Support for i18n (internationalization)</li>
</ul>


<hr/>

The demo and documentation about components of tagria is hosted in : 
<a href='https://doc-tagrialib.jslsolucoes.com' target='_blank'>https://doc-tagrialib.jslsolucoes.com</a>

<hr/>
Quick start installation and configuration : 

Add maven dependency to your project :
<pre>
	<code>
&lt;dependency&gt;
	&lt;groupId&gt;com.jslsolucoes&lt;/groupId&gt;
	&lt;artifactId&gt;tagria-lib&lt;/artifactId&gt;
	&lt;version&gt;1.0.0&lt;/version&gt;
&lt;/dependency&gt;
	</code>
</pre>

Register servlet in your web.xml
<pre>
	<code>
&lt;servlet&gt;
	&lt;servlet-name&gt;tagria&lt;/servlet-name&gt;
	&lt;servlet-class&gt;com.jslsolucoes.tagria.lib.servlet.Tagria&lt;/servlet-class&gt;
&lt;/servlet&gt;
&lt;servlet-mapping&gt;
	&lt;servlet-name&gt;tagria&lt;/servlet-name&gt;
	&lt;url-pattern&gt;/tagria/*&lt;/url-pattern&gt;
&lt;/servlet-mapping&gt;
	</code>
</pre>

Create an jsp for example index.jsp
<pre>
	<code>
	
&lt;%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %&gt;
&lt;%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %&gt;
&lt;%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %&gt;
&lt;%@ taglib  uri="http://tagrialib.jslsolucoes.com/tags/html" prefix="html"%&gt;
&lt;%@ taglib  uri="http://tagrialib.jslsolucoes.com/tags/ajax" prefix="ajax"%&gt;
&lt;%@ taglib  uri="http://tagrialib.jslsolucoes.com/tags/x" prefix="x"%&gt;
&lt;html:view title="My title"&gt;
	&lt;html:alert state="info"&gt;
		My firts view	
	&lt;/html:alert&gt;
&lt;/html:view&gt;
</code>
</pre>

Some configuration can be change by creating an tagrialib.properties file in source folder like :
<pre>
	<code>
encoding=ISO-8859-1
locale=pt-BR
cdn.enabled=true
cdn.url=fdsfds.cloudfront.net
skin=green
	</code>
</pre>

<table>
	<tbody>
		<tr>
			<th>Parameter</th>
			<th>Description</th>
			<th>Default value</th>
			<th>Values</th>
		</tr>
		<tr>
			<td>encoding</td>
			<td>Encoding to be used</td>
			<td align="center">utf-8</td>
			<td>Any valid encoding</td>
		</tr>
		<tr>
			<td>locale</td>
			<td>Locale used by components</td>
			<td align="center">en</td>
			<td>Any valid locale</td>
		</tr>
		<tr>
			<td>cdn.enabled</td>
			<td>If serve static files using cdn like cloud front</td>
			<td align="center">-</td>
			<td>true|false</td>
		</tr>
		<tr>
			<td>cdn.url</td>
			<td>Ur of cdn host</td>
			<td align="center">-</td>
			<td>Host endpoint</td>
		</tr>
		<tr>
			<td>skin</td>
			<td>Skin to use</td>
			<td align="center">default</td>
			<td>default,green</td>
		</tr>
	</tbody>
</table>

<h1>For premium support please contact : jonatan@jslsolucoes.com</h2>


