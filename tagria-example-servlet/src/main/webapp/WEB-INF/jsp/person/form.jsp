<%@include file="../app/taglibs.jsp"%>
<html:view title="Tagria example">

	<html:form action="/person/saveOrUpdate" label="Person">
		<html:input type="hidden" name="id" value="${person.id}"></html:input>
		<html:formGroup label="Name" required="true">
			<html:input name="name" value="${person.name}" required="true"/>
		</html:formGroup>
		<html:formGroup label="Age" required="true">
			<html:input name="age" type="number" value="${ person.age }" required="true"/>
		</html:formGroup>
	</html:form>
	
	<html:block align="center">
		<html:link label="Voltar" url="/person/list"/>
	</html:block>
	
</html:view>