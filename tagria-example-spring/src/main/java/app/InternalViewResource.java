package app;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Component
public class InternalViewResource extends InternalResourceViewResolver {

	@Override
	protected String getPrefix() {
		return "/WEB-INF/jsp/";
	}

	@Override
	protected String getSuffix() {
		return ".jsp";
	}

}