package structural.adapter.inheritance;

public class Adaptor extends Adaptee implements ITarget {

    @Override
    public void f1() {
        super.fa();
    }

    @Override
    public void f2() {
        // 재구현
    }

    @Override
    public void f3() {
        super.fc();
    }
}
