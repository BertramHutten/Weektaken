package helloworld;



public class Studenttest {

    public String naam;
    private int studentnummer;  

    Studenttest( String s, int l) {
        naam = s;
        studentnummer = l;        
    }


    

    public void getNaam() {
        System.out.println("Dit is student " + naam);
  
}
    public void getStudentnummer(){
        System.out.println("Met studentnummer " + studentnummer);

    

    
    }
}

