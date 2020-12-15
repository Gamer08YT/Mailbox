/*
 * Copyright (C) Byte-Store.DE, Inc - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */

package de.packet.mailbox.handler;

import de.packet.mailbox.core.CacheHandler;
import de.packet.mailbox.core.DiscordEmbed;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class ChatHandler extends ListenerAdapter {
    @Override
    public void onPrivateMessageReceived(@Nonnull PrivateMessageReceivedEvent event) {
        System.out.println(event.getMessage().getContentDisplay());
        if (!event.getAuthor().getId().equalsIgnoreCase(event.getJDA().getSelfUser().getId())) {
            if (CacheHandler.MAILBOX_STATUS) {
                event.getChannel().sendMessage(DiscordEmbed.fileds("ByteMailbox", Color.BLUE, "Unfortunately I am currently not available!\n" +
                        "Please contact me again later.\n\n" +
                        ":upside_down: :thumbsup:\n\n" +
                        "Respond with :incoming_envelope: to leave a message.")).complete();
            }

        } else {
            if (event.getMessage().getContentRaw().contains("!MAILBOX_ON")) {
                CacheHandler.MAILBOX_STATUS = true;
                event.getMessage().delete().queue();
                final Message msg = event.getChannel().sendMessage(DiscordEmbed.simple("ByteMailbox", Color.BLUE, "Success!\n Your Mailbox is now enabled!")).complete();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        msg.delete().queue();
                    }
                }, 1500);
            }

            if (event.getMessage().getContentRaw().contains("!MAILBOX_OFF")) {
                CacheHandler.MAILBOX_STATUS = false;
                event.getMessage().delete().queue();
                final Message msg = event.getChannel().sendMessage(DiscordEmbed.simple("ByteMailbox", Color.BLUE, "Success!\n Your Mailbox is now disabled!")).complete();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        msg.delete().queue();
                    }
                }, 1500);
            }
        }
    }
}
