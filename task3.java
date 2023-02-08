package HW4;

// import java.util.Arrays;
// import java.util.Deque;
// import java.util.List;
import java.util.Stack;

public class task3 {
    // Дана строка содержащая только символы '(', ')', '{', '}', '[' и ']',
    // определите,
    // является ли входная строка логически правильной.
    // Входная строка логически правильная, если:
    // 1) Открытые скобки должны быть закрыты скобками того же типа.
    // 2) Открытые скобки должны быть закрыты в правильном порядке. Каждая
    // закрывающая скобка имеет соответствующую
    // открытую скобку того же типа.
    // ()[] = true
    // () = true
    // {[()]} = true
    // ()() = true
    // )()( = false

    public static void main(String[] args) {

        String s = new String("())(");
        System.out.println(isValid(s));

    }

    public static boolean isValid(String s) {
        int n = s.length();
        if (n == 0)
            return true;
        if (n % 2 == 1)
            return false;

        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                st.push(c);
            } else if (st.isEmpty()) {
                return false;
            } else {

                char prev = st.pop();
                switch (c) {
                    case '}':
                        if (prev != '{')
                            return false;
                        else
                            break;
                    case ']':
                        if (prev != '[')
                            return false;
                        else
                            break;
                    case ')':
                        if (prev != '(')
                            return false;
                        else
                            break;
                }
            }
        }
        return st.isEmpty();
    }
}
