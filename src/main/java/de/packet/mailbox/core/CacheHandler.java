/*
 * Copyright (C) Byte-Store.DE, Inc - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */

package de.packet.mailbox.core;

import net.dv8tion.jda.api.entities.User;

import java.util.ArrayList;

public class CacheHandler {
    public static String TOKEN = "YOUR_TOKEN";
    public static boolean MAILBOX_STATUS = false;

    public static ArrayList<User> MAILBOX_TEXT = new ArrayList<User>();
    public static ArrayList<User> MAILBOX_VOICE = new ArrayList<User>();
}
