package bakaBotSrc.model

import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.entities.TextChannel
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent

class Identificator {
    var channel: TextChannel? = null
    var guild: Guild? = null

    constructor(c: TextChannel, g: Guild) {
        setChannel(c)
        setGuild(g)
    }

    @JvmName("setChannel1")
    fun setChannel(c: TextChannel) {
        channel = c
    }

    @JvmName("getChannel1")
    fun getChannel(): TextChannel? {
        return channel
    }

    @JvmName("setGuild1")
    fun setGuild(g: Guild) {
        guild = g
    }

    @JvmName("getGuild1")
    fun getGuild(): Guild? {
        return guild
    }

}
