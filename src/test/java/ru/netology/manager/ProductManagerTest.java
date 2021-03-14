package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smatphone;
import ru.netology.repository.ProductRepository;
import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book firstBook = new Book(1, "Book1", 228, "Author1");
    private Book secondBook = new Book(2, "Book2", 307, "Author2");
    private Smatphone firstSmatphone = new Smatphone(3, "Telephone1", 10, "Manufacturer1");
    private Smatphone secondSmatphone = new Smatphone(4, "Telephone2", 101010101, "Manufacturer2");

    @BeforeEach
    void setUp() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(firstSmatphone);
        manager.add(secondSmatphone);
    }

    @Test
    public void shouldGetAll() {
        Product[] expected = new Product[]{firstBook, secondBook, firstSmatphone, secondSmatphone};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAuthor() {
        Product[] expected = new Product[]{secondBook};
        Product[] actual = manager.searchBy("Author2");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBookName() {
        Product[] expected = new Product[]{firstBook};
        Product[] actual = manager.searchBy("Book1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmatphoneManufacturer() {
        Product[] expected = new Product[]{firstSmatphone};
        Product[] actual = manager.searchBy("Manufacturer1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmatphoneName() {
        Product[] expected = new Product[]{secondSmatphone};
        Product[] actual = manager.searchBy("Telephone2");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        Product[] expected = new Product[] {secondBook, firstSmatphone, secondSmatphone};

        repository.removeById(1);

        assertArrayEquals(expected, repository.findAll());
    }
}