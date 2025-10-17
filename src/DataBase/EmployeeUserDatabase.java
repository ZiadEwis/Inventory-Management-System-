package DataBase;

import java.util.ArrayList;

public class EmployeeUserDatabase extends BaseDatabase<EmployeeUser>{
    public EmployeeUserDatabase(String filename){
        super(filename);
    }
    
    @Override
    protected EmployeeUser createRecordFrom(String line){
        String[] parts = line.split(",");
        if(parts.length == 5)
            return new EmployeeUser(parts[0].trim(),parts[1].trim(),parts[2].trim(),parts[3].trim(),parts[4].trim());
        else
            return null;
    }
    
    @Override
    protected String getSearchKeyFromRecord(EmployeeUser record){
        return record.getSearchKey();
    }
    
    @Override
    protected String getLineRepresentationFromRecord(EmployeeUser record){
        return record.lineRepresentation();
    }
}
