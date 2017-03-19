package model;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@Remote
public class BookManager {

    @PersistenceContext(unitName = "BookEJB")
    private EntityManager entityManager;

    public List<Book> getBooks() {
        List<Book> books = entityManager
                .createQuery("select b from Book b")
                .getResultList();

        return books;
    }

    public Book findBook(String name, String author) {
        Book book = null;
        if (!name.equals("Book name") && !author.equals("Author name")) {
            book = (Book) entityManager
                    .createQuery("select b from Book b where b.name = :name and b.author = :author")
                    .setParameter("name", name)
                    .setParameter("author", author)
                    .getSingleResult();

        } else if (!name.equals("Book name") && author.equals("Author name")) {
            book = (Book) entityManager
                    .createQuery("select b from Book b where b.name = :name")
                    .setParameter("name", name)
                    .getSingleResult();

        } else if (name.equals("Book name") && !author.equals("Author name")) {
            book = (Book) entityManager
                    .createQuery("select b from Book b where b.author = :author")
                    .setParameter("author", author)
                    .getSingleResult();
        }
        return book;
    }

    public void addBook(String name, String author, String genre) {
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setGenre(genre);

        entityManager.persist(book);
    }

    public void editBook(int id, String name, String author, String genre) {
        entityManager
                .createQuery("update Book b SET name = :name, author = :author, genre = :genre where b.id = :id ")
                .setParameter("id", id)
                .setParameter("name", name)
                .setParameter("author", author)
                .setParameter("genre", genre)
                .executeUpdate();
    }

    public void deleteBook(int id) {
        Book book = entityManager.find(Book.class, id);
        entityManager.remove(book);
    }
}
