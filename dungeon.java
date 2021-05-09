import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class dungeon{
  Scanner sc = new Scanner(System.in);
  String name = "a";
  int pHP = 10;
  int pMP = 10;
  int skill = 0;
  int pATK = 10;
  int pDEF = 10;
  int weapon = 0;
  int head = 0;
  int body = 0;
  int arm = 0;
  int shoes = 0;
  int gold = 0;
  int life = 1;
  int sp = 0;
  int lv = 1;
  int exp = 0;

  int HPMAX = 0;
  int HPnow = 0;
  int MPMAX = 0;
  int MPnow = 0;
  int ATK = 0;
  int DEF = 0;
  int hit = 80;
  int hitted = 90;

  void d(int chara){
    chara_info(chara);
    chara_status();
    chara_info_output();
    System.out.println("");
    System.out.println(" which dungeon do you want to go?");
    System.out.println(" 1.go back to maintown");
    System.out.println(" 2.first-cave");
    int depth = 2;
    int dungeon_name = maintown.mainsc(sc.next(),depth);
    if(dungeon_name == 1){
      return;
    }
    //dungeon load
    System.out.println("");
    System.out.println(" -----"+"first-cave.");
    dungeon(dungeon_name,chara);
  }

  void chara_info(int chara){
    File f = new File("character.txt");
    try(Scanner scf = new Scanner(f)){
      scf.useDelimiter(",");
      for(int i = 0;i<chara;i++){
        scf.nextLine();
      }
      name = scf.next();
      pHP = scf.nextInt();
      HPMAX = pHP;
      pMP = scf.nextInt();
      MPMAX = pMP;
      skill = scf.nextInt();
      pATK = scf.nextInt();
      ATK = pATK;
      pDEF = scf.nextInt();
      DEF = pDEF;
      weapon = scf.nextInt();
      head = scf.nextInt();
      body = scf.nextInt();
      arm = scf.nextInt();
      shoes = scf.nextInt();
      gold = scf.nextInt();
      life = scf.nextInt();
      sp = scf.nextInt();
      lv = scf.nextInt();
      exp = scf.nextInt();

    }catch(IOException e){
      System.out.println(" character file ga naide!!!");
      System.exit(0);
    }
    return;
  }

  void chara_status(){
    hit = 80;
    hitted = 90;
    //weapon
    File f = new File("weapon.txt");
    try(Scanner scf = new Scanner(f)){
      scf.useDelimiter(",");
      for(int i = 0;i<weapon;i++){
        scf.nextLine();
      }
      String trash = scf.next();
      int atk_weapon = scf.nextInt();
      ATK += atk_weapon;
      hit += scf.nextInt();
    }catch(IOException e){
      System.out.println(" reigai! reigai!");
    }
    //head
    chara_equipment_status("head.txt",head);
    //body
    chara_equipment_status("body.txt",body);
    //arm
    chara_equipment_status("arm.txt",arm);
    //shoes
    chara_equipment_status("shoes.txt",shoes);
  }

  void chara_equipment_status(String file_name,int num){
    File f = new File(file_name);
    try(Scanner scf = new Scanner(f)){
      scf.useDelimiter(",");
      for(int i = 0;i<num;i++){
        scf.nextLine();
      }
      String trash = scf.next();
      System.out.println(trash);
      int def_armor = scf.nextInt();
      DEF += def_armor;
      hitted += scf.nextInt();
    }catch(IOException e){
      System.out.println(" soubi no file ga naintyau!?");
      System.exit(0);
    }
  }

  void chara_info_output(){
    System.out.println("");
    System.out.println(" name: "+name);
    System.out.println("   Lv: "+lv);
    System.out.println("   HP: "+HPMAX);
    System.out.println("   MP: "+MPMAX);
    System.out.println("  ATK: "+ATK);
    System.out.println("  DEF: "+DEF);
  }

  void dungeon(int dungeon_number,int chara){
    int input = 0;
    Scanner sc = new Scanner(System.in);
    int depth = 1;
    int floor = 0;
    int last_time = 200;
    //dungeon_number kara yomitoru
    last_time += lv;
    while(true){
      System.out.println(" last time is "+last_time);
      System.out.println("");
      System.out.println(" 1.go deeper. time_cost:2");
      System.out.println(" 2.go back to town. time_cost:"+(floor*5+depth));
      input = maintown.mainsc(sc.next(),2);
      int cost = 2;
      if(input == 2){
        cost = floor*5+depth;
        last_time = time_calculate(last_time,cost,chara);
        System.out.println("you could have come hometown.");
        return;
      }
      last_time = time_calculate(last_time,cost,chara);
      battle();
      System.out.println("----------");
    }
  }

  int time_calculate(int time, int cost, int chara){
    time-=cost;
    if(time <= 0){
      System.out.println(" you become monster.");
      System.out.println(" GAME OVER");
      System.exit(0);
    }
    return time;
  }

  void battle(){
    monstar_spon();
    int me = 0;
    int you = 0;
    attack(me);
    attack(you);
  }

  void monstar_spon(){

  }

  void attack(int attacker){

  }
}
