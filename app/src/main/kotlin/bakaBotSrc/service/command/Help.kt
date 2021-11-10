package bakaBotSrc.service.command

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent

class Help {
    var event: GuildMessageReceivedEvent? = null

    constructor(event: GuildMessageReceivedEvent){
        this.event = event
    }

    fun sendHelp(){
        event?.channel?.sendMessage("```Os seguintes comandos podem ser executados: : " +
                "\n !join: O bot entra no canal de voz" +
                "\n !leave: O bot sai do canal de voz" +
                "\n !help: Mostra os comandos possiveis para o bot```"
        )?.queue()

    }
}