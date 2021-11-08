package bakaBotSrc.model

import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.entities.TextChannel

class MessageManager {
    var channel: TextChannel? = null
    var guild: Guild? = null
    var identificator: Identificator? = null

    constructor(identificator: Identificator) {
        this.identificator = identificator
        this.channel = this.identificator!!.channel
        this.guild = this.identificator!!.guild
    }

    fun send(text: String): Boolean {
        channel?.sendMessage(text)?.queue { }
        return true
    }

    fun delete(): Boolean {

        return true
    }

}