package design_patterns.memento;

public class Client {

    /**
     * des: 场景：某个对象的部分属性作备忘录，以供后世查看
     *     Originator: 发起人。修改备忘录状态。
     *     Memento:备忘录。
     *     CareTaker: 管理备忘录，不能修改备忘录，负责存储和恢复。
     * @param
     */
    public static void main(String[] args) {
        Originator originator  = new Originator();
        CareTaker careTaker = new CareTaker();

        careTaker.addMemento(originator.saveStateToMemento("step1"));
        originator.setState("step2");
        originator.setState("step3");
        originator.restoreStateFromMemento(careTaker.getMemento(0));
        System.out.println(originator.getState());
    }
}
