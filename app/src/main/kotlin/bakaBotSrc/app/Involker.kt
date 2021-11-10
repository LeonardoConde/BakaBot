package bakaBotSrc.app

import Env
import net.dv8tion.jda.api.events.ReadyEvent
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.slf4j.LoggerFactory
import javax.annotation.Nonnull
import kotlin.Exception

/**
 * @author Leonardo de Jesus Diz Conde
 */

class Involker : ListenerAdapter() {
    private val env = Env()
    private val logger = LoggerFactory.getLogger(this.javaClass)
    private val enviroment = env.get("ENVIRONMENT")
    private lateinit var prefix : String
    private val highLevelCommands = 1
    private val commandsMap: HashMap<String, Long> = hashMapOf(
        "shutdown" to 1
    )

    //Ours functions

    private fun get(source:String) : Long {
        var result = commandsMap[source]
        if(result==null) result = 0
        return result
    }

    fun analyzer(source:String){
        val args = source.split(" ")
        val command = get(args[0])
        if(command>highLevelCommands){
            CommandRouter().router(command,args.subList(1,args.size))
        }
    }

    fun analyzer(source:String, id :Long){
        val args = source.split(" ")
        val command = get(args[0])
        if(id==env.get("MY_ID")?.toLong()){
            CommandRouter().router(command,args.subList(1,args.size))
        }else if(env.get("ENVIRONMENT").equals("tester")){
            val teamSize = env.get("DEV_TEAM_SIZE")
            if(teamSize.isNullOrEmpty() && teamSize!!.toInt()>0){
                for(i in 1..teamSize.toInt()) {
                    if(id==env.get("DEV_ID$i")?.toLong()){
                        CommandRouter().router(command,args.subList(1,args.size))
                    }
                }
            }
        }
    }

    //ListenerAdapter overrides
    override fun onReady(@Nonnull event: ReadyEvent){
        try {
            if(enviroment.equals("prod")){
                prefix = env.get("PROD_PREFIX")!!
            }else if(enviroment.equals("beta")) {
                prefix = env.get("BETA_PREFIX")!!
            }else if(enviroment.equals("tester")) {
                prefix = env.get("DEV_PREFIX")!!
            }else if(enviroment.equals("dev")) {
                prefix = env.get("DEV_PREFIX")!!
            }
        }catch (e : Exception){
            throw Exception("No prefix defined")
        }finally {
            if(prefix.isEmpty()) throw Exception("No prefix defined")
        }
        logger.info("{} is ready!",event.jda.selfUser.asTag)
    }

    override fun onGuildMessageReceived(event: GuildMessageReceivedEvent) {
        val raw = event.message.contentRaw
        if(raw.startsWith(prefix)){
            if(!env.get("ENVIRONMENT").equals("dev") && !env.get("ENVIRONMENT").equals("tester")){
                analyzer(raw.subSequence(prefix.length,raw.length).toString())

            }else{
                analyzer(raw.subSequence(prefix.length,raw.length).toString(),event.author.idLong)
            }
            println(raw.subSequence(prefix.length,raw.length).toString())
        }
    }
}