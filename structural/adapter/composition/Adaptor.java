package structural.adapter.composition;

public class Adaptor implements ITarget {
    private Adaptee adaptee;

    public Adaptor(Adaptee adaptee) {
        this.adaptee = adaptee;
    }


    @Override
    public void f1() {
        adaptee.fa();
    }

    @Override
    public void f2() {
        // 재구현
    }

    @Override
    public void f3() {
        adaptee.fc();
    }
}
