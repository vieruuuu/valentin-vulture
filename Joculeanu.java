import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

import src.*;

public class Joculeanu extends Ignora {
  public static boolean pitagora(double a, double b, double c) {
    return a * a + b * b == c * c;
  }

  public static void main1(String[] args) {
    System.out.println(testare);

    Scanner in = new Scanner(System.in);

    System.out.printf("baga aici a,b,c laturile unui triunghi: ");

    double latA = in.nextDouble();
    double latB = in.nextDouble();
    double latC = in.nextDouble();

    in.close();

    if (latA + latB <= latC || latA + latC <= latB || latB + latC <= latA) {
      System.out.println("te rog frumos sa imi dai triunghi si tu iti bati joc, sa ti fie rusine");
      return;
    }

    System.out.printf("fun fact: ");
    if (latA == latB && latB == latC) {
      System.out.println("ai un triunghi echilateral");
    } else if (latA == latB && latA != latC || latB == latC && latB != latA || latA == latC && latA != latB) {
      System.out.println("triunghiul tau isoscel");
    } else if (pitagora(latA, latB, latC) || pitagora(latB, latC, latA) || pitagora(latA, latC, latB)) {
      System.out.println("triunghiul tau DREPTUNGHIC WOW ✨");
    } else {
      System.out.println("triunghiul tau e cam basic");
    }

    double semiPerimetru = (latA + latB + latC) / 2;

    double rez = Math.sqrt(semiPerimetru * (semiPerimetru - latA) * (semiPerimetru - latB) * (semiPerimetru - latC));

    System.out.println("rezultat: " + rez);
  }

  /**
   * @param n minut sau secunda
   */
  public static boolean verif(int n) {
    return n >= 0 & n <= 60;
  }

  public static boolean verifOra(int n) {
    return n >= 0 & n <= 24;
  }

  public static void main(String[] args) {
    System.out.println(testare);

    Scanner in = new Scanner(System.in);

    System.out.printf("baga aici vericule ora minut si secunda conectarii: ");

    int oraC = in.nextInt();
    int minC = in.nextInt();
    int secC = in.nextInt();

    System.out.printf("baga aici vericule ora minut si secunda deconectarii: ");

    int oraD = in.nextInt();
    int minD = in.nextInt();
    int secD = in.nextInt();

    in.close();

    if (!verifOra(oraC) || !verifOra(oraD) || !verif(minC) || !verif(minD) || !verif(secC) || !verif(secD)) {
      System.out.println("esti neserios, pa");
      return;
    }

    LocalDateTime rez = LocalDateTime.of(LocalDate.now(), LocalTime.of(oraC, minC, secC));

    System.out.println("s a conectat la: " + rez);

    rez.plusSeconds(secD);
    rez.plusMinutes(minD);
    rez.plusHours(oraD);

    System.out.println("s a deconectat la: " + rez);

  }

}
