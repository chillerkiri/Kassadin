package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageEmbedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.ArrayList;

import java.awt.*;

public class AFKCheck extends ListenerAdapter {
    private String messageID = "";
    private int count = 0;
    private ArrayList<User> userIDs = new ArrayList<User>();

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().equalsIgnoreCase("!afkcheck")){
            event.getChannel().sendMessage("<@&522599772104818696>").queue();
            EmbedBuilder embed = new EmbedBuilder();
            embed.setColor(Color.MAGENTA);
            embed.setDescription("React with ✅ if you are able participate in the customs game");
            embed.setTitle("<:YOFEMADCUTE:679162411306975233>" + event.getAuthor().getName() + " initiated the AFK check!");
            embed.setImage("https://cdn.discordapp.com/attachments/521157391165947906/678447100266151976/88bcdb2b74f4ded8948e1abf470f5e2c.png");
            event.getChannel().sendMessage(embed.build()).complete().addReaction("✅").queue();
        }
    }

    public void onMessageEmbed(MessageEmbedEvent eve){
        messageID = eve.getMessageId();
    }

    public void onMessageReactionRemove (MessageReactionRemoveEvent ev){
        if (ev.getMessageId().equals(messageID)){
            if(ev.getReactionEmote().getEmoji().equals("✅")) {
                count--;
                if (userIDs.contains(ev.getUser())){
                    userIDs.remove(userIDs.indexOf(ev.getUser()));
                }
            }
        }
    }

    public void onMessageReactionAdd (MessageReactionAddEvent e) {
        if (e.getMessageId().equals(messageID)){
            if(e.getReactionEmote().getEmoji().equals("✅")) {
                count++;
                userIDs.add(e.getUser());
            }
        }
        if (count == 10){
            e.getChannel().sendMessage("10 counts have been reached!").queue();
        }
    }

    public ArrayList<User> getUserIDs(){
        return userIDs;
    }

    public int getCount(){
        return count;
    }
}
