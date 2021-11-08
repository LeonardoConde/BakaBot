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

    fun update(sqlCommand:String, args: Array<Any>?):Boolean{
        var ok = true;
        try {
            if(con!=null){
                //val stmt: Statement = con!!.createStatement()
                //stmt.executeUpdate(sqlCommand);
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
            ok =false;
        }
        return ok
    }

    fun testConection() {
        //logger.info("{} is ready!",con)
    }
}