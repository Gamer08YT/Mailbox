/*
 * Copyright (C) Byte-Store.DE, Inc - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */

package de.packet.mailbox.handler;

import de.packet.mailbox.core.CacheHandler;
import de.packet.mailbox.core.DiscordEmbed;
import net.dv8tion.jda.api.events.message.priv.react.PrivateMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.priv.react.PrivateMessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.awt.*;

public class ReactHandler extends ListenerAdapter {
    @Override
    public void onPrivateMessageReactionAdd(@Nonnull PrivateMessageReactionAddEvent event) {
        if (CacheHandler.MAILBOX_STATUS) {
            if (event.getReactionEmote().getEmoji().equalsIgnoreCase("\uD83D\uDCE8")) {
                if (!CacheHandler.MAILBOX_TEXT.contains(event.getUser())) {
                    CacheHandler.MAILBOX_TEXT.add(event.getUser());
                }
                event.getChannel().sendMessage(DiscordEmbed.simple("ByteMailbox", Color.BLUE, "Okay let's start with the conversation.\nPlease write after the tone. PIEEEP\n\nTo save the message, you have to confirm with :white_check_mark: !")).complete();
            } else if (event.getReactionEmote().getEmoji().equalsIgnoreCase("\uD83C\uDF99")) {
                event.getChannel().sendMessage(DiscordEmbed.simple("ByteMailbox", Color.BLUE, "The answering machine is being processed by elves, please wait a moment :wink: .")).complete();
                /*AudioManager manager = event.getJDA().getAudioManagers().get(0);
                manager.openAudioConnection();
                event.getUser();*/
            } else System.out.println("EMOJI: " + event.getReactionEmote().getEmoji());
        }
    }

    @Override
    public void onPrivateMessageReactionRemove(@Nonnull PrivateMessageReactionRemoveEvent event) {
        if (CacheHandler.MAILBOX_STATUS) {
            if (event.getReactionEmote().getEmoji().equalsIgnoreCase("\uD83D\uDCE8")) {
                if (CacheHandler.MAILBOX_TEXT.contains(event.getUser())) {
                    CacheHandler.MAILBOX_TEXT.remove(event.getUser());
                }
                event.getChannel().sendMessage(DiscordEmbed.simple("ByteMailbox", Color.BLUE, "Okay I deleted the conversation :disappointed_relieved: !")).complete();
            } else System.out.println("EMOJI: " + event.getReactionEmote().getEmoji());
        }
    }
}
