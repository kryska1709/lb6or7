public class AnimalThread extends Thread {
    private String name;
    private int priority;
    private int metrs = 0; // переменная для определения пройденного расстояния

    public AnimalThread(String name, int priority) { // конструктор класса-наследника Thread
        this.name = name;
        this.priority = priority;
        setPriority(priority);
    }

    @Override
    public void run() { // переопределение метода.(может очистить ресурсы и выполнить иные функции)
        while (metrs < 100) {
            metrs += (int) (Math.random() * 10); // рандомное количество метров при движении от 1 до 10
            System.out.println(name + " пробежал " + metrs + " метров");
        }
        }
    public int getMetrs() {
        return metrs;
    }
}

class RabbitAndTurtle {
    public static void main(String[] args) {
        AnimalThread rabbit = new AnimalThread("Кролик", Thread.MAX_PRIORITY); // объекты класса
        AnimalThread turtle = new AnimalThread("Черепаха", Thread.MIN_PRIORITY); // минимальный приоритет это 1, норма 5, максимальный 10

        rabbit.start(); // вызов метода run
        turtle.start();

        while (rabbit.isAlive() && turtle.isAlive()) {
            if (rabbit.getMetrs() > turtle.getMetrs()) {
                rabbit.setPriority(Thread.MAX_PRIORITY);
                turtle.setPriority(Thread.MIN_PRIORITY);
                System.out.println("Кролик догоняет черепаху, ей стоит поспешить!");
            } else if (turtle.getMetrs() > rabbit.getMetrs()) {
                turtle.setPriority(Thread.MAX_PRIORITY);
                rabbit.setPriority(Thread.MIN_PRIORITY);
                System.out.println("Черепашка оказывается быстрее!");
            }
        }
    }
}