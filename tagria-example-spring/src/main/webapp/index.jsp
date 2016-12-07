<%@include file="/WEB-INF/jsp/app/taglibs.jsp"%>
<html:view title="Tagria example">
	<html:nav>
		<html:container>
			<html:menuButton icon="cog" align="right">
				<html:menuItem label="Persons" url="/person/list" target="content"></html:menuItem>
			</html:menuButton>
		</html:container>
	</html:nav>
	
	<html:container>
		<html:block>
			<html:iframe url="/app/welcome" name="content"></html:iframe>
		</html:block>
	</html:container>
</html:view>