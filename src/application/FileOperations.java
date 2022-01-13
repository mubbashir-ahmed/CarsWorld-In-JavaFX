package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class FileOperations {
	AlertBoxes ab = new AlertBoxes();
	
	boolean isTrue = false;
	public boolean LoginFileRead(String user, String pass, String fileName) {
		//this method performs a login verification from the logindatabase file
		try {
			Scanner scan = new Scanner(new File(fileName));
			while(scan.hasNext()) {
				String tempUser = user;
				String tempPass = pass;
				String checkUser = scan.next();
				String checkPass = scan.next();
				if(tempUser.equals(checkUser) && tempPass.equals(checkPass)) {
					isTrue = true;
				}
			}
			scan.close();
		} catch(FileNotFoundException e) {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setTitle("An Error Occured!");
        	errorAlert.setHeaderText(null);
        	errorAlert.setContentText("Oops! An error occured. Sorry for your inconvinence.");
        	errorAlert.showAndWait();
		}
		return isTrue;
	}
	
	public void FileWrite(String[] carBrandStr, String[] carModelStr, String[] carCategoryStr, String[] carYearStr, String[] carPriceStr, String FileName, boolean append) {
		//this method writes data in the file
		try {
			FileWriter fw = new FileWriter(new File(FileName), append);
			BufferedWriter bw = new BufferedWriter(fw);
			for(int i = 0; i < carBrandStr.length; i++) {
				bw.write(carBrandStr[i] + "," + carModelStr[i] + "," + carCategoryStr[i] + "," + carYearStr[i] + "," + carPriceStr[i] + "\n");
			}
			bw.close();
		} catch(IOException e) {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setTitle("An Error Occured!");
        	errorAlert.setHeaderText(null);
        	errorAlert.setContentText("Oops! An error occured. Sorry for your inconvinence.");
        	errorAlert.showAndWait();
		}
	}
	
	public void FeedBackFileWrite(String[] feedback, String FileName, boolean append) {
		//this method writes data in the file
		try {
			FileWriter fw = new FileWriter(new File(FileName), append);
			BufferedWriter bw = new BufferedWriter(fw);
			for(int i = 0; i < feedback.length; i++) {
				bw.write(feedback[i] + "\n");
			}
			bw.close();
		} catch(IOException e) {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setTitle("An Error Occured!");
        	errorAlert.setHeaderText(null);
        	errorAlert.setContentText("Oops! An error occured. Sorry for your inconvinence.");
        	errorAlert.showAndWait();
		}
	}
	
	public void DeleteDuplicateData(String FileName) {
		//this method deletes duplicate data from the file
		try {
			String input = null;
			File tempFile = new File(FileName);
			File inputFile = new File("cardetails.txt");
			Scanner sc = new Scanner(tempFile);
			FileWriter fw = new FileWriter(inputFile, false);
			Set<String> set = new HashSet<String>();
			while (sc.hasNextLine()) {
				input = sc.nextLine();
				if(set.add(input)) {
					fw.append(input + "\n");
				}
			}
			fw.flush();
			sc.close();
			fw.close();
		} catch (Exception e) {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setTitle("An Error Occured!");
        	errorAlert.setHeaderText(null);
        	errorAlert.setContentText("Oops! An error occured. Sorry for your inconvinence.");
        	errorAlert.showAndWait();
        	e.printStackTrace();
		}
	}
	
	public void SortFileData(String FileName) {
		//this method sorts data in the file
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FileName));
			ArrayList<String> str = new ArrayList<>();
			String line = "";
			while((line = reader.readLine()) != null) {
				str.add(line);
			}
			reader.close();
			Collections.sort(str);
			FileWriter writer = new FileWriter("tempcardetails.txt");
			for(String s: str){
					writer.write(s);
					writer.write("\r\n");
			}
			writer.close();
			DeleteDuplicateData("tempcardetails.txt");
		} catch (Exception e) {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setTitle("An Error Occured!");
        	errorAlert.setHeaderText(null);
        	errorAlert.setContentText("Oops! An error occured. Sorry for your inconvinence.");
        	errorAlert.showAndWait();
        	e.printStackTrace();
		}
	}
	
	public void ArrayToQueue(Queue<String> carBrandQueue, Queue<String> carModelQueue, Queue<String> carCategoryQueue, Queue<String> carPriceQueue, Queue<String> carYearQueue, String FileName) {
		//this method saves data from file to queue
		try {
			ArrayList<String> brand = new ArrayList<>();
			ArrayList<String> model = new ArrayList<>();
			ArrayList<String> category = new ArrayList<>();
			ArrayList<String> year = new ArrayList<>();
			ArrayList<String> price = new ArrayList<>();
			List<String> tempData = Files.readAllLines(Paths.get(FileName));
			for(String line : tempData) {
			    String[] fields = line.split(",");
			    brand.add(fields[0]);
				model.add(fields[1]);
				category.add(fields[2]);
				year.add(fields[3]);
				price.add(fields[4]);
			}
			carBrandQueue.addAll(brand);
			carModelQueue.addAll(model);
			carCategoryQueue.addAll(category);
			carYearQueue.addAll(year);
			carPriceQueue.addAll(price);
		} catch (Exception e) {
			ab.ErrorAlert();
		}
	}
	
	public void FileUpdate(ArrayList<String> carBrandAL, ArrayList<String> carModelAL, ArrayList<String> carCategoryAL, ArrayList<String> carYearAL, ArrayList<String> carPriceAL, String FileName, boolean append) {
		//this method upadates data in the file
		try {
			FileWriter fw = new FileWriter(new File(FileName), append);
			BufferedWriter bw = new BufferedWriter(fw);
			for(int i = 0; i < carBrandAL.size(); i++) {
				bw.write(carBrandAL.get(i) + "," + carModelAL.get(i) + "," + carCategoryAL.get(i) + "," + carYearAL.get(i) + "," + carPriceAL.get(i) + "\n");
			}
			bw.close();
		} catch(IOException e) {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setTitle("An Error Occured!");
        	errorAlert.setHeaderText(null);
        	errorAlert.setContentText("Oops! An error occured. Sorry for your inconvinence.");
        	errorAlert.showAndWait();
		}
	}
}
