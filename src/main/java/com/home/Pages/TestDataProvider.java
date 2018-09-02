package com.home.Pages;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.reflect.Method;

public class TestDataProvider
{
public static String testCaseName;
private static String testdatapath = "C:\\Users\\kumar\\eclipse-workspace\\Selenide\\src\\main\\java\\resources\\testdata.csv";

    public static Object[][] readTestData(Method method)
    {
        testCaseName = method.getName();
        System.out.println("Test Case Being Executed is : "+testCaseName);
        ArrayList<HashMap<Object,Object>> data = new ArrayList<>();
        Object[][] objects ;
        try {
            FileReader filereader = new FileReader(testdatapath);
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            String[] key ;
            HashMap<Object, Object> row = new HashMap<>();
            int rowCount =0;
            key = csvReader.readNext();
            while ((nextRecord = csvReader.readNext()) != null) {
                row = new HashMap<>();
                int colCount = 0;
                if(nextRecord[0].equalsIgnoreCase(testCaseName) && nextRecord[1].equalsIgnoreCase("y")) {
                    for (String cell : nextRecord) {
                       // System.out.print(cell + "\t");
                        row.put(key[colCount], cell);
                        colCount++;

                    }

                   // System.out.println();
                    data.add(row);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return getObjectFromHashMap(data);
    }

    public static Object[][] getObjectFromHashMap(ArrayList<HashMap<Object,Object>> map)
    {
        //System.out.println("Inside getObjectFromHashMap "+map.size());
        Object[][] obj = new Object[map.size()][1];
        for(int i=0;i<map.size();i++)
        {
            //System.out.println("Map"+i);
            try {
                obj[i][0]=map.get(i);
            }catch (Exception e){
                System.out.println("Inside Exception");e.printStackTrace();}
            //System.out.println("Map at "+i+" = "+map.get(i).toString());

        }
        return obj;

    }

}

