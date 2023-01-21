package devarea.fr.discord.entity.events_filler;

import devarea.fr.discord.commands.Context;
import discord4j.core.event.domain.lifecycle.ReadyEvent;

public class ReadyEventFiller extends Filler<ReadyEvent> {
    public ReadyEventFiller(ReadyEvent event) {
        super(event);
    }

    @Override
    public Context context() {
        return Context.builder().build();
    }
}
