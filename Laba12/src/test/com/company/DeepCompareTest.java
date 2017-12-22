package test.com.company;

import com.company.DeepCompare;
import com.company.IDeepCompare;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeepCompareTest {

    private IDeepCompare comparator = new DeepCompare();

    @Test
    void nullPointer() {

        PublicField<Integer> firstObject = null;
        PublicField<Integer> secondObject = null;
        PublicField<Integer> thirdObject = new PublicField<>(16);

        Assertions.assertTrue(comparator.deepEquals(firstObject, secondObject));
        Assertions.assertFalse(comparator.deepEquals(firstObject, thirdObject));
    }

    @Test
    void privateField() {

        PrivateField firstObject = new PrivateField(43, 'b');
        PrivateField secondObject = new PrivateField(34, 'b');
        PrivateField thirdObject = new PrivateField(43, 'b');

        Assertions.assertFalse(comparator.deepEquals(firstObject, secondObject));
        Assertions.assertTrue(comparator.deepEquals(firstObject, thirdObject));
    }

    @Test
    void cyclicLinks() {

        Cyclic firstObject = new Cyclic();
        Cyclic secondObject = new Cyclic(firstObject);
        Cyclic thirdObject = new Cyclic(secondObject);

        firstObject = secondObject;

        Assertions.assertFalse(comparator.deepEquals(firstObject.getField(), thirdObject.getField()));
    }

    @Test
    void publicField() {

        String valueString = "Test";
        int valueInt = 12;
        PublicField<String> firstObject = new PublicField<>(valueString+valueInt);
        PublicField<String> secondObject = new PublicField<>(valueString+valueInt);
        PublicField<String> thirdObject = new PublicField<>("Test");

        Assertions.assertTrue(comparator.deepEquals(firstObject.getValue(), secondObject.getValue()));
        Assertions.assertFalse(comparator.deepEquals(firstObject.getValue(), thirdObject.getValue()));
    }

    @Test
    void compareStrings() {

        String left = "";
        left += "One";
        left += "two";
        StringBuilder right = new StringBuilder();

        right.append("On").append("e").append("tw").append("o");
        Assertions.assertTrue(comparator.deepEquals(left, right.toString()));

        right.append("4");
        Assertions.assertFalse(comparator.deepEquals(left, right.toString()));
    }
}
