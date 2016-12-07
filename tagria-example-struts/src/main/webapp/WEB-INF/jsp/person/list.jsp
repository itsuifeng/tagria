<%@include file="../app/taglibs.jsp"%>
<html:view title="Tagria example">

	
	<html:grid data="${personList}" var="person" 
	label="List of persons" export="true" paginate="false">

		<html:gridColumn label="Name" exportable="true">
			${ person.name }
		</html:gridColumn>

		<html:gridColumn label="Age" exportable="true">
			${ person.age }
		</html:gridColumn>

		<html:gridColumn>
			<html:buttonGroup spaced="true">
				<html:button url="/person/edit?person.id=${person.id}" icon="pencil"/>
				<html:button state="danger" icon="trash" id="${ person.id }" />
				<html:confirm label="Are you sure about delete this person ?"
					attachTo="${ person.id }" url="/person/delete?person.id=${person.id}"></html:confirm>
			</html:buttonGroup>
		</html:gridColumn>

		<html:toolbar>
			<html:button url="/person/form" icon="plus" />
		</html:toolbar>

	</html:grid>

</html:view>