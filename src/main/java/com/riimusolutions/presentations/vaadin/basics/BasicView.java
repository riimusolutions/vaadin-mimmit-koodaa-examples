package com.riimusolutions.presentations.vaadin.basics;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("basics")
@StyleSheet("./themes/myapp/styles.css")
public class BasicView extends VerticalLayout {

    public BasicView() {
        setSizeFull();

        H1 title = new H1("Basics");
        title.addClickListener(event -> Notification.show("Title Clicked!"));
        title.getElement().addEventListener("mouseover", event -> Notification.show("Mouse Over!"));

        Button actionButton = new Button("Action");
        actionButton.addClickListener(event -> Notification.show("Button Clicked!"));
        actionButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Button styleThroughCss = new Button("Style Through CSS");
        styleThroughCss.addClickListener(event -> title.addClassName("title-style"));

        Button styleThroughElement = new Button("Style with property");
        styleThroughElement.addClickListener(event -> getStyle().set("background", "#6EB288FF"));

        add(title, actionButton, styleThroughCss, styleThroughElement);
    }

}
