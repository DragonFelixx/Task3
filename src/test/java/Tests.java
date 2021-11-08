import org.junit.Test;
import stack.MyStack;
import stack.stackExceptions.EmptyStackException;
import static org.junit.Assert.*;

public class Tests
{
    @Test
    public void testIsEmpty()
    {
        MyStack<Integer> stack = new MyStack<>();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPush() throws EmptyStackException
    {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(Integer.valueOf(3), stack.peek());
    }

    @Test
    public void testIterator()
    {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int i = 0;
        Integer[] expected = {3, 2, 1};
        for (Integer element : stack)
        {
            assertEquals(expected[i++], element);
        }
    }

    @Test
    public void testBracketsTrue() throws EmptyStackException
    {
        String[] lines = {"[{}]()", "[{}]()", "()", "([]){}", "[]{}", "((()){})", "([{}])"};
        for (String line : lines)
        {
            assertTrue(MyStack.checkCorrectBrackets(line));
        }
    }

    @Test
    public void testBracketsFalse() throws EmptyStackException
    {
        String[] lines = {"({()[)}]", ")(", "())(()", "(", "))])", "(({})", "[{]}"};
        for (String line : lines)
        {
            assertFalse(MyStack.checkCorrectBrackets(line));
        }
    }

    @Test
    public void testClear()
    {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(8);
        stack.push(9);
        stack.clear();
        assertEquals(0, stack.size());
    }
}
