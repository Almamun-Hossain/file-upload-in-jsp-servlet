package com.fileupload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //fetch data form url
            String name = request.getParameter("filename");
            String path = getServletContext().getRealPath("/" + "files" + File.separator + name);

            File dwFile = new File(path);
            if (dwFile.exists()) {
                
                // gets MIME type of the file
                String mimeType = getServletContext().getMimeType(path);
                if (mimeType == null) {
                    // set to binary type if MIME mapping not found
                    mimeType = "APPLICATION/OCTET-STREAM";
                }
                response.setContentType("APPLICATION/OCTET-STREAM");
                response.setContentLength((int) dwFile.length());
                
                response.setHeader("Content-Disposition", "attachment; filename=\""+dwFile.getName()+"\"");

                FileInputStream in = new FileInputStream(dwFile);

                //byte[] buffer = new byte[in.available()];
                
                int i;
                while((i=in.read())!= -1){
                    out.write(i);
                }
                in.close();
                out.close();
            } else {
                out.println("file not available");
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
