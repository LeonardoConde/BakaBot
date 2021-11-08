package bakaBotSrc.app

import Env
import bakaBotSrc.model.DaoWrapper
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.OnlineStatus
import javax.security.auth.login.LoginException

/**
 * @author Leonardo de Jesus Diz Conde
 */

class Bot  {
    private var bot : JDABuilder = JDABuilder.createDefault(Env().get("BOT_TOKEN"))

    constructor() {
        bot.addEventListeners(Involker())
        bot.build()
    }

    fun start() {
        DaoWrapper().testConection()
        bot.setStatus(OnlineStatus.ONLINE)
    }
}