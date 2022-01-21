package com.riimusolutions.presentations.vaadin.domain.tickets;

import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TicketService {
    private static final TicketService instance = new TicketService();
    private final Faker faker = new Faker();
    private final List<Tag> tags;

    public static TicketService getInstance() {
        return instance;
    }

    public TicketService() {
        tags = IntStream.range(0, 5)
                .mapToObj(item -> Tag.of(faker.programmingLanguage().name(), faker.color().hex()))
                .collect(Collectors.toList());
    }

    public List<Tag> findAllTags() {
        return Collections.unmodifiableList(tags);
    }

    public List<Ticket> findAllTickets() {
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Ticket ticket = new Ticket();
            ticket.setId(Long.valueOf(i));

            ticket.setTitle(environment() + " issue at " + faker.app().name());
            ticket.setCreatedAt(LocalDateTime.now().minus(60 * (i + 3), ChronoUnit.MINUTES));
            ticket.setDescription(faker.yoda().quote());
            ticket.setStatus(randomStatus());
            ticket.setTags(randomTags());

            tickets.add(ticket);
        }
        return Collections.unmodifiableList(tickets);
    }

    private TicketStatus randomStatus() {
        return faker.options().nextElement(findAllStatuses());
    }

    private List<Tag> randomTags() {
        int total = faker.number().numberBetween(0, 3);
        List<Tag> tags = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            Tag randomTag = faker.options().nextElement(findAllTags());
            tags.add(randomTag);
        }
        return tags;
    }

    private String environment() {
        return faker.options().option("Test", "Development", "Production");
    }

    public List<TicketStatus> findAllStatuses() {
        return Collections.unmodifiableList(Arrays.asList(
                TicketStatus.of("TODO"), TicketStatus.of("In Progress"), TicketStatus.of("Testing"), TicketStatus.of("Done")
        ));
    }
}
