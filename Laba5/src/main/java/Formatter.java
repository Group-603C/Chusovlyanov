package main.java;

import java.util.ArrayList;

public class Formatter {

    static String build(String formatString, Object... arguments){
        ArrayList<Object> argumentSet = convertToList(formatString, arguments);
        return convertToResult(argumentSet);
    }

    private static String convertToResult (ArrayList<Object> argumentSet){
        int index =0;
        StringBuilder result = new StringBuilder();
        while(!argumentSet.isEmpty()&& index < argumentSet.size()){
            result.append(argumentSet.get(index));
            index++;
        }
        return result.toString();
    }

    private static ArrayList<Object> convertToList(String formatString, Object... arguments){

        ArrayList<Object> argumentSet = new ArrayList<>();
        StringBuilder partOfLine = new StringBuilder();
        boolean isArgument=false;
        int index=0;

        for (char i:formatString.toCharArray()){
            if(i=='{'){
                isArgument=true;
                argumentSet.add(partOfLine.toString());
                partOfLine = new StringBuilder();
            }

            else if(i=='}'&&isArgument){
                isArgument=false;
                argumentSet.add(arguments[index]);
                index++;
            }
            else if(!isArgument){
                partOfLine.append(i);
            }
        }

        argumentSet.add(partOfLine.toString());
        return argumentSet;
    }
}
