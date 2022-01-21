package com.riimusolutions.presentations.vaadin.domain.tickets;

public class TicketStatus {
    private Long id;
    private String name;

    public static TicketStatus of(String name) {
        TicketStatus status = new TicketStatus();
        status.name = name;
        return status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
