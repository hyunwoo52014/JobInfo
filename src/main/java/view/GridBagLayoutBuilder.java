package view;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


public class GridBagLayoutBuilder {

	private Container source;
	private GridBagConstraints constraints;
	private GridBagLayout layout;
	
	public GridBagLayoutBuilder(Container source) {
		this.source = source;
		this.constraints = new GridBagConstraints();
		this.layout = new GridBagLayout();
		this.source.setLayout(this.layout);
	}

	public GridBagLayoutBuilder gridx(int gridx) {
		constraints.gridx = gridx;
		return this;
	}
	
	public GridBagLayoutBuilder gridy(int gridy) {
		constraints.gridy = gridy;
		return this;
	}
	
	public GridBagLayoutBuilder gridwidth(int gridwidth) {
		constraints.gridwidth = gridwidth;
		return this;
	}
	
	public GridBagLayoutBuilder gridheight(int gridheight) {
		constraints.gridheight = gridheight;
		return this;
	}
	
	public GridBagLayoutBuilder weightx(double weightx) {
		constraints.weightx = weightx;
		return this;
	}
	
	public GridBagLayoutBuilder weighty(double weighty) {
		constraints.weighty = weighty;
		return this;
	}
	
	public GridBagLayoutBuilder anchor(int anchor) {
		constraints.anchor = anchor;
		return this;
	}
	
	public GridBagLayoutBuilder fill(int fill) {
		constraints.fill = fill;
		return this;
	}
	
	public GridBagLayoutBuilder insets(Insets insets) {
		constraints.insets = insets;
		return this;
	}
	
	public GridBagLayoutBuilder ipadx(int ipadx) {
		constraints.ipadx = ipadx;
		return this;
	}
	
	public GridBagLayoutBuilder ipady(int ipady) {
		constraints.ipady = ipady;
		return this;
	}

	public void configure(Container target) {
		this.source.add(target, this.constraints);
	}
	
	public void relpaceSource(Container replaceSource) {
		this.source = replaceSource;
		this.source.setLayout(layout);
	}
}