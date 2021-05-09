import java.util.*;

public class shop{
  Scanner sc = new Scanner(System.in);
  void s(){
    System.out.println(" Here is shop!");
    boolean yarukoto_aru = true;
    while(yarukoto_aru){
      System.out.println(" 1.buy weapons");
      System.out.println(" 2.buy armors");
      System.out.println(" 3.sell item");
      System.out.println(" 4.go back to maintown.");
      int input = maintown.mainsc(sc.next(),4);
      System.out.println(" ok!");
      System.out.println("----------");
      switch(input){
        case 1:
          buy_weapon();
          break;
        case 2:
          buy_armor();
          break;
        case 3:
          sell();
          break;
        case 4:
          yarukoto_aru = false;
          break;
      }
    }
  }

  void buy_weapon(){

  }

  void buy_armor(){

  }

  void sell(){

  }
}
