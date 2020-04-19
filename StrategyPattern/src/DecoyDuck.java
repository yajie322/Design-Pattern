public class DecoyDuck extends Duck {

    public DecoyDuck() {
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("I'm a decoy duck!");
    }

}
