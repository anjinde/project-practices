package com.example.demo.algorithm.memento;

import java.util.Objects;
import java.util.Optional;

public class ThreadLocalStorage<T> implements Storage<T> {
    protected final ThreadLocal<Memento<T>> cache = new ThreadLocal<>();


    @Override
    public Optional<Memento<T>> getMemnto() {
        return Optional.of(cache.get());
    }

    @Override
    public void setMemnto(Memento<T> memnto) {
        Objects.requireNonNull(memnto, "memnto can not be null");
        cache.set(memnto);
    }
}
