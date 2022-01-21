package com.riimusolutions.presentations.vaadin.layouts.basic.jira;

import com.riimusolutions.presentations.vaadin.util.Badge;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class JiraCard extends VerticalLayout {
    private final Span title = new Span();
    private final VerticalLayout body = new VerticalLayout();
    private final HorizontalLayout footer = new HorizontalLayout();
    private final Badge tagBadge = new Badge();

    public JiraCard() {
        add(title);
        add(body);
        add(footer);

        body.add(tagBadge);
        body.setPadding(false);

        Icon trendingUp = VaadinIcon.TRENDING_UP.create();
        trendingUp.setColor("green");
        trendingUp.setSize("16px");

        Icon alarm = VaadinIcon.ALARM.create();
        alarm.setColor("red");
        alarm.setSize("16px");

        Badge effort = new Badge();
        effort.setText("9");

        Span ticketNumber = new Span();
        ticketNumber.setText("TIS-12");

        HorizontalLayout statusBar = new HorizontalLayout(trendingUp, alarm, effort);
        statusBar.setAlignItems(Alignment.CENTER);

        footer.add(statusBar, ticketNumber);
        footer.setAlignItems(Alignment.CENTER);
        footer.setWidthFull();
        footer.setJustifyContentMode(JustifyContentMode.BETWEEN);

        setWidth("350px");
        setMaxWidth("100%");
        addClassName("shadow-m");
        ticketNumber.addClassName("font-thin");
        ticketNumber.addClassName("text-s");
        ticketNumber.addClassName("text-tertiary");
    }

    public void setText(String text) {
        title.setText(text);
    }

    public void setTag(String tagText) {
        boolean hasText = tagText != null && !tagText.isBlank();
        tagBadge.setVisible(hasText);

        if (hasText) {
            tagBadge.setText(tagText);
        }
    }

}
