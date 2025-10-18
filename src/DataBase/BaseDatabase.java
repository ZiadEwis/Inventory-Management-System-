package DataBase;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public abstract class BaseDatabase<T> {
    protected ArrayList<T> records;
    protected String filename;

    public BaseDatabase(String filename) {
        this.filename = filename;
        this.records = new ArrayList<>();
        readFromFile();
    }
    
    protected abstract T createRecordFrom(String line);
    
    protected abstract String getSearchKeyFromRecord(T record);
    
    protected abstract String getLineRepresentationFromRecord(T record);
    
    public void readFromFile(){
        records.clear();
        try(Scanner sc = new Scanner(new File(filename))){
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                if(!line.trim().isEmpty()){
                    T record = createRecordFrom(line);
                    if(record != null)
                        records.add(record);
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found: " + filename);
        }
    }
    
    public ArrayList<T> returnAllRecords(){
        return records;
    }
    
    public T getRecord(String key){
        for(T record : records)
            if(getSearchKeyFromRecord(record).equals(key))
                return record;
        return null;
    }
    
    public boolean contains(String key){
        return getRecord(key) != null;
    }
    
    public void insertRecord(T record){
        records.add(record);
    }
    
    public void deleteRecord(String key){
        records.removeIf(record -> getSearchKeyFromRecord(record).equals(key));
    }
    
    public void saveToFile(){
        try(PrintWriter writer = new PrintWriter(new FileWriter(filename))){
            for(T record : records)
                writer.println(getLineRepresentationFromRecord(record));
        }catch(IOException e){
            System.err.println("Error writting to file: " + filename);
        }
    }
}
