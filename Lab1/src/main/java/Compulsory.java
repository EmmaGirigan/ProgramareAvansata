public class Compulsory {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n *= 3;
        n += Integer.parseInt("10101", 2);
        n += Integer.parseInt("FF",16);
        n *= 6;
        int result = sum(n);
        while(result > 9){
            result = sum(result);
        }
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }
    private static int sum(int number) {
        int sum = 0;
        while (number != 0)
        {
            sum = sum + number % 10;
            number = number/10;
        }
        return sum;
    }
}