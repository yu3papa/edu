package com.logicbig;

import org.jwidgets.SimpleRenderer;

public class RendererSupport {
	public void render(Object object) {
		new SimpleRenderer().renderAsString(object);
	}
}