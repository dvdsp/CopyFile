/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


/**
 *
 * @author DELL
 */
public class Library {
    

    public static void readFileConfig() {
        File propertiesFile = new File("config.properties");
        Properties prop = new Properties();
        if (propertiesFile.exists()) {
            boolean checkFileConfig = Validate.checkFileConfig(propertiesFile);
            if (checkFileConfig == false) {
                System.out.println("System shutdown!");
                return;
            } else {
                try {
                    FileReader reader = new FileReader(propertiesFile);
                    prop.load(reader);
                    Validate.copyFolder(prop.getProperty("COPY_FOLDER"), prop.getProperty("PATH"));
                    reader.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            System.out.println("File configure is not found!");
            Validate.createFileConfig(propertiesFile, prop);
            readFileConfig();
        }
    }

    
    public static boolean checkInformationConfig(File f1, File f2) {
        boolean checkInformationConfig = f1.exists() && f1.isDirectory()
                && f2.exists() && f2.isDirectory();
        if (f1.exists() == false || f1.isDirectory() == false) {
            System.err.println("Can't find folder Sourse");
        }
        if (f2.exists() == false || f2.isDirectory() == false) {
            System.err.println("Can't make folder Destination");
        }
        return checkInformationConfig;
    }

    

    public static void copyFile(String file, String folder) {
        File f1 = new File(file);
        File f2 = new File(folder);
        if (f1.exists() && f1.isFile() && f2.exists() && f2.isDirectory()) {
            try {
                FileInputStream fis = new FileInputStream(f1);
                FileOutputStream fos = new FileOutputStream(folder + "/" + f1.getName());
                int b;
                while ((b = fis.read()) != -1) {
                    fos.write(b);
                }
                fis.close();
                fos.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
}
