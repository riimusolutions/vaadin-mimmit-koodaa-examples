package com.riimusolutions.presentations.vaadin.util;

import com.vaadin.flow.component.html.Span;

public class Badge extends Span {

    public Badge() {
        getElement().getThemeList().add("badge");
        setPill(true);
        setContrast(true);
    }

    public void setPill(boolean pill) {
        getElement().getThemeList().set("pill", pill);
    }

    public void setContrast(boolean contrast) {
        getElement().getThemeList().set("contrast", contrast);
    }

    public void setColor(String color) {
        getStyle().set("background", color);
        getStyle().set("color", "var(--lumo-success-contrast-color)");
    }
}
