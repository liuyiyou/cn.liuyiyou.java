package cn.liuyiyou.java8.test;

import com.asprise.ocr.Ocr;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author: liuyiyou@yanglaoban.com
 * @date: 2018/11/20
 * @version: V1.0
 * @Copyright: 2018 yanglaoban.com Inc. All rights reserved.
 */
public class Yanzhengmashibie {

    public static void main(String[] args) throws TesseractException, IOException {
        File imageFile = new File("C:\\Users\\lyy\\Desktop\\aa\\1.jpg");
        ITesseract instance = new Tesseract();
        String result = instance.doOCR(imageFile);
        System.out.println(result);

//        File file =  new File("C:\\Users\\lyy\\Desktop\\aa\\1.jpg");
//        BufferedImage img = ImageIO.read(file);
//        String result = recognize(img);
//        System.out.println(result);
    }

    public static String recognize(BufferedImage image) {
        Ocr.setUp();
        Ocr ocr = new Ocr();
        ocr.startEngine("eng", Ocr.SPEED_FASTEST);
        String result = ocr.recognize(image,com.asprise.ocr.Ocr.RECOGNIZE_TYPE_ALL, com.asprise.ocr.Ocr.OUTPUT_FORMAT_PLAINTEXT,0,null);
        ocr.stopEngine();
        return result;
    }


}
