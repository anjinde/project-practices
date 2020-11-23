package com.example.demo.algorithm.memento;

import java.util.Optional;

public interface Storage<T> {
    Optional<Memento<T>> getMemnto();
    void setMemnto(Memento<T> memnto);
}
