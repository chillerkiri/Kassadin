package commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class move extends teams {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().equalsIgnoreCase("!move")){
            for (int i = 0; i < 5; i++){
                event.getGuild().moveVoiceMember(event.getGuild().getMember(getTeam1IDs()[i]), event.getGuild().getVoiceChannelById("503300267748360202"));
            }
            for (int j = 0; j < 5; j++){
                event.getGuild().moveVoiceMember(event.getGuild().getMember(getTeam2IDs()[j]), event.getGuild().getVoiceChannelById("503300340146241824"));
            }
        }
    }
}
