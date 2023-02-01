/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import com.fang.week4lab_simplenotekeeper.Note;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jifang
 */
public class NoteServlet extends HttpServlet {


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
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String title = br.readLine();
        String content = br.readLine();
        Note note = new Note(title, content);
        request.setAttribute("note", note);
        
        String param = request.getParameter("edit");
        if (param != null) {
            String url = "/WEB-INF/editnote.jsp";
            getServletContext().getRequestDispatcher(url)
                .forward(request, response);
            return;
        }
        
        String url = "/WEB-INF/viewnote.jsp";
        getServletContext().getRequestDispatcher(url)
                .forward(request, response);
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
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        
        // to write to a file
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(
                new FileWriter(path, false)))) {
            pw.println(title);
            pw.println(content);
        }
        
        Note note = new Note(title, content);
        request.setAttribute("note", note);
        String url = "/WEB-INF/viewnote.jsp";
        getServletContext().getRequestDispatcher(url)
                .forward(request, response);
    }

}
