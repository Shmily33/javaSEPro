package com.javase;
@FunctionalInterface
public interface MyConsumer<E> {
    void accept(E e);
}
