public class Main {

    public static void main(String[] args) {

        Cake cake;
        for (int i = 1; i <= 32; i++) {
             cake = new Cake();
            System.out.println("Serving cake for " + String.valueOf(i) + ", cake left " + String.valueOf(cake.serveCake(i)));
        }
    }
}
