package newpackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Jama.Matrix;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Shaikh
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button button;
    private TextField matrixA_0_0;
    private TextField matrixA_0_1;
    private TextField matrixA_1_0;
    private TextField matrixA_1_1;
    private TextField matrixS_0_0;
    private TextField matrixS_0_1;
    private TextField matrixS_1_0;
    private TextField matrixS_1_1;
    private TextField matrixSS_0_0;
    private TextField matrixSS_0_1;
    private TextField matrixSS_1_0;
    private TextField matrixSS_1_1;
    @FXML
    private TextField noOfSteps;

    double entry_00, entry_01, entry_10, entry_11;
    double entry[] = new double[4];
    int noOfStep, noOfState, n = 0;

    //String filePath;
    //  List<String> pList;
    @FXML
    private TextField noOfStates;
    @FXML
    private GridPane gridPane;
    @FXML
    private Button geneBut;
    @FXML
    private GridPane solution;
    @FXML
    private GridPane steady;

    @FXML
    private void handleButtonAction(ActionEvent event) {
//        System.out.println("You clicked me!");
//        label.setText("Hello World!");

        double[][] transitionProbabilityMatrix = new double[noOfState][noOfState];
        TextField[][] temp = new TextField[noOfState][noOfState];
        TextField[][] temp2 = new TextField[noOfState][noOfState];
        for (int i = 0; i < noOfState; i++) {
            for (int j = 0; j < noOfState; j++) {
                temp[i][j] = (TextField) gridPane.getChildren().get(n++);
                transitionProbabilityMatrix[i][j] = Double.parseDouble(temp[i][j].getText());

            }
        }
        noOfStep = Integer.parseInt(noOfSteps.getText());
//        entry[0] = Double.parseDouble(matrixA_0_0.getText());
//        entry[1] = Double.parseDouble(matrixA_0_1.getText());
//        entry[2] = Double.parseDouble(matrixA_1_0.getText());
//        entry[3] = Double.parseDouble(matrixA_1_1.getText());
//
//        transitionProbabilityMatrix = new double[2][2];               //2x2 ka matrix fix hai
//        for (int i = 0; i < 2; i++) {
//
//            for (int j = 0; j < 2; j++) {
//
//                transitionProbabilityMatrix[i][j] = entry[n];
//                n++;
//            }
//        }
//
//        for (int i = 0; i < 2; i++) {
//
//            for (int j = 0; j < 2; j++) {
//
//                System.out.println(transitionProbabilityMatrix[i][j]);
//                //n++;
//            }
//        }
        Matrix A = new Matrix(transitionProbabilityMatrix);

        Matrix A2 = A;
        //  Matrix B = new Matrix(transitionProbabilityMatrix);
        for (int i = 0; i < noOfStep; i++) {

            A2 = A2.times(A);
        }

        double[][] tempArray = A2.getArrayCopy();

        for (double[] tempArray1 : tempArray) {
            System.out.println(Arrays.toString(tempArray1));
        }

        for (int i = 0; i < noOfState; i++) {
            for (int j = 0; j < noOfState; j++) {
                solution.add(new TextField("" + tempArray[i][j]), i, j);

            }
        }

//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < 2; j++) {
//
//                double v = A2.get(i, j);
//
//                System.out.println(v);
//
//            }
//        }
//
//        //  matrixS_0_0.setText(A2.get(0, 0));        
//        // Double.parseDouble(matrixS_0_0.setText(A2.get(0, 0))) ;
//        matrixS_0_0.setText(String.valueOf(A2.get(0, 0)));
//        matrixS_0_1.setText(String.valueOf(A2.get(0, 1)));
//        matrixS_1_0.setText(String.valueOf(A2.get(1, 0)));
//        matrixS_1_1.setText(String.valueOf(A2.get(1, 1)));
//
        Matrix x;
        Matrix B = A.minus(Matrix.identity(noOfState, noOfState));    //no.of states     //steady state
        for (int i = 0; i < noOfState; i++) {

            B.set(0, i, 1.0);
        }
        Matrix b = new Matrix(noOfState, 1);
        b.set(0, 0, 1.0);
        x = B.solve(b);

        double[][] tempArray2 = x.getArrayCopy();

        for (int i = 0; i < noOfState; i++) {
            for (int j = 0; j < noOfState; j++) {
                steady.add(new TextField("" + tempArray2[i][0]), i, j);

            }
        }

//
////          for (int i = 0; i < 1; i++) {
////            for (int j = 0; j < 1; j++) {
////
////                double v = x.get(i, j);
////
////                System.out.println(v);
////
////            }
////        }
//        matrixSS_0_0.setText(String.valueOf(x.get(0, 0)));
//        matrixSS_0_1.setText(String.valueOf(x.get(0, 0)));
//        matrixSS_1_0.setText(String.valueOf(x.get(1, 0)));
//        matrixSS_1_1.setText(String.valueOf(x.get(1, 0)));
//        x.print(9,6);
//        System.out.println("You clicked me!");
//        label.setText("Hello World!");
// weatherForecast we = new weatherForecast(2 , 4 ,);
        //  System.out.println(transitionProbabilityMatrix[i][j]);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void genertateMatrix(ActionEvent event) {

        noOfState = Integer.parseInt(noOfStates.getText());

        for (int i = 0; i < noOfState; i++) {
            for (int j = 0; j < noOfState; j++) {
                gridPane.add(new TextField(), i, j);
             //   steady.add(new TextField(), i, j);
            }

        }

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        solution.setHgap(10);
        solution.setVgap(10);
        steady.setHgap(10);
        steady.setVgap(10);

    }

}
