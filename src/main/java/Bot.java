import commands.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class Bot {
    public static void main(String[] args) throws Exception {
        JDA jda = new JDABuilder("TOKEN").build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.watching("piss low noobs"));
        jda.addEventListener(new createteams());
        jda.addEventListener(new AFKCheck());
        jda.addEventListener(new move());
        jda.addEventListener(new teams());
    }
}
