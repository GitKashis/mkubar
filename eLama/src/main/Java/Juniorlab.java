
public class Juniorlab {

    //n - сумма цифр числа
    //k - количество цифр в числе

    void num (int n, int k) {
        int count = 0;
        int[] arr = new int[k];

        for (int i = pow(10,k-1); i < pow(10,k); i++) {
            String s = ""+i;
            System.out.println(s);
            for (int j = 0; j < k; j++) {
                arr[j] = s.charAt(s.length() - j - 1);
            }

            if (sum(arr) == n) {
                    count++;
                    System.out.println(String.valueOf(i));
            }
        }
        System.out.println("Found " + count + " numbers.");
    }

    int pow(int a, int b) {
        int result = 1;
        for (int i=1; i<=b; i++){
            result = result*a;
        }
        return result;
    }

    int sum(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        return result;
    }
}
