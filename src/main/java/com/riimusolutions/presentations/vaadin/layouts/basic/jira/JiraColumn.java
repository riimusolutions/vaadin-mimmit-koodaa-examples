package com.riimusolutions.presentations.vaadin.layouts.basic.jira;

import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class JiraColumn extends VerticalLayout {
    private final HorizontalLayout titleBar = new HorizontalLayout();
    private final H4 title = new H4();
    private final Span ticketCount = new Span();
    private final VerticalLayout content = new VerticalLayout();

    public JiraColumn() {
        titleBar.add(title, ticketCount);
        add(titleBar);

        Scroller scroller = new Scroller();
        scroller.setContent(content);
        scroller.setWidthFull();
        add(scroller);

        setWidth("350px");
        titleBar.setAlignItems(Alignment.BASELINE);
        titleBar.setWidthFull();
        titleBar.addClassName("border-b");
        titleBar.addClassName("border-contrast-20");

        addClassName("bg-contrast-10");
        addClassName("rounded-l");
    }

    public void setTitle(String title) {
        if (title == null) {
            this.title.setText("");
        } else {
            this.title.setText(title);
        }
    }

    public void setCount(int ticketCount) {
        this.ticketCount.setText(String.valueOf(ticketCount));
    }

    public void addCard(JiraCard card) {
        card.addClassName("bg-base");
        content.add(card);
    }

    public void removeCard(JiraCard card) {
        content.remove(card);
    }
}
