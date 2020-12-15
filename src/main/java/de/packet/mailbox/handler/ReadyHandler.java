/*
 * Copyright (C) Byte-Store.DE, Inc - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */

package de.packet.mailbox.handler;

import de.bytestore.logger.LoggerIO;
import de.packet.mailbox.core.MailboxBuilder;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class ReadyHandler extends ListenerAdapter {
    @Override
    public void onReady(@Nonnull ReadyEvent event) {
        MailboxBuilder.loggerIO.log(LoggerIO.LogType.SUCCESS, "Hey i'am ready for work !");
    }
}
