/**
 * Каждый этаж оборудован:
 *      одной кнопкой вызова: на первом этаже для поднятия вверх, на других этажах – спуска вниз.
 *      2 дисплеями для каждой кабины с информацией, на каком этаже она сейчас находится.
 *
 * Этаж
 *  Свойства:
 *      Текущий этаж кабины 1
 *      Текущий статус кабины 1
 *      Текущий этаж кабины 2
 *      Текущий статус кабины 2
 *      Статус кнопки вызова лифта (вызван/не вызван)
 *  Методы:
 *      Нажать кнопку вызова лифта
 */
public class Floor {
    private int cabin1CurrentFloor;
    private String cabin1Status;
    private int cabin2CurrentFloor;
    private String cabin2Status;
    private boolean elevatorButton;

    public Floor() {
        this.cabin1CurrentFloor = 1;
        this.cabin1Status = "Idle";
        this.cabin2CurrentFloor = 1;
        this.cabin2Status = "Idle";
        this.elevatorButton = false;
    }

    public void pressElevatorButton(int id, int currentFloor, int targetFloor) {
        elevatorButton = true;
        if(cabin1Status == "Idle"){
            ElevatorCabin elevatorCabin1 = new ElevatorCabin(cabin1CurrentFloor);
            if(currentFloor < cabin1CurrentFloor) {
                elevatorCabin1.setState("Move Down");
                elevatorCabin1.moveCabin(currentFloor);
            }
            if(currentFloor > cabin1CurrentFloor) {
                elevatorCabin1.setState("Move Up");
                elevatorCabin1.moveCabin(currentFloor);
            }
            cabin1Status = elevatorCabin1.getState();

            cabin1CurrentFloor = elevatorCabin1.getCurrentFloor();
            elevatorCabin1.openDoors();
            elevatorCabin1.setState("Opening doors");
            elevatorCabin1.cabinMovementDetected();
            System.out.println("Passenger " + id + " entered the elevator 1");
            elevatorCabin1.cabinNoMovementDetected();
            elevatorCabin1.pressCloseDoorsButton();
            elevatorCabin1.pressFloorButton(targetFloor);
            cabin1Status = elevatorCabin1.getState();

            elevatorCabin1.cabinMovementDetected();
            System.out.println("Passenger " + id + " left the elevator 1");
            elevatorCabin1.cabinNoMovementDetected();
            elevatorCabin1.closeDoors();
            elevatorCabin1.setState("Closing doors");
            elevatorCabin1.setState("Idle");
            cabin1CurrentFloor = elevatorCabin1.getCurrentFloor();
            cabin1Status = elevatorCabin1.getState();
            elevatorButton = false;
        }
        else if(cabin2Status == "Idle"){
            ElevatorCabin elevatorCabin2 = new ElevatorCabin(cabin2CurrentFloor);
            if(currentFloor < cabin2CurrentFloor) {
                elevatorCabin2.setState("Move Down");
                elevatorCabin2.moveCabin(currentFloor);
            }
            if(currentFloor > cabin2CurrentFloor) {
                elevatorCabin2.setState("Move Up");
                elevatorCabin2.moveCabin(currentFloor);
            }
            cabin1Status = elevatorCabin2.getState();

            cabin2CurrentFloor = elevatorCabin2.getCurrentFloor();
            elevatorCabin2.openDoors();
            elevatorCabin2.setState("Opening doors");
            elevatorCabin2.cabinMovementDetected();
            System.out.println("Passenger " + id + "entered the elevator 2");
            elevatorCabin2.cabinNoMovementDetected();
            elevatorCabin2.pressCloseDoorsButton();
            elevatorCabin2.pressFloorButton(targetFloor);
            cabin2Status = elevatorCabin2.getState();

            elevatorCabin2.cabinMovementDetected();
            System.out.println("Passenger " + id + "left the elevator 2");
            elevatorCabin2.cabinNoMovementDetected();
            elevatorCabin2.closeDoors();
            elevatorCabin2.setState("Closing doors");
            elevatorCabin2.setState("Idle");
            cabin2CurrentFloor = elevatorCabin2.getCurrentFloor();
            cabin2Status = elevatorCabin2.getState();
            elevatorButton = false;
        }
    }
}
