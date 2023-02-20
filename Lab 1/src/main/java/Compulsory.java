public class Compulsory {
    private static int sum(int result){
        int sum = 0;
        while(result != 0){
            sum += result % 10;
            result /= 10;
        }
        return sum;
    }
    public static void main(String[] args){
        System.out.println("Hello World");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1000000);
        n *= 3;
        n += Integer.parseInt("10101", 2);
        n += Integer.parseInt("FF", 16);
        n *= 6;
        int result = sum(n);
        while(result > 9){
            result = sum(result);
        }
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }
}
