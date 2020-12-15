/*
 * Copyright (C) Byte-Store.DE, Inc - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */

package de.packet.mailbox.core;

import de.bytestore.logger.LoggerIO;
import de.packet.mailbox.handler.*;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.utils.Compression;


public class MailboxBuilder {
    public static LoggerIO loggerIO;

    @lombok.SneakyThrows
    public MailboxBuilder() {
        loggerIO = new LoggerIO("./ByteMailbox/", "latest.log");
        loggerIO.log(LoggerIO.LogType.INFO, "Starting Mailbox ...");

        JDABuilder builder = new JDABuilder(AccountType.CLIENT);
        
        builder.setToken(CacheHandler.TOKEN);

        // Enable the bulk delete event
        builder.setBulkDeleteSplittingEnabled(false);
        // Disable compression (not recommended)
        builder.setCompression(Compression.ZLIB);
        // Enable Auto Reconnect on Timeout
        builder.setAutoReconnect(true);

        builder.addEventListeners(new ReadyHandler());
        builder.addEventListeners(new ChatHandler());
        builder.addEventListeners(new ReactHandler());
        builder.addEventListeners(new TagHandler());
        builder.addEventListeners(new FriendHandler());

        builder.build();
    }
}
