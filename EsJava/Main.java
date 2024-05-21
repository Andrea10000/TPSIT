class Main {
  public static void main(String[] args) {
    Dado d1=new Dado("rosso");
    Dado d2=new Dado("rosso", 12);
    Dado d3=new Dado();
   System.out.println("d1 toString() =\n "+d1.toString()+"\n");
    System.out.println("d2 toString() =\n "+d2.toString()+"\n");
    System.out.println("faccia d3 = "+d3.getFaccia());
 //   System.out.println("facce pari d3 = "+d3.lanciaDieci());
//    System.out.println("d3:\nradice quadrata della faccia\tfaccia al cubo\n"+d3.usaMath());
//    System.out.println("d3: lanci effetuati\n"+d3.Lancia());
      d3.DadoDa1a6();
   d3.DadoDa0a10();
    d3.IndovinaDado();
    

  }
}
