import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class tahminOyunu {
    public static void main(String[] args) {
        Random random = new Random();
        int randNumber = random.nextInt(100);
        int selectedNumber;
        int[] wrong = new int[5];
        boolean isWin = false;
        boolean isWrong = false;
        int right = 0;
        Scanner input = new Scanner(System.in);
        while (right < 5) {
            System.out.print("Lütfen tahmininizi giriniz: ");
            selectedNumber = input.nextInt();
            if (selectedNumber < 0 || selectedNumber > 99) {
                System.out.println("Hatalı giriş! Girilen sayı 0 ve 100 aralığında olmalıdır. ");
                if (isWrong) {
                    right++;
                    System.out.println("Çok fazla hatalı giriş yaptınız. Kalan hak : " + (5 - right));
                } else {
                    isWrong = true;
                    System.out.println("Bir sonraki hatalı girişinizde hakkınızdan düşülecektir.");
                }
                continue;
            }
            if (selectedNumber == randNumber) {
                System.out.println("Tebrikler doğru tahmin! Tahmin edilen sayı: " + selectedNumber);
                isWin = true;
                break;
            } else {
                System.out.println("Yanlış tahmin! ");
                if (selectedNumber < randNumber) {
                    System.out.println("Girilen sayı üretilen sayıdan küçük!");
                } else {
                    System.out.println("Girilen sayı üretilen sayıdan büyük!");
                }
                wrong[right++] = selectedNumber;
                System.out.println("Kalan hak: " + (5 - right));
            }

        }
        if (!isWin) {
            System.out.println("Kaybettiniz ! ");
            if (!isWrong) {
                System.out.println("Tahminleriniz : " + Arrays.toString(wrong));
            }
        }
    }
}