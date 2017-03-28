package controller;

import model.AuthorManager;
import model.BookManager;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "delete", urlPatterns = {"/delete"})
public class Delete extends HttpServlet {

    @EJB
    AuthorManager authorManager;

    @EJB
    BookManager bookManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestType = request.getParameter("type");

        if (requestType.equals("book")) {
            deleteBook(request, response);
        } else if (requestType.equals("author")) {
            deleteAuthor(request, response);
        }
    }
    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        bookManager.deleteBook(id);

        RequestDispatcher view = request.getRequestDispatcher("success.html");
        view.forward(request, response);
    }

    private void deleteAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        authorManager.deleteAuthor(id);

        RequestDispatcher view = request.getRequestDispatcher("success.html");
        view.forward(request, response);
    }
}
