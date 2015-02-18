package juices;
import java.io.*;
import java.util.*;
class Print implements Runnable{
    private Sort [] sort;
    public Print (Sort [] sort){
        this.sort=sort;
        new Thread(this).start();
    }
    public void run(){
        Arrays.sort(sort,new FruitComparator());
        try{
            BufferedWriter writer=new BufferedWriter(new FileWriter("juice2.out"));
            for(Sort S:sort){
                writer.write(S.fruit+"\n");
            }
            writer.close();
        }
        catch (IOException e){
            System.out.print("Error"+e);}
    }
}
class Sort{
    String fruit;
    int countFruit;
    public Sort(String fruit){
        this.fruit=fruit;
    }
    public int getFruit(){
        return countFruit;
    }
    public Sort(){
        fruit=null;
    }
 }
class FruitComparator implements Comparator<Sort>{
    public int compare(Sort o1,Sort o2){
        return ((Sort)o1).fruit.compareToIgnoreCase(((Sort)o2).fruit);
    }
}
class CountComparator implements Comparator<Sort>{
    public int compare(Sort o1,Sort o2){
        int count1=o1.getFruit();
        int count2=o2.getFruit();
        if(count1>count2)
            return 1;
        else if(count1<count2)
            return -1;
        else{
            return 0;
        }
    }
}
public class Juices {
class Juice{
    int countFruit=0;
    class Fruit{
       String fruit;
       Fruit(){
           fruit=null;
       }
    }
    Fruit [] fruit=new Fruit[20];
}
Juice [] juice=new Juice[20];
int count=0;
int n=0;//количество соков
String [] juices=new String[400];
ArrayList <String> Al=new ArrayList<String>();
Sort [] sortOfFruits;
Sort [] sortOfCount;
String [] components=new String[20];

public void readerFile(FileReader file){
    BufferedReader br=new BufferedReader(file);
    try{
        int kol_vo=0;
        while(br.ready()){
            juice[count]=new Juice();
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            int countFr=0;
            while(st.hasMoreTokens()){
                juice[count].fruit[countFr]=juice[count].new Fruit();
                juice[count].fruit[countFr].fruit=st.nextToken();
                juices[kol_vo]=juice[count].fruit[countFr].fruit;
                kol_vo++;
                countFr++;
            }
            juice[count].countFruit=countFr;
            n++;
            count++;
        }
        count=kol_vo;
        br.close();
    }
    catch (IOException e){
        System.out.print("Error"+e);
    }
}
public void delete_duplicate(){
    int count1=count;
    for(int i=0;i<count;i++){
        for(int j=i+1;j<count;j++){
            if(juices[i].equals(juices[j])==true){
                for(int k=j;k<count;k++)
                    juices[k]=juices[k+1];
                count--;
            }
        }
     Al.add(juices[i]);  
    }
    count=count1;
}
public void sort(){
    sortOfFruits=new Sort[count];
    /*for(int i=0;i<count;i++){
        sortOfFruits[i]=new Sort();
        sortOfFruits[i].fruit=juices[i];
    }*/
    int N=0;
    for(int i=0;i<n;i++){
        for(int j=0;j<juice[i].countFruit;j++){
          sortOfFruits[N]=new Sort(); 
          sortOfFruits[N].fruit=juice[i].fruit[j].fruit;
          N++;
        }
    }
    new Print(sortOfFruits);
}
public void sortByCount(){
    for(int i=0;i<n;i++){
        components[i]=" ";
        for(int j=0;j<juice[i].countFruit;j++)
        components[i]=juice[i].fruit[j].fruit+" "+components[i];
    }
sortOfCount=new Sort[n];
for(int i=0;i<n;i++){
    sortOfCount[i]=new Sort();
    sortOfCount[i].countFruit=juice[i].countFruit;
    sortOfCount[i].fruit=components[i];
}
Arrays.sort(sortOfCount,new CountComparator());
//for(int i=0;i<n;i++)
    //System.out.println(sortOfCount[i].fruit);
}
public void solve(){
    int index=0;
    int i1=0;
    int i;
    int min=0;
    String minOfCount;
    for(i=0;i<n;i++){
        if((sortOfCount[i].fruit.indexOf(sortOfCount[index].fruit)!=-1)&&(index!=i)){
            sortOfCount[index].fruit=sortOfCount[i].fruit;
            for(int j=i;j<n;j++){
                if(j==n-1)
                    sortOfCount[j].fruit=sortOfCount[j].fruit;
                else 
                    sortOfCount[j].fruit=sortOfCount[j+1].fruit;
            }
            n--;
            i1=i;
            i=0;
        }
        if (i1==n-1)
            min++;
        if(i==n-1){
            min++;
            sortOfCount[index].fruit=sortOfCount[i].fruit;
            for(int j=i;j<n;j++){
                if(j==n-1)
                sortOfCount[j].fruit=sortOfCount[j].fruit;
                else
                    sortOfCount[j].fruit=sortOfCount[j+1].fruit;
            }
            n--;
            i1=i;
            i=0;
        }
    }
    min++;
    Al.clear();
    minOfCount=Integer.toString(min);
    Al.add(minOfCount);
    //System.out.println(min);
}
 public void printFile(FileWriter file){
     Iterator iterator=Al.iterator();
     try{
         BufferedWriter writer=new BufferedWriter(file);
         while(iterator.hasNext()){
             writer.write(iterator.next()+"\n");
         }
         writer.close();
     }
     catch (IOException e){
         System.out.print("Error"+e);
     }
}  
    public static void main(String[] args) {
        Juices juices=new Juices();
        FileReader file;
        try{
            file = new FileReader("E:\\Juices\\juice.in");
            juices.readerFile(file);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        juices.delete_duplicate();
        FileWriter file1;
        try{
            file1=new FileWriter("juice1.out");
            juices.printFile(file1);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        juices.sort();
        juices.sortByCount();
        juices.solve();
        FileWriter file3;
        try{
            file3=new FileWriter("juice3.out");
            juices.printFile(file3);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
