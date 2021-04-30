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
        a.a = 50;
        a.c = 10;
        StaticDemo b = new StaticDemo();
        b.c = 20;
        a.callme();
        System.out.println("c from a = " + a.c);
        System.out.println("c from b = " + b.c);

        System.out.println("b = " + StaticDemo.b);
        System.out.println("a = " + b.a);
    }
}
