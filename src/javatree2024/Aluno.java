
package javatree2024;

public class Aluno implements Comparable<Aluno>{
    private int id;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

     @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        return this.id == other.id;
    }// fim equals

   @Override
   public int compareTo(Aluno outroAluno){
       return 
           Integer.compare(this.id, outroAluno.id);
   }
   @Override
   public String toString(){
       return 
   "Aluno [Nome:"+this.nome+", ID:"+ this.id+"]";
   } 
    
}
