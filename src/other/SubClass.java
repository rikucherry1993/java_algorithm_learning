package other;

public class SubClass extends AbstractClass implements InterfaceClass, InterfaceForDefault{

    private String whoIAm;

    public SubClass(String identity){
        this.whoIAm = identity;
    }

    //method extended from abstract class.
    @Override
    public boolean getFlagFromOutside() {
        return super.getFlag();
    }

    //method implemented from interface class.
    @Override
    public void printIdentity() {
        System.out.println(this.whoIAm);
    }

    //Default Method
    @Override
    public void defaultMethod(){
    }
}
