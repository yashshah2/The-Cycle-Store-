package cycstore;
import java.util.*;
import java.io.*;
class dispContents //To display the contents from the file cyclesstore
{
    void read() throws IOException //To Read the contents from the file cyclesstore
    {
       int i;       
       FileInputStream fin;
       fin=new FileInputStream("cyclesstore.txt");
       fin.read();
       i=0;
       do
       {
           i=fin.read();
           if(i!=-1)
           {
               System.out.print((char)i);
           }
       }while(i!=-1);
       fin.close();
       System.out.println("\n");
    }
    void choice() throws IOException //To read the choice of the user and link it to a particular file.
    {
        Scanner inp=new Scanner(System.in);
        String choice;
        
        choice=inp.nextLine(); // asks for the choice in a sentence or a word
        FileOutputStream fout; // object that will write the choice to the file tempfile.
        fout=new FileOutputStream("tempfile.txt");
        char temp[]=choice.toCharArray();
        int i;
        for(i=0;i<choice.length();i++)
        {
            fout.write(temp[i]);
        }
        
        fout.close();
        File fin=new File("tempfile.txt");//opens file both in input and output mode
        boolean found=false;
        boolean found1=false;
        boolean found2=false;
        boolean found3=false;
        BufferedReader br=new BufferedReader(new FileReader(fin)); 
        while((choice=br.readLine())!=null) //Mechanism to search for a particular word from the string of characters.
        {
           if(choice.contains("kids")||choice.contains("Kids")||choice.contains("kid")||choice.contains("child")||choice.contains("KIDS")||choice.contains("KID")||choice.contains("Children")||choice.contains("CHILDREN"))
               found=true;
           else if(choice.contains("mtb")||choice.contains("MTB")||choice.contains("Mountain Terrain Bike")||choice.contains("boys")||choice.contains("Boys")||choice.contains("boy")||choice.contains("BOY")||choice.contains("BOYS")||choice.contains("men")||choice.contains("MEN"))
               found2=true;
         
           else if(choice.contains("girls")||choice.contains("Girls")||choice.contains("girl")||choice.contains("GIRL")||choice.contains("GIRLS")||choice.contains("lady")||choice.contains("LADY")||choice.contains("women")|| choice.contains("WOMEN"))
               found3=true;
        }
       if(found==true)
       {
            System.out.println("found");
            FileInputStream k;
            k=new FileInputStream("kids.txt");
            k.read();
            i=0;
            do
            {
                i=k.read();
                if(i!=-1)
                {
                    System.out.print((char)i);
                }
            }while(i!=-1);
            k.close();            
       }
       else if(found2==true)
       {
            System.out.println("found");
            FileInputStream k;
            k=new FileInputStream("boys.txt");
            k.read();
            i=0;
            do
            {
                i=k.read();
                if(i!=-1)
                {
                    System.out.print((char)i);
                }
            }while(i!=-1);
            k.close();            
       }
       else if(found3==true)
       {
            System.out.println("found");
            FileInputStream k;
            k=new FileInputStream("girls.txt");
            k.read();
            i=0;
            do
            {
                i=k.read();
                if(i!=-1)
                {
                    System.out.print((char)i);
                }
            }while(i!=-1);
            k.close();            
       }
       else
           System.out.println("not found");
    }
}
class transaction 
{
    void buykids(int kidschoice,int kidspurchase[][])throws ArrayIndexOutOfBoundsException
    {
        int i;
        int kids[][]={
                        {1,2800},
                           {2,4900}
                        };
        for(i=0;i<2;i++)
        {
            if(kidschoice==(i+1))
                kidspurchase[i][1]+=kids[i][1];
        }
        
    }
    void buyboys(int boyschoice,int boyspurchase[][])throws ArrayIndexOutOfBoundsException
    {
        int i;
        int boys[][]={{3,5800},
                           {4,8800}};
        for(i=0;i<2;i++)
        {
            if(boyschoice==(i+3))
                boyspurchase[i][1]+=boys[i][1];
        }
    }
    void buygirls(int gchoice,int gpurchase[][])throws ArrayIndexOutOfBoundsException
    {
        int i;
        int girls[][]={{5,4800},
                           {6,5200}};
        for(i=0;i<2;i++)
        {
            if(gchoice==(i+5))
                gpurchase[i][1]+=girls[i][1];
        }
    }
    
}
class bill 
{
    void dispkidsbill(int kpurchase[][])throws ArrayIndexOutOfBoundsException
    {
        int i,j;
       
        System.out.println("\tCycle Code   CycleName");
        for(i=0;i<2;i++)
        {
            for(j=0;j<2;j++)
            {
                if(kpurchase[i][1]!=0||kpurchase[i][1]!='\0')
                    System.out.print("\t     "+kpurchase[i][j]);
            }
            System.out.print("\n");
        }
    }
    void dispboysbill(int bpurchase[][])
    {
        int i,j;
       
        for(i=0;i<2;i++)
        {
            for(j=0;j<2;j++)
            {
                if(bpurchase[i][1]!=0||bpurchase[i][1]!='\0')
                    System.out.print("\t     "+bpurchase[i][j]);
            }
            System.out.print("\n");
        }
    }
    void dispgirlsbill(int gpurchase[][])
    {
        int i,j;
       
        for(i=0;i<2;i++)
        {
            for(j=0;j<2;j++)
            {
                if(gpurchase[i][1]!=0||gpurchase[i][1]!='\0')
                    System.out.print("\t     "+gpurchase[i][j]);
            }
            System.out.print("\n");
        }
    } 
    void tot_amt(int kpurchase[][],int bpurchase[][],int gpurchase[][])
    {
        int i,j;
        int tot=0,GST,SGST,CGST,rate;
        for(i=0;i<2;i++)
        {
            
                if(kpurchase[i][1]!=0||bpurchase[i][1]!=0||gpurchase[i][1]!=0)
                {
                    tot+=(kpurchase[i][1]+bpurchase[i][1]+gpurchase[i][1]);
                }
            
        }
        GST=(tot*12)/112;
        rate=tot-GST;
        SGST=CGST=GST/2;
        System.out.println("The total bill is::"+tot);
        System.out.println("The rate is::"+rate);
        System.out.println("The GST amount is::"+GST);
        System.out.println("The CGST is::"+SGST);
        System.out.println("The SGST is::"+CGST);
    }
}

public class Cycstore
{
    public static void main(String[] args)throws IOException
    {
      
        int choice;
        int kidspurchase[][]={ {1,0},
                           {2,0}};
        int boyspurchase[][]={ {3,0},
                           {4,0}};
        int girlspurchase[][]={ {5,0},
                           {6,0}};
        dispContents obj=new dispContents();
        transaction t=new transaction();
        bill b=new bill();
        Scanner inp=new Scanner(System.in);
        do
        {    
            System.out.println("Which category of cycle would you like to buy::");
            System.out.println("Press 1.Display cycles\n 2.Buy cycle for Kids\n 3.Buy cycle for Boys\n 4.Buy cycle for Girls\n 5.Display bill");
            choice=inp.nextInt();
            switch(choice)
            {
                case 1:obj.read();
                       obj.choice();
                       break;
                case 2:System.out.println("Enter 1.BSA Toonz 14\"\n2.BSA AMBUSH 20\"");
                        int kidschoice=inp.nextInt();
                        if(kidschoice==1||kidschoice==2)
                            t.buykids(kidschoice,kidspurchase);
                        else 
                        {
                            System.out.println("Please enter the correct code::");
                            break;
                        }
                        break;
                case 3:System.out.println("Enter 3.Hero Sprint 20\" \n4.Hercules Rodeo Turner 24\"");
                        int boyschoice=inp.nextInt();
                        if(boyschoice==3||boyschoice==4)
                            t.buyboys(boyschoice,boyspurchase);
                        else
                        {
                            System.out.println("Please enter the correct code::");
                            break;
                        }
                        break;
                case 4:System.out.println("Enter 5.Hero Sprint 20\" \n5.Hercules Rodeo Turner 24\"");
                        int girlschoice=inp.nextInt();
                        if(girlschoice==5||girlschoice==6)
                            t.buygirls(girlschoice,girlspurchase);
                        else
                        {
                            System.out.println("Please enter the correct code::");
                            break;
                        }
                        break;
                case 5:System.out.println("The Final Bill Amount is::");
                       b.dispkidsbill(kidspurchase);
                       b.dispboysbill(boyspurchase);
                       b.dispgirlsbill(girlspurchase);
                       b.tot_amt(kidspurchase,boyspurchase,girlspurchase);
                       break;
                default:System.out.println("invalid choice entered");
            }
            
        }while(choice!=6);
    }
}