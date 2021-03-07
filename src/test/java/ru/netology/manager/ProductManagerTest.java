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

    private Product firstBook = new Book(1, "Book1", 228, "Author1");
    private Product secondBook = new Book(2, "Book2", 307, "Author2");
    private Product firstSmatphone = new Smatphone(3, "Telephone1", 10, "Manufacturer1");
    private Product secondSmatphone = new Smatphone(4, "Telephone2", 101010101, "Manufacturer2");

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
    public void shouldFindBook() {

        Product[] actual = manager.searchBy("Book1");
        Product[] expected = new Product[]{firstBook};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindSmatphone() {
        Product[] actual = manager.searchBy("Telephone2");
        Product[] expected = new Product[]{secondSmatphone};
        assertArrayEquals(expected, actual);
    }
}