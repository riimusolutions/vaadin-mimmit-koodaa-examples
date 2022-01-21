package com.riimusolutions.presentations.vaadin.grid;

import com.riimusolutions.presentations.vaadin.util.Badge;
import com.riimusolutions.presentations.vaadin.domain.tickets.Tag;
import com.riimusolutions.presentations.vaadin.domain.tickets.Ticket;
import com.riimusolutions.presentations.vaadin.domain.tickets.TicketService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.LocalDateTimeRenderer;
import com.vaadin.flow.router.Route;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.stream.Stream;

@Route("grid")
public class GridExampleView extends VerticalLayout {

    public GridExampleView() {
        setSizeFull();
        TicketService ticketService = TicketService.getInstance();

        Grid<Ticket> ticketGrid = new Grid<>(Ticket.class);
        ticketGrid.setSizeFull();
        ticketGrid.setItems(ticketService.findAllTickets());
        ticketGrid.removeColumnByKey("tags");

        ticketGrid.setColumns("id", "title", "description");
        ticketGrid.addComponentColumn(this::createStatusBadge)
                .setHeader("Status")
                .setKey("status")
                .setTextAlign(ColumnTextAlign.CENTER);
        ticketGrid.addComponentColumn(this::createTagsComponent)
                .setHeader("Tags")
                .setKey("tags");
        ticketGrid.addColumn(new LocalDateTimeRenderer<>(Ticket::getCreatedAt, DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)))
                .setHeader("Created At")
                .setKey("createdAt");

        Stream.of("id", "title", "status", "tags", "createdAt")
                .map(ticketGrid::getColumnByKey)
                .forEach(column -> {
                    column.setAutoWidth(true);
                    column.setFlexGrow(0);
                });

        ticketGrid.addThemeVariants(GridVariant.LUMO_COMPACT, GridVariant.LUMO_ROW_STRIPES, GridVariant.LUMO_COLUMN_BORDERS);
        add(ticketGrid);
    }

    private Component createStatusBadge(Ticket ticket) {
        if (ticket.getStatus() == null) {
            return new Text("");
        }
        Badge badge = new Badge();
        badge.setPill(false);
        switch (ticket.getStatus().getName()) {
            case "TODO":
                badge.setColor("#3F993F");
                break;
            case "In Progress":
                badge.setColor("#1F75CC");
                break;
            case "Testing":
                badge.setColor("#BD7332");
                break;
            case "Done":
                badge.setColor("#2E3442");
                break;
            default:
                badge.setColor("black");
        }
        badge.setText(ticket.getStatus().getName());
        badge.setWidth("85px");
        return badge;
    }

    private Component createTagsComponent(Ticket ticket) {
        HorizontalLayout container = new HorizontalLayout();
        for (Tag tag : ticket.getTags()) {
            Badge tagBadge = new Badge();
            tagBadge.setPill(true);
            tagBadge.setText(tag.getName());
            tagBadge.setColor(tag.getColor());
            container.add(tagBadge);
        }
        return container;
    }
}
