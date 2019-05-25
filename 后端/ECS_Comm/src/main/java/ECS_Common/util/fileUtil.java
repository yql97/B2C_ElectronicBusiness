/**
 * 
 */
package ECS_Common.util;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author yueqiulin
 *
 */
public class fileUtil {
	public static Integer uploadFile(byte[] file, String filePath, String fileName) throws Exception{
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
        return 1;
    }
}
