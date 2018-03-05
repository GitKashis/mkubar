
public class Juniorlab {

    //n - сумма цифр числа
    //k - количество цифр в числе

    void num (int n, int k) {
        int count = 0;
        int[] arr = new int[k];

        for (int i = pow(10,k-1); i < pow(10,k); i++) {
            String s = ""+i;

            for (int j = 0; j < k; j++) {
                arr[j] = (int)s.charAt(j);
                System.out.println(arr[j]);
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

    public void test() {
        int[] arr = new int[4];
        String s = "1234";
        for (int j = 0; j < 4; j++) {
            arr[j] = s.charAt(j);
            System.out.println((char)arr[j]);
        }

        int f = Integer.parseInt(String.valueOf((char)arr[0]));
        System.out.println(f);
    }
}
