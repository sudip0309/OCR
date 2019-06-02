import java.io.*;

import net.sourceforge.tess4j.*;

public class OCR {

    public String imageToText(String path, String root) throws TesseractException {

        File imageFile = new File(path);
        System.out.println(imageFile);
        Tesseract instance = new Tesseract();
        instance.setDatapath(root + "\\tessdata");
        instance.setLanguage("eng");
        System.out.println(root + "\\tessdata");
        return instance.doOCR(imageFile);
    }

    public static void main(String[] args) throws TesseractException {
        OCR ocr = new OCR();
        String data = ocr.imageToText("web/test-image.png", "web");
        System.out.println(data);
    }

}