import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet(urlPatterns = "/OCR")
public class Convert extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("This is  Convert Servlet!!!!");
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart) {
            // Create a factory for disk-based file items
            FileItemFactory factory = new DiskFileItemFactory();
            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                // Parse the request
                List /* FileItem */ items = upload.parseRequest(request);
                Iterator iterator = items.iterator();
                while (iterator.hasNext()) {
                    FileItem item = (FileItem) iterator.next();
                    if (!item.isFormField()) {
                        String fileName = item.getName();

                        String root = this.getServletContext().getRealPath(File.separator);
                        System.out.println(root);

//                        String root = "D:\\Projects\\java-ocr\\OCR\\web\\images\\uploads";

                        System.out.println(root);
                        System.out.println("Filename " + fileName);
                        File path = new File(root + "images\\uploads\\");
                        if (!path.exists()) {
                            boolean status = path.mkdirs();
                        }
                        File uploadedFile = new File(path + "/" + fileName);
                        System.out.println("Absolute Path = " + uploadedFile.getAbsolutePath());
                        item.write(uploadedFile);
                        String uploadFile = uploadedFile.getAbsolutePath().replace("/", "//");
                        String convertedText = new OCR().imageToText(uploadedFile.getAbsolutePath(),root);
                        System.out.println("==========================");
                        System.out.println(convertedText);
                        System.out.println("==========================");
                        String[] words = uploadFile.split("\\\\");
                        System.out.println(words[words.length - 1]);
                        request.setAttribute("image", "images\\uploads\\" + words[words.length - 1]);
                        request.setAttribute("result", convertedText);
                        request.getRequestDispatcher("/display.jsp").forward(request, response);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }

}