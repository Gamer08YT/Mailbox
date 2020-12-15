/*
 * Copyright (C) Byte-Store.DE, Inc - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */

package de.packet.mailbox.handler;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class TagHandler extends ListenerAdapter {
    @Override
    public void onGenericEvent(@Nonnull GenericEvent event) {
        System.out.println(event);
    }
}
