package com.virtualassistance.baseclass.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {


        public String getFile(String param) throws IOException

        {
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream(new File("").getAbsolutePath()+File.separator+"PropertiesDataFile.prop");
            prop.load(fis);
            String path = prop.getProperty(param);

            return path;
        }


    // Todo : Implement setbrowser();
    // Todo : Implement geturl();
    // Todo : Implement copydeck(); -- To get the Row and object from prorperties file.
    // Todo : Implement getname();
    // Todo : Implement getlanguage();
    // Todo : Implement getwaittime();
    }


