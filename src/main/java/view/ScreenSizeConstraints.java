package view;

import java.awt.Dimension;

import org.springframework.stereotype.Component;

@Component(value = "ScreenConstraints")
public class ScreenSizeConstraints {
	
	int minWidth,minHeight,preferWidth,preferHeight,maxWidth,maxHeight;
	
	public ScreenSizeConstraints() {
		this.minWidth = 1000;
		this.minHeight = 500;
		this.preferWidth = 1000;
		this.preferHeight = 500;
		this.maxWidth = Integer.MAX_VALUE;
		this.maxHeight = Integer.MAX_VALUE;
	}
	
	
	public ScreenSizeConstraints(int preferWidth, int preferHeight) {
		this.preferWidth = preferWidth;
		this.preferHeight = preferHeight;
	}
	
	public ScreenSizeConstraints minWidth(int minWidth) {
		this.minWidth = minWidth;
		return this;
	}
	
	public ScreenSizeConstraints minHeight(int minHeight) {
		this.minHeight = minHeight;
		return this;
	}
	
	public ScreenSizeConstraints preferWidth(int prefeWidth) {
		this.preferWidth = prefeWidth;
		return this;
	}
	
	public ScreenSizeConstraints preferHeight(int preferHeight) {
		this.preferHeight = preferHeight;
		return this;
	}
	
	public ScreenSizeConstraints maxWidth(int maxWidth) {
		this.maxWidth = maxWidth;
		return this;
	}
	
	public ScreenSizeConstraints maxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
		return this;
	}
	
	public void setSize(java.awt.Component com) {
		com.setMinimumSize(new Dimension(minWidth, minHeight));
		com.setPreferredSize(new Dimension(preferWidth, preferHeight));
		com.setMaximumSize(new Dimension(maxWidth, maxHeight));
	}
	
	public Dimension getMinSize() {
		return new Dimension(minWidth, minHeight);
	}
	
	public Dimension getMaxSize() {
		return new Dimension(maxWidth, maxHeight);
	}
	
	public Dimension getPreferSize() {
		return new Dimension(preferWidth, preferHeight);
	}
}