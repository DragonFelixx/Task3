package stack;

import java.util.HashMap;
import java.util.Iterator;
import stack.stackExceptions.*;

public class MyStack<T extends Comparable<T>> implements MyStackInterface<T>, Iterable<T>
{
    private static class StackNode<T>
    {
        public T value;
        public StackNode<T> next;

        public StackNode(T value, StackNode<T> next)
        {
            this.value = value;
            this.next = next;
        }
    }

    private StackNode<T> head = null;
    private int size = 0;

    @Override
    public void push(T value)
    {
        head = new StackNode<>(value, head);
        size++;
    }

    @Override
    public T peek() throws EmptyStackException
    {
        throwEmptyStackException();
        return head.value;
    }

    @Override
    public T pop() throws EmptyStackException
    {
        T value = peek();
        head = head.next;
        size--;
        return value;
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    public void clear()
    {
        head = null;
        size = 0;
    }

    public int size()
    {
        return size;
    }

    public Iterator<T> iterator()
    {
        class MyLinkedStackIterator implements Iterator<T>
        {
            StackNode<T> curr;

            public MyLinkedStackIterator(StackNode<T> head)
            {
                curr = head;
            }

            @Override
            public boolean hasNext()
            {
                return curr != null;
            }

            @Override
            public T next()
            {
                T result = curr.value;
                curr = curr.next;
                return result;
            }
        }
        return new MyLinkedStackIterator(head);
    }

    public static boolean checkCorrectBrackets(String line) throws EmptyStackException
    {
        boolean result = false;
        HashMap<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');

        char[] charArray = line.toCharArray();
        MyStack<Character> stuck = new MyStack<>();
        for (char ch : charArray)
        {
            if (ch == '(' || ch == '{' || ch == '[')
            {
                stuck.push(ch);
            }
            if (ch == ')' || ch == '}' || ch == ']')
            {
                if (!stuck.isEmpty())
                {
                    if (stuck.peek() == brackets.get(ch))
                    {
                        stuck.pop();
                    }
                    result = stuck.isEmpty();
                }
                else
                {
                    result = false;
                }
            }
        }
        return result;
    }

    private void throwEmptyStackException() throws EmptyStackException
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
    }
}
