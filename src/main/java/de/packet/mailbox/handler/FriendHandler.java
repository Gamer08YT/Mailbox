/*
 * Copyright (C) Byte-Store.DE, Inc - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */

package de.packet.mailbox.handler;

import de.packet.mailbox.core.CacheHandler;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.user.GenericUserEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class FriendHandler extends ListenerAdapter {

    public void onFriendRequest(@Nonnull Event event) {
        System.out.println(event);
        if (CacheHandler.MAILBOX_STATUS) {

        }
    }
}
