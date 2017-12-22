package test.com.company;

import com.company.ILinkedList;
import com.company.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


class LinkedListTest {

    @Test
    void tests() {

        //Initialize
        LinkedList<testClass> testList = new LinkedList<>();
        Predicate<testClass> predicate = (element)->element.value > 0;
        Function<testClass, String> function = element->String.valueOf(element.value);
        Consumer<testClass> consumer = element->element.value--;

        //Fill lists
        testList.add(new testClass(1));
        testList.add(new testClass(3));
        testList.add(new testClass(5));
        testList.add(new testClass(8));
        testList.add(new testClass(15));
        testList.add(new testClass(-5));
        testList.add(new testClass(0));

        //Check
        Assertions.assertFalse(testList.all(predicate));
        Assertions.assertTrue(testList.any(predicate));
        Assertions.assertEquals(1, testList.first(predicate).value);
        Assertions.assertEquals(15, testList.last(predicate).value);
        Assertions.assertEquals(5, testList.count(predicate));
        Assertions.assertNull(testList.single(predicate));

        LinkedList<testClass> filteredList = (LinkedList<testClass>) ((ILinkedList<testClass>) testList).filter(predicate);
        for (testClass element : filteredList) {
            Assertions.assertTrue(0 < element.value);
        }

        testList.removeFirst();
        testList.removeFirst();
        testList.remove(2);
        predicate = (element)->element.value < 0;
        Assertions.assertEquals(-5, testList.single(predicate).value);

        LinkedList<String> stringList = (LinkedList<String>) ((ILinkedList<testClass>) testList).select(function);
        Assertions.assertEquals("5", stringList.find(0));
        Assertions.assertEquals("8", stringList.find(1));
        Assertions.assertEquals("-5", stringList.find(2));

        LinkedList<testClass> consumedList = (LinkedList<testClass>) ((ILinkedList<testClass>) testList).map(consumer);
        Assertions.assertEquals(4, consumedList.find(0).value);
        Assertions.assertEquals(7, consumedList.find(1).value);
        Assertions.assertEquals(-6, consumedList.find(2).value);
    }

    private class testClass {

        int value;

        testClass(int value) {
            this.value = value;

        }
    }

}
