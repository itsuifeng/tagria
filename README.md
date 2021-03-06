[![][travis img]][travis]
[![][maven img]][maven]
[![][license img]][license]
[![][sonar img]][sonar]
[![][bugs img]][bugs]
[![][coverage img]][coverage]
[![][lines img]][lines]
[![][vulnerabilities img]][vulnerabilities]
[![][code_smells img]][code_smells]
[![][paypal img]][paypal]

[travis]:https://travis-ci.org/jslsolucoes/tagria
[travis img]:https://travis-ci.org/jslsolucoes/tagria.svg?branch=develop

[maven]:http://search.maven.org/#search|gav|1|g:"com.jslsolucoes"%20AND%20a:"tagria"
[maven img]:https://maven-badges.herokuapp.com/maven-central/com.jslsolucoes/tagria/badge.svg

[license]:LICENSE
[license img]:https://img.shields.io/badge/License-Apache%202-blue.svg

[sonar]:https://sonarcloud.io/dashboard/index/com.jslsolucoes:tagria:develop
[sonar img]:https://sonarcloud.io/api/badges/gate?key=com.jslsolucoes:tagria:develop

[bugs]:https://sonarcloud.io/dashboard/index/com.jslsolucoes:tagria:develop
[bugs img]:https://sonarcloud.io/api/badges/measure?key=com.jslsolucoes:tagria:develop&metric=bugs

[coverage]:https://sonarcloud.io/dashboard/index/com.jslsolucoes:tagria:develop
[coverage img]:https://sonarcloud.io/api/badges/measure?key=com.jslsolucoes:tagria:develop&metric=coverage

[bugs]:https://sonarcloud.io/dashboard/index/com.jslsolucoes:tagria:develop
[bugs img]:https://sonarcloud.io/api/badges/measure?key=com.jslsolucoes:tagria:develop&metric=bugs

[lines]:https://sonarcloud.io/dashboard/index/com.jslsolucoes:tagria:develop
[lines img]:https://sonarcloud.io/api/badges/measure?key=com.jslsolucoes:tagria:develop&metric=lines

[vulnerabilities]:https://sonarcloud.io/dashboard/index/com.jslsolucoes:tagria:develop
[vulnerabilities img]:https://sonarcloud.io/api/badges/measure?key=com.jslsolucoes:tagria:develop&metric=vulnerabilities

[code_smells]:https://sonarcloud.io/dashboard/index/com.jslsolucoes:tagria:develop
[code_smells img]:https://sonarcloud.io/api/badges/measure?key=com.jslsolucoes:tagria:develop&metric=code_smells

[paypal]:https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=PE25DPU3CNFH4
[paypal img]:https://www.paypalobjects.com/en_US/i/btn/btn_donateCC_LG.gif


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
	&lt;version&gt;1.0.16&lt;/version&gt;
&lt;/dependency&gt;
	</code>
</pre>

or download binary and dependencies hosted on <a href='https://bintray.com/jslsolucoes/tagria/com.jslsolucoes.tagria'>bintray</a> 

Create an jsp for example index.jsp and import directives
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
			<td>Url of cdn host</td>
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


