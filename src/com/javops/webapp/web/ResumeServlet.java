package com.javops.webapp.web;

import com.javops.webapp.Config;
import com.javops.webapp.model.ContactType;
import com.javops.webapp.model.Resume;
import com.javops.webapp.storage.Storage;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;

public class ResumeServlet extends HttpServlet {
    private Storage storage;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        storage = Config.get().getStorage();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        response.setContentType("text/html: charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        Writer writer = response.getWriter();
        writer.write(
                "<html>" +
                        "<head>" +
                        "    <link rel=\"stylesheet\" href=\"css/style.css\">" +
                        "    <title>List of resumes</title>" +
                        "</head>" +
                        "<body>" +
                        "<section>" +
                        "<table border=\"3\" cellpadding=\"5\" cellspacing=\"0\">" +
                        "    <tr>" +
                        "        <th>Name</th>" +
                        "        <th>Email</th>" +
                        "    </tr>");
        try {
            for (Resume resume : storage.getAllSorted()) {
                writer.write(
                        "<tr>" +
                                "     <td><a href=\"resume?uuid=" + resume.getUuid() + "\">" + resume.getFullName() + "</a></td>" +
                                "     <td>" + resume.getContact(ContactType.MAIL) + "</td>" +
                                "</tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        writer.write("</table>" +
                "</section>" +
                "</body>" +
                "</html>");
    }
}

