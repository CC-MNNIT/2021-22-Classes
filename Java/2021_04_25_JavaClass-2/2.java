class StaticDemo {
    static int a = 42;
    int c;
    static int b = 99;
    static void callme() {
        System.out.println("a = " + a);
    }
}

class StaticByName {
    public static void main(String args[]) {
        StaticDemo.callme();
        StaticDemo a = new StaticDemo();
        StaticDemo b = new StaticDemo();
        int x = a.c;
        int y = StaticDemo.a;

        System.out.println("b = " + StaticDemo.b);
    }
}