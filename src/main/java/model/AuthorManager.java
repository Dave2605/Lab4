package model;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Stateless
@Remote
public class AuthorManager {

    @PersistenceContext(unitName = "AuthorEJB")
    private EntityManager entityManager;

    public List<Author> getAuthor() {
        List<Author> authors = entityManager
                .createQuery("select a from Author a")
                .getResultList();
        return authors;
    }

    public Author findAuthor(String name, String birthPlace) throws NoResultException {
        Author author = null;
        if (!name.equals("Author name") && birthPlace.equals("Author birth place")) {
            author = (Author) entityManager
                    .createQuery("select a from Author a where a.name = :name")
                    .setParameter("name", name)
                    .getSingleResult();

        } else if (name.equals("Author name") && !birthPlace.equals("Author birth place")) {
            author = (Author) entityManager
                    .createQuery("select a from Author a where a.birth_place = :birthPlace")
                    .setParameter("birthPlace", birthPlace)
                    .getSingleResult();

        } else if (!name.equals("Author name") && !birthPlace.equals("Author birth place")) {
            author = (Author) entityManager
                    .createQuery("select a from Author a where a.name = :name and a.birth_place = :birthPlace")
                    .setParameter("name", name)
                    .getSingleResult();
        }
        return author;
    }

    public void addAuthor(String name, String birthPlace) {
        Author author = new Author();
        author.setName(name);
        author.setBirth_place(birthPlace);

        entityManager.persist(author);
    }

    public void editAuthor(int id, String name, String birthPlace) {
        entityManager
                .createQuery("update Author a SET birth_place = :birthPlace, name = :name where a.id = :id ")
                .setParameter("id", id)
                .setParameter("name", name)
                .setParameter("birthPlace", birthPlace)
                .executeUpdate();
    }

    public void deleteAuthor(int id) {
        Author author = entityManager.find(Author.class, id);
        entityManager.remove(author);
    }
}
