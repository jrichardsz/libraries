
package com.linet.util.path;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.linet.util.file.FileUtil;
import com.linet.util.so.OSValidator;

public class PathUtil {

	
	public static String getPathFromWhereApplicationIsRunning() throws Exception {
        String path = null;
        try {
            path = new File(".").getCanonicalPath();
        } catch (IOException ex) {
            throw new Exception("Error when try to get path of app execution.",ex);
        }
        return path;
    }
	
    public static String getWebInfPath() {

        String WEBINF = "WEB-INF";
        String filePath = "";
        URL url = PathUtil.class.getResource("PathUtil.class");
        String className = url.getFile();
        filePath = className.substring(0, className.indexOf(WEBINF) + WEBINF.length());

//        if (url.getProtocol().equals("file")) {
//            filePath = filePath.replaceAll("file:", "");
//        } else if (url.getProtocol().equals("jar")) {
//        }

        filePath = filePath.replaceAll("file:", "");
        if (OSValidator.isWindows()) {
            filePath = filePath.substring(1);
        }
        
        return filePath;

    }
    
    public static String getPathOfGenericAppServer() throws Exception {
    	
    	String pathBin =  getPathFromWhereApplicationIsRunning();
    	String path = FileUtil.backLevelsOfPath(pathBin, 1);
    	return path;
    	
    }
    
    
} 


