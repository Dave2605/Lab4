package controller;

import model.Author;
import model.AuthorManager;
import model.Book;
import model.BookManager;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "show", urlPatterns = {"/show"})
public class Show extends HttpServlet{

    @EJB
    BookManager bookManager = new BookManager();

    @EJB
    AuthorManager authorManager = new AuthorManager();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestType = request.getParameter("type");

        if (requestType.equals("book")) {
            showBooks(request, response);
        } else if (requestType.equals("author")) {
            showAuthors(request, response);
        }
    }

    private void showBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookManager.getBooks();

        response.setContentType("text/html");
        RequestDispatcher view = request.getRequestDispatcher("showBooks.jsp");
        request.setAttribute("books", books);
        view.forward(request, response);
    }

    private void showAuthors(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Author> authors = authorManager.getAuthor();

        response.setContentType("text/html");
        RequestDispatcher view = request.getRequestDispatcher("showAuthors.jsp");
        request.setAttribute("authors", authors);
        view.forward(request, response);
    }
}

