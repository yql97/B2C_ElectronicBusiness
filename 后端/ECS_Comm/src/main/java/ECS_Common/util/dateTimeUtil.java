/**
 * 
 */
package ECS_Common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yueqiulin
 *
 */
public class dateTimeUtil {
	static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     public static String  dateToString(Date d) {
    	 return sdf.format(d);
     }
}
