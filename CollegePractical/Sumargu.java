package CollegePractical;

public class Sumargu {
    public static void main(String[] args) {
        int i, s = 0, ans = 0;
        for (i = 0; i < args.length; i++) {
            s = Integer.parseInt(args[i]);
            ans += s;

            System.out.println("Argument " + i + " as integer: " + s);
        }
        System.out.println("The sum is:" + ans);

    }
}
