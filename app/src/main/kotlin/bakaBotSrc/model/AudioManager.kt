package bakaBotSrc.model;

import net.dv8tion.jda.api.Permission
import net.dv8tion.jda.api.entities.VoiceChannel
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.managers.AudioManager

class AudioManager {
    var event: GuildMessageReceivedEvent? = null

    constructor(event: GuildMessageReceivedEvent){
        this.event = event
    }

    fun join(): Boolean {
        if(!event?.guild?.selfMember?.hasPermission(event!!.channel, Permission.VOICE_CONNECT)!!) {
            event!!.channel.sendMessage("Bot sem permissao.").queue();
            return false
        }
        val voicechannel: VoiceChannel? = event?.member?.voiceState?.channel
        val connectedChannel = event!!.member!!.voiceState!!.channel
        if(connectedChannel == null) {
            event!!.channel.sendMessage("Voce nao esta conectado ao canal.").queue();
            return false
        }
        val audiomanager: AudioManager? = event?.guild?.audioManager
        if (audiomanager != null) {
            audiomanager.openAudioConnection(voicechannel)
        }
        return true
    }

    fun leave(): Boolean {
        val connectedChannel: VoiceChannel? = event?.guild?.selfMember?.voiceState?.channel
        if (connectedChannel == null) {
            event?.channel?.sendMessage("Bot nao conectado.")?.queue()
            return false
        }
        event?.guild?.getAudioManager()?.closeAudioConnection()
        return true
    }
}
