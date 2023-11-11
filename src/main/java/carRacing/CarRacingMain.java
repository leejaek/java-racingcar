package carRacing;

import carRacing.car.Cars;
import carRacing.car.CarWinner;
import carRacing.moveStrategy.MoveStrategy;
import carRacing.moveStrategy.RandomMoveStrategy;
import carRacing.view.InputView;
import carRacing.view.ResultView;
import java.util.List;

public class CarRacingMain {

	public static void main(String[] args) {
		InputView input = new InputView();
		List<String> carNames = input.inputCarsName();
		int numberOfAttempts = input.inputAttemptsCount();

		System.out.println("실행 결과");

		ResultView result = new ResultView();
		Cars cars = new Cars(carNames);
		MoveStrategy moveStrategy = new RandomMoveStrategy();


		for (int i = 0; i < numberOfAttempts; i++) {
			cars.moveCars(moveStrategy);
			result.showResult(cars.getCars());
		}

		CarWinner carWinner = new CarWinner();
		result.showWinner(carWinner.makeWinnerList(cars.getCars()));
	}
}
