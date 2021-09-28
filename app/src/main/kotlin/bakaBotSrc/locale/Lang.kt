package bakaBotSrc.locale

class Lang {
    var langs : HashMap<String, Id> = hashMapOf(
        "PtBr" to Id.PtBr,
        "EnUs" to Id.EnUs
        )

    fun get(lang:String,source:String): String? {
        val idLang = langs[lang]
        var result : String? = null
        if(idLang!=null && source.isNotBlank()){
            result = get( idLang, source)
        }
        return result
    }

    fun get(lang:Id,source:String) : String? {
        return when(lang) {
            Id.PtBr -> PtBr().get(source)
            Id.EnUs -> EnUs().get(source)
        }
    }

    enum class Id{
        PtBr,
        EnUs
    }
}
