import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class maintown{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    // class yobidasi
    dungeon dungeon = new dungeon();
    shop shop = new shop();
    inn inn = new inn();
    String choice[] = new String[4];
    choice[1] = "dungeons";
    choice[2] = "shop";
    choice[3] = "inn";

    //data kannri
    System.out.println("");
    System.out.println(" 1.start new game");
    System.out.println(" 2.load a data");
    int input = mainsc(sc.next(),2);

    //chara senntaku
    int chara_amount = 0;
    int chara = 2;
    File f = new File("character.txt");
    try(Scanner scf = new Scanner(f)){
      scf.useDelimiter(",");
      chara_amount = scf.nextInt();
    }catch(IOException e){
      System.out.println(" There is no character save file.");
      System.out.println(" Please make the 'character.txt' file.");
      System.exit(0);
    }
    if(input == 1){
      make_chara();
    }else if(input == 2){
      System.out.println("");
      System.out.println(" Input the character ID.");
      chara = mainsc(sc.next(),chara_amount);
      System.out.println("");
      dungeon.chara_info(chara);
      dungeon.chara_info_output();
    }

    //maintown
    while(true){
      System.out.println("");
      System.out.println(" -----maintown");
      System.out.println(" 1.dungeons");
      System.out.println(" 2.shop");
      System.out.println(" 3.inn");
      System.out.println(" 4.end the game");
      input = mainsc(sc.next(),4);
      if(input < 4){
          System.out.println("");
          System.out.println(" ok! let's go to "+choice[input]+"!");
          System.out.println(" ----------");
          switch(input){
            case 1:
              dungeon.d(chara);
              break;
            case 2:
              shop.s();
              break;
            case 3:
              inn.i();
              break;
          }
      }else{
        System.out.println(" ok. See you!");
        System.exit(0);
      }
    }
  }

  //nyuuryoku
  public static int mainsc(String s, int num){
    Scanner sc = new Scanner(System.in);
    int ans = 0;
    int snum = 100000000;
    try{
      snum = Integer.parseInt(s);
    }catch(NumberFormatException e){
      System.out.println(" It is wrong input. One more please.");
      ans = mainsc(sc.next(),num);
      return ans;
    }
    if(snum == 0){
      System.out.println(" It is wrong input. One more please.");
      ans = mainsc(sc.next(),num);
    }else if(snum == 99999){
      System.out.println(" ok. See you!");
      System.exit(0);
    }else if(snum <= num){
      ans = snum;
    }else{
      System.out.println(" It is wrong input. One more please.");
      ans = mainsc(sc.next(),num);
    }
    return ans;
  }

  //chara making
  public static void make_chara(){
    Scanner sc = new Scanner(System.in);
    File f = new File("character.txt");
    System.out.println(" Let's make a new character!");
    System.out.println(" who are you?");
    boolean ok = true;
    while(ok){
      String name = sc.next();
      if(name.length()<=30){
        System.out.println(" ok!");
        //character kakikomi
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(f,true))){
          bw.newLine();
          bw.write(name);
          bw.write(",20,10,0,5,5,0,0,0,0,0,100,1,2,1,0,");
        }catch(IOException e){
          System.out.println(" maybe character file is not there.");
          System.exit(0);
        }
        //chara_amount kakikomi (muzui node atomawasi)
        System.out.println(" your data was recorded!");
        ok = false;
      }else{
        System.out.println(" it's too long!");
      }
    }
    return;
  }
}
