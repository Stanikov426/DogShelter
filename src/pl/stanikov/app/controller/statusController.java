package pl.stanikov.app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import pl.stanikov.app.main.Cat;
import pl.stanikov.app.main.Dog;
import pl.stanikov.app.main.Main;

public class statusController implements Initializable {
	private Stage stage;

	@FXML
    private Label dataLabel;

    @FXML
    private TableView<Dog> dogTable;

    @FXML
    private TableColumn<Dog, String> dogName;

    @FXML
    private TableColumn<Dog, String> dogRasa;

    @FXML
    private TableColumn<Dog, String> dogId;

    @FXML
    private TableView<Cat> catTable;

    @FXML
    private TableColumn<Cat, String> catName;

    @FXML
    private TableColumn<Cat, String> catRasa;

    @FXML
    private TableColumn<Cat, String> catId;

    @FXML
    private Button backButton;
    
    @FXML
    void backClick(ActionEvent event) throws IOException {
    	stage = (Stage) backButton.getScene().getWindow();
        Parent root;
        root = (Parent) FXMLLoader.load(getClass().getResource("/pl/stanikov/app/view/MainPane.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
		stage.show();
        System.out.println("opened");
    }

	public void setCatTable(TableView<Cat> catTable) {
		this.catTable = catTable;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//Dogs Table
		dogName.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getPetName()));
		dogRasa.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getPetRasa()));
		dogId.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getPetId()));
		
		dogTable.setItems(getDogList());
		
		dogTable.setRowFactory(tv -> {
            TableRow<Dog> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Dog rowData = row.getItem();
                    Main.setPomDog(rowData);
                    Main.setPom(true);
                    System.out.println("Double click on: "+rowData.getPetName());
                    
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/pl/stanikov/app/view/adoptionPane.fxml"));
                                Parent root1 = (Parent) fxmlLoader.load();
                                Stage stage = new Stage();
                                stage.setScene(new Scene(root1));  
                                stage.show();
                        } catch(Exception e) {
                           e.printStackTrace();
                          }
                }
            });
            return row ;
        });
		
		//Cats Table
		catName.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getPetName()));
		catRasa.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getPetRasa()));
		catId.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getPetId()));
		
		catTable.setItems(getCatList());
		
		catTable.setRowFactory(tv -> {
            TableRow<Cat> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Cat rowData = row.getItem();
                    Main.setPomCat(rowData);
                    Main.setPom(false);
                    System.out.println("Double click on: "+rowData.getPetName());
                    
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/pl/stanikov/app/view/adoptionPane.fxml"));
                                Parent root1 = (Parent) fxmlLoader.load();
                                Stage stage = new Stage();
                                stage.setScene(new Scene(root1));  
                                stage.show();                             
                        } catch(Exception e) {
                           e.printStackTrace();
                          }
                }
            });
            return row ;
        });
	}
	
	 private ObservableList<Dog> getDogList() {
		  ObservableList<Dog> dogsList = FXCollections.observableArrayList();
	      ArrayList<Dog> dogs = Main.getDogs();
	      for (Dog num : dogs) {
	            dogsList.add(num);
	        }
	      	 
	      return dogsList;
	  }
	 private ObservableList<Cat> getCatList() {
		  ObservableList<Cat> catsList = FXCollections.observableArrayList();
	      ArrayList<Cat> cats = Main.getCats();
	      for (Cat num : cats) {
	            catsList.add(num);
	        }
	      	 
	      return catsList;
	  }
}
