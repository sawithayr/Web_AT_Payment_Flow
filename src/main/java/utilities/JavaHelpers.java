package utilities;

import org.apache.commons.lang.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class JavaHelpers {

    //Data Reader
    /**
     * Get Property value
     * @param String propertyfile property file name
     * @param String propertyname property name
     * @return String property value
     */
    public static String getPropertyValue(String propertyFile, String propertyName)
    {
        Properties prop = accessPropertiesFile(propertyFile);
        String variable = prop.getProperty(propertyName);
        if (variable != null){
            return variable;
        }
        else {
            propertyName = StringUtils.removeEnd(propertyName, "_");
            return prop.getProperty(propertyName);
        }
    }

    /**
     * Access property file
     * @param String propertyfile property file name
     * @return Properties object
     */
    public static Properties accessPropertiesFile(String propertyfile)
    {
        Properties prop = new Properties();
        // try retrieve data from file
        try
        {
            prop.load(new FileInputStream(propertyfile));
        }
        // catch exception in case properties file does not exist
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return prop;
    }
}
