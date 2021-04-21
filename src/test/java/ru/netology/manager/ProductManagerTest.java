package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book it = new Book(1, "It", 800, "Stephen King");
    private Book fightClub = new Book(2, "Fight Club", 400, "Chuck Palahniuk");
    private Smartphone iPhone12 = new Smartphone(3, "iPhone 12", 84900, "Apple");
    private Smartphone galaxyS21 = new Smartphone(4, "Galaxy S21", 72400, "Samsung");

    @BeforeEach
    public void setUp() {
        manager.add(it);
        manager.add(it);
        manager.add(iPhone12);
    }


    @Test
    public void shouldSaveOneItem() {
        manager.add(fightClub);

        Product[] expected = new Product[]{it, it, iPhone12, fightClub};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneBook() {
        manager.searchBy("It");

        Product[] expected = new Product[]{it, it};
        Product[] actual = manager.searchBy("It");
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotFindOneSmartphone() {
        manager.searchBy("iPhone 12");

        Product[] expected = new Product[] {};
        Product[] actual = manager.searchBy("Galaxy S21");
        assertArrayEquals(expected, actual);
    }

}