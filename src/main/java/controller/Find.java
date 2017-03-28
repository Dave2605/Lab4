package controller;

import model.Author;
import model.AuthorManager;
import model.Book;
import model.BookManager;

import javax.ejb.EJB;
import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "find", urlPatterns = {"/find"})
public class Find extends HttpServlet{

    @EJB
    AuthorManager authorManager;

    @EJB
    BookManager bookManager;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestType = request.getParameter("type");

        if (requestType.equals("book")) {
            findBook(request, response);
        } else if (requestType.equals("author")) {
           findAuthor(request, response);
        }
    }

    private void findBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = null;
        ArrayList<Book> books = new ArrayList<Book>();
        String name = request.getParameter("name");
        String author = request.getParameter("author");

        if (name.isEmpty()) {
            name = "Book name";
        }
        if (author.isEmpty()) {
            author = "Author name";
        }

        try {
            if (name.equals("Book name") && author.equals("Author name")) {
                throw new NoResultException();
            }
            book = bookManager.findBook(name, author);
        } catch (NoResultException e) {
            RequestDispatcher view = request.getRequestDispatcher("error.html");
            view.forward(request, response);
        }
        books.add(book);

        response.setContentType("text/html");
        RequestDispatcher view = request.getRequestDispatcher("showBooks.jsp");
        request.setAttribute("books", books);
        view.forward(request, response);
    }

    private void findAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Author author = null;
        String name = request.getParameter("name");
        String birthPlace = request.getParameter("birthPlace");

        if (name.isEmpty()) {
            name = "Author name";
        }
        if (birthPlace.isEmpty()) {
            birthPlace = "Author birth place";
        }


        try {
            if (name.equals("Author name") && birthPlace.equals("Author birth place")) {
                throw new NoResultException();
            }
            author = authorManager.findAuthor(name, birthPlace);
        } catch (NoResultException e) {
            RequestDispatcher view = request.getRequestDispatcher("error.html");
            view.forward(request, response);
        }
        ArrayList<Author> authors = new ArrayList<Author>();
        authors.add(author);

        response.setContentType("text/html");
        RequestDispatcher view = request.getRequestDispatcher("showAuthors.jsp");
        request.setAttribute("authors", authors);
        view.forward(request, response);
    }
}
