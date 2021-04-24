package ru.netology.MangerTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Domain.PurchaseItem;
import ru.netology.Manager.Manager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ManagerTest {

        private Manager manager = new Manager();
        private PurchaseItem first = new PurchaseItem(1, 1, "first", 1, 1);
        private PurchaseItem second = new PurchaseItem(2, 2, "second", 2, 2);
        private PurchaseItem third = new PurchaseItem(3, 3, "third", 3, 3);


        @BeforeEach
        public void SetUp() {
            manager.add(first);
            manager.add(second);
            manager.add(third);

        }


        @Test
        public void shouldRemoveIfExists() {
            int idToRemove = 1;
            manager.removeById(idToRemove);

            PurchaseItem[] actual = manager.getAll();
            PurchaseItem[] expected = new PurchaseItem[]{third, second};


            assertArrayEquals(expected, actual);
        }


        @Test
        public void shouldNotRemoveIfNotExists() {
            int idToRemove = 3;

            manager.removeById(idToRemove);

            PurchaseItem[] actual = manager.getAll();
            PurchaseItem[] expected = new PurchaseItem[]{second, first};

            assertArrayEquals(expected, actual);
        }

    }



