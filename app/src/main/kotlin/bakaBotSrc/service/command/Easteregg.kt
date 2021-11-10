package bakaBotSrc.service.command

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent

class Easteregg {
    var event: GuildMessageReceivedEvent? = null

    constructor(event: GuildMessageReceivedEvent){
        this.event = event
    }

    fun livia(){
        event?.channel?.sendMessage("https://tenor.com/view/i-love-livia-i-love-you-livia-gif-20398101")?.queue()
    }
}