package example.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

@Namespace(value = "/app")
public class AppAction {

	@Action(value = "welcome", results = @Result(name = Action.DEFAULT_VALUE, location = "/WEB-INF/jsp/app/welcome.jsp"))
	public String welcome() {
		return Action.DEFAULT_VALUE;
	}

}