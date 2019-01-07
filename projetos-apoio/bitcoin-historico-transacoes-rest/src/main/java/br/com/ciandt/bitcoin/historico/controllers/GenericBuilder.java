package br.com.ciandt.bitcoin.historico.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Classe Genérica que implementa o pattern Builder.
 * Essa classe pode ser usada para construir qualquer objeto.
 * A mesma foi implementada usando novos recursos da API Java
 * a partir de sua versão 8.
 * Ex: Foo value = GenericBuilder.of(Foo::new)
            .with(Foo::setName, "Otto").with(Foo::setAge, 5).build();
 * @author igorha
 *
 * @param <T>
 */
public class GenericBuilder<T> {

    private final Supplier<T> instantiator;

    private List<Consumer<T>> instanceModifiers = new ArrayList<>();

    public GenericBuilder(Supplier<T> instantiator) {
        this.instantiator = instantiator;
    }

    /**
     * Informe a classe a ser criada pelo Builder
     * Ex: Foo value = GenericBuilder.of(Foo::new).build();
     * @param instantiator
     * @return
     */
    public static <T> GenericBuilder<T> of(Supplier<T> instantiator) {
        return new GenericBuilder<T>(instantiator);
    }

    /**
     * Infome o método a ser chamado para adição de valor no objeto criado pelo Builder.
     * Ex: Foo = value = GenericBuilder.of(Foo::new).with(Foo:setName, "Otto").build();
     * @param consumer
     * @param value
     * @return
     */
    public <U> GenericBuilder<T> with(BiConsumer<T, U> consumer, U value) {
        Consumer<T> c = instance -> consumer.accept(instance, value);
        instanceModifiers.add(c);
        return this;
    }

    /**
     * Método que retorno o objeto criado.
     * Ex: Foo = value = GenericBuilder.of(Foo::new).with(Foo:setName, "Otto").build();
     * 
     * @return
     */
    public T build() {
        T value = instantiator.get();
        instanceModifiers.forEach(modifier -> modifier.accept(value));
        instanceModifiers.clear();
        return value;
    }
}