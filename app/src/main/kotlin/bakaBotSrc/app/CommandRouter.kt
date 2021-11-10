package bakaBotSrc.app

import bakaBotSrc.easteregg.Easteregg
import bakaBotSrc.model.AudioManager
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent

class CommandRouter {

    fun router(args:List<String>,event: GuildMessageReceivedEvent){
        println("Router says hi!")
        when(args[0].toLowerCase()){
            "help" -> println("Comando Help")
            "playaudio" -> println("Comando PlayAudio")
            "signup" -> println("Comando SignUP")
            "songgame" -> println("Comando SongGame")
            "join" -> AudioManager(event).join()
            "leave" -> AudioManager(event).leave()
            "livia" -> Easteregg(event).livia()

            else -> {
                println("Comando invalido!")
            }
        }

    }
}