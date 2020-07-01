public class TestEq {
    public static void main(String[] args) {
        Empx empx1 = new Empx();
        Empx empx2 = new Empx();
        System.out.println(empx1.equals(empx2));
    }
}
class Empx{
    public  int id;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Empx){
            Empx other = (Empx) obj;
            return this.id == other.id;
        }else{
            return false;
        }
    }
}
