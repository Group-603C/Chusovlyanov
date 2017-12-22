package com.company;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface ILinkedList <T> {

    Iterable<T> filter(Predicate<T> predicate);
    ILinkedList<T> map(Consumer<T> function);
    <TResult> ILinkedList<TResult> select(Function<T, TResult> predicate);

    int count(Predicate<T> predicate);

    T first(Predicate<T> predicate);
    T last(Predicate<T> predicate);
    T single(Predicate<T> predicate);

    boolean all(Predicate<T> predicate);
    boolean any(Predicate<T> predicate);
}
