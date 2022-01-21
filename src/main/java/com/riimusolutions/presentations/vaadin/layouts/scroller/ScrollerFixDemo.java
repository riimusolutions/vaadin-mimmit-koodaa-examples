package com.riimusolutions.presentations.vaadin.layouts.scroller;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("scroller-fix")
public class ScrollerFixDemo extends VerticalLayout {

    public ScrollerFixDemo() {
        setSizeFull();
        VerticalLayout content = new VerticalLayout();

        Scroller scroller = new Scroller();
        scroller.setWidthFull();
        scroller.setHeight(100 - 8.25f, Unit.PERCENTAGE);
        scroller.setContent(content);

        add(scroller);
        setFlexGrow(1, content);

        for (int i = 0; i < 100; i++) {
            content.add(new TextField("Field " + (i + 1)));
        }

        HorizontalLayout footer = new HorizontalLayout();
        footer.setWidthFull();

        footer.add(new Button("Some Action"));
        footer.setHeight(8.25f, Unit.PERCENTAGE);
        add(footer);
    }
}
