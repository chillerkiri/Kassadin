package commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class createteams extends ListenerAdapter {
    private String teamA = "";
    private String teamB = "";
    public void onGuildMessageReceived (GuildMessageReceivedEvent event){
        String [] collection = event.getMessage().getContentRaw().split(" ");
        List<String> teammates = new ArrayList<String>(Arrays.asList(collection));
        if (teammates.get(0).equalsIgnoreCase("!createteams")){
            if (teammates.size() != 11){
                event.getChannel().sendMessage("Please input the names of 10 players").queue();
            }
            else{
                teammates.remove(0);
                for (int i = 10; i > 5; i--){
                    int temp = (int)(Math.random()*i);
                    teamA += " " + teammates.get(temp);
                    teammates.remove(temp);
                }
                for (int j = 0; j < 5; j++){
                    teamB += " " + teammates.get(j);
                }
                event.getChannel().sendMessage("Team A: "+ teamA).queue();
                event.getChannel().sendMessage("Team B: " + teamB).queue();
                teamA = "";
                teamB = "";
            }
        }
    }
}
