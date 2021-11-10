package bakaBotSrc.service.command

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import org.json.JSONException
import org.json.JSONObject
import java.net.URL
import java.util.concurrent.ThreadLocalRandom


class Anime {
    var event: GuildMessageReceivedEvent? = null

    constructor(event: GuildMessageReceivedEvent){
        this.event = event
    }

    fun animeGif(args: String){
        if(args.isNullOrEmpty()) event?.channel?.sendMessage("Algo está errado com esse comando, será que você não esqueceu algum parametro?")
        else{
            try {
                val result = URL("https://g.tenor.com/v1/search?key=KQQ12C2BB33&q=${args}").readText()
                val json = JSONObject(result)
                val rnds = (0..20).random()
                val status = json.getJSONArray("results").getJSONObject(rnds).getString("url")
                event?.channel?.sendMessage(status)?.queue()

            } catch (e: JSONException ){

                event?.channel?.sendMessage("Desculpa, mas o gif que voce tentou enviar nao pode ser encontrado. https://tenor.com/view/disappointed-snapped-sad-gif-22165289")?.queue()

            }
        }
    }


}