package commands;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class teams extends AFKCheck{
    private String team1 = "";
    private User [] team1IDs = new User[5];
    private String team2 = "";
    private User [] team2IDs = new User[5];
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().equalsIgnoreCase("!teams")){
            if (getCount() == 10) {
                for (int i = 10; i > 5; i--) {
                    int temp = (int) (Math.random() * i);
                    team1 += " " + getUserIDs().get(temp).toString();
                    team1IDs[i-6] = (getUserIDs().get(temp));
                    getUserIDs().remove(temp);
                }
                for (int j = 0; j < 5; j++) {
                    team2 += " " + getUserIDs().get(j).toString();
                    team2IDs[j] = (getUserIDs().get(j));
                }
                event.getChannel().sendMessage("Team 1: " + team1).queue();
                event.getChannel().sendMessage("Team 2: " + team2).queue();
                team1 = "";
                team2 = "";
            }
            else{
                event.getChannel().sendMessage("We need 10 reactions!").queue();
            }
        }
    }

    public User[] getTeam1IDs(){
        return team1IDs;
    }

    public User[] getTeam2IDs(){
        return team2IDs;
    }
}
