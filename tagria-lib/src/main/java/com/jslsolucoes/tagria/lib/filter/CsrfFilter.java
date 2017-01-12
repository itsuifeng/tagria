package com.jslsolucoes.tagria.lib.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

@WebFilter(filterName = "csrf", urlPatterns = "/*", dispatcherTypes = { DispatcherType.FORWARD,
		DispatcherType.REQUEST })
public class CsrfFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = ((HttpServletRequest) request);
		HttpServletResponse httpServletResponse = ((HttpServletResponse) response);
		
		String csfr = httpServletRequest.getParameter("csrf");
		String csfrId = httpServletRequest.getParameter("csrf_id");
		
		if (!StringUtils.isEmpty(csfr) && !StringUtils.isEmpty(csfrId) && !CsfrManager.isValidFor(csfrId, csfr)) {
			httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {

	}

}
