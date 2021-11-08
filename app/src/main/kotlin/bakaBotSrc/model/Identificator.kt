package bakaBotSrc.model

import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.entities.TextChannel
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent

class Identificator {
    var channel: TextChannel? = null
    var guild: Guild? = null

    constructor(event: GuildMessageReceivedEvent) {
        setChannel(event)
        setGuild(event)
    }

    fun setChannel(event: GuildMessageReceivedEvent){
        channel = event.channel
    }

    fun setGuild(event: GuildMessageReceivedEvent){
        guild = event.guild
    }

}
