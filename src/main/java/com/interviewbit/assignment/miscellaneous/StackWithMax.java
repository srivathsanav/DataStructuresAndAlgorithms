import java.util.Stack;

/**
 * Created by avsrivathsan on 9/25/2017.
 */
public class StackWithMax {

    private static class ElementWithMax {
        private int element;
        private int maximum;

        public ElementWithMax(int element, int maximum) {
            this.element = element;
            this.maximum = maximum;
        }

        public int getElement() {
            return element;
        }

        public void setElement(int element) {
            this.element = element;
        }

        public int getMaximum() {
            return maximum;
        }

        public void setMaximum(int maximum) {
            this.maximum = maximum;
        }
    }

    private Stack<ElementWithMax> stack = new Stack<>();

    public void push (Integer element) {
        if (!stack.isEmpty()) {
            stack.push(new ElementWithMax(element, Math.max(element, stack.peek().maximum)));
        } else {
            stack.push(new ElementWithMax(element, element));
        }
    }

    public Integer peekMax() {
        if (stack.isEmpty()) {
            throw new IllegalStateException(
                    "Stack is empty");
        }
        return stack.peek().maximum;
    }

    public Integer popMax() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.pop().maximum;
    }

    public Integer pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.pop().element;
    }


    public static void main(String[] args) {
        StackWithMax stackWithMax = new StackWithMax();
        stackWithMax.push(10);
        stackWithMax.push(5);
        stackWithMax.push(12);
        stackWithMax.push(4);
        stackWithMax.push(20);
        stackWithMax.push(18);
        System.out.println(stackWithMax.peekMax());

        System.out.println(stackWithMax.popMax());
        System.out.println(stackWithMax.popMax());
        System.out.println(stackWithMax.popMax());
        System.out.println(stackWithMax.popMax());

        System.out.println(stackWithMax.peekMax());

    }
}
