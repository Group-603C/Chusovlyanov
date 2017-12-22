package com.company;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class DeepCompare implements IDeepCompare {

    private ArrayList<Object> objectToCheck = new ArrayList<>();

    @Override
    public boolean deepEquals(Object left, Object right) {

        if (left == right) {
            return true;
        }

        if (null == left || null == right) {
            return false;
        }

        if (left.getClass() != right.getClass()) {
            return false;
        }

        if (objectToCheck.indexOf(left) != -1 || objectToCheck.indexOf(right) != -1) {
            return false;
        }

        if (left.getClass() == Byte.class) {
            return (Byte) left == (Byte) right;

        } else if (left.getClass() ==Short.class) {
            return (Short) left == (Short) right;

        } else if (left.getClass() ==Integer.class) {
            return (int) left == (int) right;

        } else if (left.getClass() ==Long.class) {
            return (long) left == (long) right;

        } else if (left.getClass() ==Float.class) {
            return (float) left == (float) right;

        } else if (left.getClass() ==Double.class) {
            return (double) left == (double) right;

        } else if (left.getClass() ==Boolean.class) {
            return (boolean) left == (boolean) right;

        } else if (left.getClass() ==Character.class) {
            return (char) left == (char) right;

        }

        objectToCheck.add(left);
        objectToCheck.add(right);

        if (left.getClass().isArray()) {

            if (Array.getLength(left) != Array.getLength(right)) {
                remove(left, right);
                return false;
            }
            for (int i = 0; i < Array.getLength(left); i++) {
                if (!deepEquals(Array.get(left, i), Array.get(right, i))) {
                    remove(left, right);
                    return false;
                }
            }
        } else {
            for (Field field : left.getClass().getDeclaredFields()) {

                try {
                    field.setAccessible(true);
                    if (!deepEquals(field.get(left), field.get(right))) {
                        remove(left, right);
                        return false;
                    }

                } catch (IllegalAccessException ignored) {
                }
            }
        }
        remove(left, right);

        return true;
    }

    private void remove(Object left, Object right) {
        objectToCheck.remove(left);
        objectToCheck.remove(right);
    }

}
