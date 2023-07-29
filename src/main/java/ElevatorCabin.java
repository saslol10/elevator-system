/**
 * Каждая кабина оборудована:
 *      кнопками этажей (20 шт)
 *      кнопкой закрытия дверей
 *      кнопкой открытия дверей
 *      кнопка вызова диспетчера
 *      дисплеем с номером текущего этажа
 *
 * Кабина лифта
 *  Свойства:
 *      Этаж (где находится в данный момент времени кабина) для вывода на
 *      дисплее.
 *      Состояние (едет вверх/едет вниз/открывает двери/закрывает двери/стоит с
 *      открытыми дверьми)
 *  Методы:
 *      Нажать кнопку этажа (1-20)
 *      Нажать кнопку закрытия дверей
 *      Нажать кнопку открытия дверей
 *      Нажать кнопку вызова диспетчера
 *      Датчик кабины фиксирует движение между дверьми
 *      Датчик кабины фиксирует отсутствие движения между дверьми
 */
public class ElevatorCabin {
    private int currentFloor;
    private String state;

//    private int currentWeight;
//
//    private final int MAX_WEIGHT_CAPACITY_1 = 400;
//    private final int MAX_WEIGHT_CAPACITY_2 = 800;

    private final int MAX_FLOOR = 20;

    public ElevatorCabin(int currentFloor) {
        this.currentFloor = currentFloor;
        this.state = "Idle";
    }

    public void pressFloorButton(int targetFloor) {
        if (targetFloor >= 1 && targetFloor <= MAX_FLOOR) {
            System.out.println("Floor button " + targetFloor + " pressed.");
            if (targetFloor == currentFloor) {
                System.out.println("Already on floor " + targetFloor);
                return;
            } else if (targetFloor < currentFloor) {
                state = "Move Down";
            } else {
                state = "Move Up";
            }
            moveCabin(targetFloor);
            currentFloor = targetFloor;
            state = "Opening doors";
            openDoors();
        } else {
            System.out.println("Invalid floor number.");
        }

    }

    public void pressCloseDoorsButton() {
        System.out.println("Close doors button pressed.");
        if (state == "No movement detected") {
            state = "Closing doors";
            closeDoors();
            state = "Idle";
        }
    }

    public void pressOpenDoorsButton() {
        System.out.println("Open doors button pressed.");
        state = "Opening doors";
        openDoors();
    }

    public void pressDispatcherButton() {
        System.out.println("Dispatcher button pressed.");
        state = "Calling Dispatcher";
        System.out.println("Dispatcher is being called...");
    }

    public void cabinMovementDetected() {
        state = "Movement detected";
        System.out.println("Movement detected");
    }

    public void cabinNoMovementDetected() {
        state = "No movement detected";
        System.out.println("No movement detected");
    }

    public void moveCabin(int targetFloor) {
        System.out.println("Cabin is moving...");
        if (state == "Move Down") {
            for (; currentFloor >= targetFloor; currentFloor--)
                System.out.println("Floor " + currentFloor + "...");
            currentFloor++;

        }
        if (state == "Move Up") {
            for (; currentFloor <= targetFloor; currentFloor++)
                System.out.println("Floor " + currentFloor + "...");
            currentFloor--;
        }
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void openDoors() {
        System.out.println("Doors are opening...");
    }

    public void closeDoors() {
        System.out.println("Doors are closing...");
    }
}
