import java.util.*;

public class inn{
  Scanner sc = new Scanner(System.in);
  void i(){
    System.out.println("Here is inn!");
    boolean yarukoto_aru = true;
    while(yarukoto_aru){
      System.out.println("what do you want to do?");
      System.out.println("1.Sleep");//lv up de eta sp wo tukatte status up dekiru
      System.out.println("2.Equip");//soubi wo hennkou dekiru
      System.out.println("3.go back to maintown");
      int input = maintown.mainsc(sc.next(),3);
      System.out.println(" ok!");
      switch(input){
        case 1:
          System.out.println(" good night!");
          break;
        case 2:
          System.out.println(" your equipment is nice!");
          break;
        case 3:
          yarukoto_aru = false;
          break;
      }
      System.out.println("----------");
    }
  }
}
