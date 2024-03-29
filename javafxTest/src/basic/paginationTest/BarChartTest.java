package basic.paginationTest;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.stage.Stage;

public class BarChartTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		// 축 객체 생성
		CategoryAxis xAxis = new CategoryAxis(); // X축 역할
		NumberAxis yAxis = new NumberAxis(); // Y축 역할
		
		// 축 객체를 갖는 BarChart객체 생성
		BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
		
		// 막대 그래프에서 같은 항목의 데이터를 표현하기 위해 Series객체 생성
		// 생성하고 데이터를 셋팅한다.
		XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
		series1.setName("2016년도");
		series1.getData().add(new XYChart.Data<String, Number>("호주", 1234));
		series1.getData().add(new XYChart.Data<String, Number>("한국", 5234));
		series1.getData().add(new XYChart.Data<String, Number>("미국", 834));
		series1.getData().add(new XYChart.Data<String, Number>("영국", 1734));
		series1.getData().add(new XYChart.Data<String, Number>("독일", 3234));
		
		XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();
		series2.setName("2017년도");
		series2.getData().add(new XYChart.Data<String, Number>("호주", 934));
		series2.getData().add(new XYChart.Data<String, Number>("한국", 6234));
		series2.getData().add(new XYChart.Data<String, Number>("미국", 1234));
		series2.getData().add(new XYChart.Data<String, Number>("영국", 1534));
		series2.getData().add(new XYChart.Data<String, Number>("독일", 4334));
		
		XYChart.Series<String, Number> series3 = new XYChart.Series<String, Number>();
		series3.setName("2018년도");
		series3.getData().add(new XYChart.Data<String, Number>("호주", 2934));
		series3.getData().add(new XYChart.Data<String, Number>("한국", 7934));
		series3.getData().add(new XYChart.Data<String, Number>("미국", 2934));
		series3.getData().add(new XYChart.Data<String, Number>("영국", 1934));
		series3.getData().add(new XYChart.Data<String, Number>("독일", 6934));
		
		// 만들어진 Series객체를 Chart에 추가
		bc.getData().addAll(series1, series2, series3);
		
		bc.setTitle("국가별 통계자료"); 	// 차트 제목
		
		bc.setBarGap(3);
		bc.setLegendSide(Side.BOTTOM);
		bc.setLegendVisible(false);
		
		xAxis.setLabel("나라 명");
		yAxis.setLabel("통계 값");
		
		Scene scene = new Scene(bc,800,600);
		
		primaryStage.setTitle("BarChart 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
