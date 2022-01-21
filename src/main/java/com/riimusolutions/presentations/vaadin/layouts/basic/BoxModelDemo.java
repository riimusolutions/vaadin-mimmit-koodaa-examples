package com.riimusolutions.presentations.vaadin.layouts.basic;

import com.riimusolutions.presentations.vaadin.util.Utils;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.Route;

@Route("boxes")
@StyleSheet("./themes/styles.css")
public class BoxModelDemo extends FlexLayout {

    public BoxModelDemo() {
        setWidthFull();
        setFlexWrap(FlexWrap.WRAP);

        for (int i = 0; i < 10; i++) {
            Div box = createBox("green");
            add(box);
        }

        for (int i =0; i< 5;i++) {
            Div box = createBox("blue");
            box.getStyle().set("border-radius", "2em");
            add(box);
        }
    }

    private Div createBox(String color) {
        Div box = new Div();
        box.setHeight(100, Unit.PIXELS);
        box.setWidth(100, Unit.PIXELS);

        Utils.setBorder(box, color);
        box.getStyle().set("margin", "1em");
        box.getStyle().set("padding", "1em");
        return box;
    }
}
