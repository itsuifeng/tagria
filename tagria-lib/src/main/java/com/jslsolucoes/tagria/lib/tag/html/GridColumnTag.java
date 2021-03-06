
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.html.Span;
import com.jslsolucoes.tagria.lib.html.Td;
import com.jslsolucoes.tagria.lib.html.Th;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class GridColumnTag extends SimpleTagSupport {

	private String label;
	private Boolean booleanType = Boolean.FALSE;
	private Boolean collapsable = Boolean.FALSE;
	private Boolean exportable = Boolean.FALSE;
	private String align = "left";
	private Boolean rendered = Boolean.TRUE;
	private String format;
	private String state;
	private String hideOnViewport;

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {

			String body = TagUtil.getBody(getJspBody());

			if (collapsable || booleanType) {
				align = "center";
			}

			GridTag grid = (GridTag) findAncestorWithClass(this, GridTag.class);

			Th th = new Th();
			th.add(Attribute.CLASS, "text-center");
			if (!StringUtils.isEmpty(hideOnViewport)) {
				th.add(Attribute.CLASS, TagUtil.cssForHideViewport(hideOnViewport));
			}

			if (exportable) {
				th.add(Attribute.CLASS, "bs-grid-column-exportable");
			}
			if (!StringUtils.isEmpty(label)) {
				th.add(TagUtil.getLocalized(label, getJspContext()));
			}
			grid.addTh(th);

			Td td = new Td();
			td.add(Attribute.CLASS, "text-" + align);
			td.add(Attribute.CLASS, "v-align-middle");

			if (!StringUtils.isEmpty(state)) {
				td.add(Attribute.CLASS, "bg-" + state);
			}

			if (!StringUtils.isEmpty(hideOnViewport)) {
				td.add(Attribute.CLASS, TagUtil.cssForHideViewport(hideOnViewport));
			}

			if (exportable) {
				td.add(Attribute.CLASS, "bs-grid-column-exportable");
			}
			if (!StringUtils.isEmpty(body)) {
				Div container = new Div();
				if (collapsable) {
					td.add(Attribute.CLASS, "bs-grid-column-collapsable");
					Span icon = new Span();
					icon.add(Attribute.CLASS, "glyphicon glyphicon-search");
					td.add(icon);
					container.add(Attribute.CLASS, "hidden bs-grid-column-collapsable-content");
				}

				if (!StringUtils.isEmpty(format)) {
					container.add(TagUtil.format(format, body, getJspContext()));
				} else if (booleanType) {
					if ("1".equals(body) || "true".equals(body)) {
						Span icon = new Span();
						icon.add(Attribute.CLASS, "glyphicon glyphicon-ok");
						container.add(icon);
					}
				} else {
					container.add(body);
				}
				td.add(container);
			}
			TagUtil.out(getJspContext(), td);
		}
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Boolean getBooleanType() {
		return booleanType;
	}

	public void setBooleanType(Boolean booleanType) {
		this.booleanType = booleanType;
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public Boolean getExportable() {
		return exportable;
	}

	public void setExportable(Boolean exportable) {
		this.exportable = exportable;
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getHideOnViewport() {
		return hideOnViewport;
	}

	public void setHideOnViewport(String hideOnViewport) {
		this.hideOnViewport = hideOnViewport;
	}

	public Boolean getCollapsable() {
		return collapsable;
	}

	public void setCollapsable(Boolean collapsable) {
		this.collapsable = collapsable;
	}

}
