package com.riimusolutions.presentations.vaadin.layouts.basic.jira.demo;

import com.riimusolutions.presentations.vaadin.layouts.basic.jira.JiraCard;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("jira-card")
public class JiraCardDemo extends VerticalLayout {

    public JiraCardDemo() {
        JiraCard card = new JiraCard();
        card.setText("A real issue to fix");
        card.setTag("Spacecraft");
        add(card);
    }

}
