package bakaBotSrc.model

import Env
import org.slf4j.LoggerFactory
import java.sql.*
import java.util.*


class DaoWrapper {
    private val logger = LoggerFactory.getLogger(this.javaClass)
    var con: Connection? = null

    constructor(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://"+Env().get("DB_URL")+
                    "?user="+Env().get("DB_USERNAME")+"&password="+Env().get("DB_PASSWORD"))
        } catch (ex: SQLException) {
            System.out.println("SQLException: " + ex.message);
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    fun testConection() {
        logger.info("{} is ready!",con)
    }

    fun update(sqlCommand:String, args: List<Any>? = null):Boolean{
        var ok = true;
        try {
            if(con!=null){
                val stmt = con!!.prepareStatement(sqlCommand) as PreparedStatement
                if(args!=null){
                    for ((index, value) in args.withIndex()) {
                        stmt.setString(index+1, args[index].toString())
                    }
                }
                stmt.execute()
                stmt.close()
            }else{
                ok=false;
            }
        }catch (e:Exception){
            println(e.message)
            ok =false;
        }
        return ok
    }

    fun getList(sqlCommand:String, args: List<Any>? = null):ResultSet?{
        var rs : ResultSet? = null
        try{
            if(con!=null){
                val stmt = con!!.prepareStatement(sqlCommand) as PreparedStatement
                if(args!=null){
                    for ((index, value) in args.withIndex()) {
                        stmt.setString(index+1, args[index].toString())
                    }
                }
                rs = stmt.executeQuery()
                stmt.close()
            }

        }catch (e: Exception){
            println(e.message)
        }
        return rs;
    }



}