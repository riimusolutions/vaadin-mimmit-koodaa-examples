package com.riimusolutions.presentations.vaadin.layouts.basic.jira.demo;

import com.riimusolutions.presentations.vaadin.layouts.basic.jira.JiraCard;
import com.riimusolutions.presentations.vaadin.layouts.basic.jira.JiraColumn;
import com.github.javafaker.Faker;
import com.github.javafaker.Job;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route("jira-board")
public class JiraBoard extends HorizontalLayout {

    public JiraBoard() {
        setSizeFull();
        setPadding(true);

        Faker faker = Faker.instance();

        for (int i = 0; i < 5; i++) {
            int cardCount = i + 4;

            JiraColumn column = new JiraColumn();
            column.setTitle(faker.app().name());
            add(column);

            Job job = faker.job();
            for (int j = 0; j < cardCount; j++) {
                JiraCard card = new JiraCard();
                card.setText(job.title());
                card.setTag(job.seniority());
                column.addCard(card);
            }
            column.setCount(cardCount);
        }
    }
}
