package bakaBotSrc.app

import bakaBotSrc.easteregg.Easteregg
import bakaBotSrc.model.AudioManager
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import bakaBotSrc.service.command.Help
import bakaBotSrc.service.command.Anime
import java.util.*


class CommandRouter {
    fun router(args:List<String>,event: GuildMessageReceivedEvent){
        println("Router says hi!")
        try{
            when(args[0].lowercase(Locale.getDefault())){
                "help" -> Help(event).sendHelp()
                "playaudio" -> println("Comando PlayAudio")
                "signup" -> println("Comando SignUP")
                "songgame" -> println("Comando SongGame")
                "join" -> AudioManager(event).join()
                "leave" -> AudioManager(event).leave()
                "livia" -> Easteregg(event).livia()
                //o comando acima é uma referancia criada pelo kahao,
                //o grupo não tem nd haver com os objetivos desse comando
                "anime" -> {
                    if(args[1].isNullOrEmpty()) throw Exception()
                    Anime(event).animeGif(args[1])
                }
                else -> {
                    println("Comando invalido!")
                    event?.channel?.sendMessage("Não conheço esse comando, estamos falando a mesma lingua?")?.queue()
                }
            }
        }catch (e:Exception){
            event?.channel?.sendMessage("Algo está errado com esse comando, será que você não esqueceu algum parametro?")?.queue()
        }
    }
}