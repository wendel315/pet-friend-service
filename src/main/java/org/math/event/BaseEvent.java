package org.math.event;

import java.time.Instant;

public abstract class BaseEvent {
    private final String aggregateId;
    private final Instant occurredOn;

    protected BaseEvent(String aggregateId) {
        this.aggregateId = aggregateId;
        this.occurredOn = Instant.now();
    }

    public String getAggregateId() {
        return aggregateId;
    }

    public Instant getOccurredOn() {
        return occurredOn;
    }

    public abstract String getEventName();
}

