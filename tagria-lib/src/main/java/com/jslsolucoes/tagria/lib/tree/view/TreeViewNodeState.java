
package com.jslsolucoes.tagria.lib.tree.view;

public class TreeViewNodeState {
	private Boolean opened = Boolean.FALSE;
	private Boolean disabled = Boolean.FALSE;
	private Boolean selected = Boolean.FALSE;

	public Boolean getOpened() {
		return opened;
	}

	public void setOpened(Boolean opened) {
		this.opened = opened;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
}