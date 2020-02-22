import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;
import java.util.*;
import javafx.geometry.*;

public class HiLoGame extends Application {

   private TextField numberInputField;
   private Button submitButton;
   private Text messageText;
   private int randomNumber;
   private Button newGameButton, clearButton;
   private int min = 1;
   private int max = 100;
   
     
   public void start(Stage primaryStage) {
   
      VBox VBox1 = new VBox();
      VBox1.setStyle("-fx-background-color: purple;");
      VBox1.setSpacing(10);

      randomNumber = (int) (Math.random()*((max - min)+1))+min;
            
      Text numberInputFieldLabel = new Text("Enter a number between 1 and 100 : ");
      VBox1.setAlignment(Pos.CENTER);
		VBox1.getChildren().add(numberInputFieldLabel);
		
		numberInputField = new TextField();
		numberInputField.setOnAction(this::processTextField);
      numberInputFieldLabel.setFont(Font.font(16));
		VBox1.getChildren().add(numberInputField);
		
		submitButton = new Button("Submit Number");
		submitButton.setOnAction(this::processTextField);

      clearButton = new Button("New Game");
      clearButton.setOnAction(this::handleClearButton);
      
      
      HBox buttonBox = new HBox(submitButton, clearButton);
      buttonBox.setAlignment(Pos.CENTER);
		buttonBox.setSpacing(10);
		VBox1.getChildren().add(buttonBox);

      messageText = new Text("");
		messageText.setFont(Font.font(16));
		messageText.setFill(Color.YELLOW);
		VBox1.getChildren().add(messageText);
                       
		Scene scene = new Scene(VBox1, 290, 290);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Hi-Lo Game");
		primaryStage.show();  
             

     }      
     
     private void handleClearButton(ActionEvent event) {
        randomNumber = (int) (Math.random()*((100 - 1)+1))+1;
		  messageText.setText("");
	}

     
     private void processTextField(ActionEvent event) {
		String userInputText = numberInputField.getText();
      int number = Integer.parseInt(userInputText);
		if(number == randomNumber) {
			messageText.setText(" Good guess!! That was the number "+number);
			numberInputField.clear();         
		}
      else if(number > randomNumber){
         messageText.setText("It isn't " + number+ "!! Try a lower number ");
			numberInputField.clear();
      }
      else if(number < randomNumber){
         messageText.setText("It isn't "+ number +"!! Try a higher number ");
			numberInputField.clear();

	}

	}

    public static void main(String[] args) {
        launch(args);
    }
}