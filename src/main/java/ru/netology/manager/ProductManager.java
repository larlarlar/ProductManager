package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smatphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product item) {
        repository.save(item);
    }

    public Product[] getAll() {
        return repository.findAll();
    }





    private boolean matches(Product product, String search) {
        if (product.getName().equalsIgnoreCase(search)) {
            return true;
        }
        if (product instanceof Book) {
            var book = (Book) product;
            return book.getAuthor().equalsIgnoreCase(search);
        }
        if (product instanceof Smatphone) {
            var phone = (Smatphone) product;
            return phone.getManufacturer().equalsIgnoreCase(search);
        }
        return false;
    }
}
