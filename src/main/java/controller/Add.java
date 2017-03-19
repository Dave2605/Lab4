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

@WebServlet(name = "add", urlPatterns = {"/add"})
public class Add extends HttpServlet{

    @EJB
    AuthorManager authorManager = new AuthorManager();

    @EJB
    BookManager bookManager = new BookManager();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestType = request.getParameter("type");

        if (requestType.equals("book")) {
            addBook(request, response);
        } else if (requestType.equals("author")) {
            addAuthor(request, response);
        }
    }

    private void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String genre = request.getParameter("genre");

        if (name.isEmpty() || author.isEmpty() || genre.isEmpty()) {
            RequestDispatcher view = request.getRequestDispatcher("error.html");
            view.forward(request, response);
        } else {
            bookManager.addBook(name, author, genre);
            RequestDispatcher view = request.getRequestDispatcher("success.html");
            view.forward(request, response);
        }
    }

    private void addAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String birthPlace = request.getParameter("birthPlace");

        if (name.isEmpty() || birthPlace.isEmpty()) {
            RequestDispatcher view = request.getRequestDispatcher("error.html");
            view.forward(request, response);
        } else {
            authorManager.addAuthor(name, birthPlace);
            RequestDispatcher view = request.getRequestDispatcher("success.html");
            view.forward(request, response);
        }
    }
}

