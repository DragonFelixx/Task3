package stack;

import stack.stackExceptions.EmptyStackException;

public interface MyStackInterface<T>
{
    boolean isEmpty();
    T peek() throws EmptyStackException;
    T pop() throws EmptyStackException;
    void push(T value);
}
