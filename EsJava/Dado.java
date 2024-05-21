import java.util.*; //importa le classi di java.util tra cui scanner
public class Dado
{
  // variabili di istanza
   private int faccia;
   private String colore;

  // scrivo 2 costruttori (overloading)
  //1 - costruttore
   public Dado()
   {  
     this.faccia=(int)(1+Math.random()*12); //assegna a faccia un numero casuale
   }
    //2 - costruttore di copia
   public Dado(Dado other)
   {
     this.faccia=other.faccia;
     this.colore=other.colore;
   }

   public Dado(String colore)
   {  
     this.faccia=(int)(1+Math.random()*12); //assegna a faccia un numero casuale
     this.colore=colore;
   }

  public Dado(String colore, int range)
   {  
     this.faccia=(int)(1+Math.random()*range); //assegna a faccia un numero casuale
     this.colore=colore;
   }
  
   //getters: ritornano i valori delle variabili di istanza  
   //setters: modificano i valori delle variabili di istanza
   int getFaccia()
   {
     return this.faccia;
   }
   void setFaccia(int faccia)
   {
     this.faccia=faccia;
   }

    String getColore()
    {
      return this.colore;
    }

    void setColore(String colore)
    {
      this.colore=colore;
    }

//metodo toString: ritorna una stringa con le informazioni dell'oggetto
    public String toString()
    {
      return"faccia= "+this.faccia+" colore= "+this.colore;
    }

 // ESERCIZI
//lanciaDieci(): conta quante facce pari escono in 10 lanci di dado
  public int lanciaDieci()
  {
    int conta=0;
   // int numero;
    
    for(int i=0;i<10;i++)
    {
      this.faccia=(int)(1+Math.random()*12);
      if(this.faccia%2==0)
      {
        conta++;
      }
    }
    return conta;
  }

//usaMath(): visualizza il cubo e la radice quadrata di una faccia del dado utilizzando i metodi pow() e sqrt() 

  public String usaMath()
  {
    int RadiceQuadrataFaccia=(int)(Math.sqrt(this.faccia));
    int RadiceCubicaFaccia=(int)(Math.pow((int)this.faccia,3.0));
    return "\t\t"+RadiceQuadrataFaccia+"\t\t\t\t\t\t\t\t"+RadiceCubicaFaccia;
  }
  
//lancia il dado fino a quando non "escono" almeno 3 facce pari e 2 dispari; ritorna il numero di lenci effettuati 
  public int Lancia()
  {
    int facciePari=0;
    int faccieDispari=0;
    int lanci=0;
      while(facciePari<3)
      {
        this.faccia=(int)(1+Math.random()*12);
        if(this.faccia%2==0)
        {
          System.out.println("Pari:"+this.faccia);
          facciePari++;
        }
        lanci++;
      }
    while(faccieDispari<2)
      {
        this.faccia=(int)(1+Math.random()*12);
        if(this.faccia%2!=0)
        {
          System.out.println("Dispari: "+this.faccia);
          faccieDispari++;
        }
        lanci++;
      }
    return lanci;
  }

  public void DadoDa1a6()
  {
    System.out.println("escono due numeri casuali identici\n");
    int FacciaPrima=0;
    this.faccia=(int)(1+Math.random()*5);
    System.out.println(this.faccia+"\n");
    while(FacciaPrima!=this.faccia || this.faccia!=FacciaPrima)
    {
    //  System.out.println(this.faccia+"\n");
      FacciaPrima=this.faccia;
    //  System.out.println(FacciaPrima+"\n");
      this.faccia=(int)(1+Math.random()*5);
     /* System.out.println(FacciaPrima+"\n");*/
      System.out.println(this.faccia+"\n");
      /* System.out.println("FacciaPrima= "+FacciaPrima+"\n");
      System.out.println("Faccia= "+this.faccia+"\n");*/
    /*  this.faccia=(int)(1+Math.random()*5);
      System.out.println(this.faccia+"\n");*/
    }

    System.out.println("TERMINO\n");
  }

  public  void DadoDa0a10()
  {
    int num1=0;
    int num2=0;
    int num3=0;
    int Termino=0;
    while(Termino<=0)
    {
      num1=(int)(Math.random()*10);
      num2=(int)(Math.random()*10);
      num3=(int)(Math.random()*10);
      System.out.println("("+num1+","+num2+","+num3+")");
      if(num1==num2 && num2==num3 && num3==num1 && num1==num3)
      {
        Termino++;
      }
    }
  }

  public void IndovinaDado()
  {
    Scanner tastiera=new Scanner(System.in); 
    int numUtente=0;
    int Tentativo=0;
    this.faccia=(int)(Math.random()*10);
   // System.out.println(this.faccia);
    do
    {
      Tentativo++;
      System.out.println("\ninserisci un numero intero fra 0 e 10: ");
      numUtente=tastiera.nextInt();
      if(numUtente!=this.faccia)
      {
        System.out.println("sbagliato numero");
      }
    }while(numUtente!=this.faccia);
    System.out.println("giusto numero\n\n");
    System.out.println("Tentativi Utente: "+Tentativo);
  }

}
