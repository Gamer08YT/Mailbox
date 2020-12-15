/*
 * Copyright (C) Byte-Store.DE, Inc - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */

package de.packet.mailbox.core;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;

public class DiscordEmbed {
    public static MessageEmbed simple(String titleIO, Color colorIO, String textIO) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle(titleIO, null);
        eb.setColor(colorIO);
        eb.setDescription(textIO);
        return eb.build();
    }

    public static MessageEmbed fileds(String titleIO, Color colorIO, String textIO) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle(titleIO, null);
        eb.setColor(colorIO);
        eb.setDescription(textIO);
        eb.addField("E-Mail", "office@byte-store.de", true);
        eb.addField("Phone", "+49 6173 39190500", true);
        return eb.build();
    }

    public static MessageEmbed thumbnail(String titleIO, Color colorIO, String textIO, String thumbnailIO) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle(titleIO, null);
        eb.setColor(colorIO);
        eb.setDescription(textIO);
        eb.setImage(thumbnailIO);
        return eb.build();
    }

    public static MessageEmbed description(String titleIO, Color colorIO, String textIO, String thumbnailIO, String descriptionIO) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle(titleIO, null);
        eb.setColor(colorIO);
        eb.setDescription(textIO);
        eb.setImage(thumbnailIO);
        eb.setFooter(descriptionIO);
        return eb.build();
    }
}
