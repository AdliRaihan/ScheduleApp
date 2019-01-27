package later.corporation.adliraihan.schedule_app.otherFunctionSchedule_app

import java.text.SimpleDateFormat

class calendarFunction{

    fun getMMMM(MInt:Int):String?{
        when (MInt) {
            1 -> {
                return "January"
            }
            2->{
                return "January"
            }
            3-> {
                return "January"
            }
            4-> {
                return "January"
            }
            5-> {
                return "January"
            }
            6->{
                return "January"
            }
            else -> {
                return "January"
            }
        }
        return null;
    }
    fun getSpecTime(time:Int):String{
        time.apply {
            if(this > 12){
                if(this-12 < 10){
                    return "0${this-12}:00 PM"
                }else{
                    return "${this-12}:00 PM"
                }
            }else if(this < 12){
                return "$this:00 AM"
            }
        }
        return "XX:00 XM"
    }
}