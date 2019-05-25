/**
 * 
 */
package ECS_Common.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author yueqiulin
 *
 */
public class randomID {
    public static Integer createRandomID() {//head+月日时分+last
    	Calendar date=Calendar.getInstance();
    	String str=(date.get(Calendar.MONTH)+1)+"_"+date.get(Calendar.DAY_OF_MONTH)
    			+"_"+date.get(Calendar.HOUR_OF_DAY)+"_"+date.get(Calendar.MINUTE)+"_"+date.get(Calendar.SECOND);
    	//a.get(Calendar.WEEK_OF_YEAR)
    	String intStr=str.replace("_", "");
    	while(intStr.length()<9) {
    		intStr=intStr+"0";
    	}
    	Integer  s=Integer.valueOf(intStr);
    	return s;
    }
}
