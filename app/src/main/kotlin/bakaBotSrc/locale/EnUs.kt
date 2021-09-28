package bakaBotSrc.locale
class EnUs {
    var strings: HashMap<String,String> = hashMapOf(
        "sample" to "Sample"
    )

    fun get(source:String):String? {
        return strings[source]
    }
}
