import io.github.cdimascio.dotenv.dotenv

class Env {
    private val env = dotenv()

    fun get(envVar:String): String? {
        return env.get(envVar)
    }
}