package main.java;

import java.util.ArrayList;

public class Formatter {

    public static String build(String formatString, Object... arguments) {
        if (formatString == null || formatString.equals("")) {
            return "";
        }
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

    private static ArrayList<Object> convertToList(String formatString, Object... arguments)throws NumberFormatException,IndexOutOfBoundsException{

        ArrayList<Object> argumentSet = new ArrayList<>();
        StringBuilder partOfLine = new StringBuilder();
        boolean isArgument=false;
        String index=new String();

        for (char i:formatString.toCharArray()){

            if(i=='{'){
                isArgument=true;
                argumentSet.add(partOfLine.toString());
                partOfLine = new StringBuilder();
            }

            else if(i=='}'&&isArgument){
                isArgument=false;
                try {
                    argumentSet.add(arguments[Integer.parseInt(index)]);
                }
                catch (NumberFormatException e){
                    argumentSet.add("{}");
                    System.out.println("The number of the argument is not known");
                }
                catch (IndexOutOfBoundsException e){
                    argumentSet.add("{"+index+"}");
                    System.out.println("There is no such argument");
                }
                finally {
                    index = "";
                }
            }

            else if (isArgument&&(i>='0'&&i<='9')){
                index+=i;
            }

            else if(!isArgument){
                partOfLine.append(i);
            }
        }

        argumentSet.add(partOfLine.toString());
        return argumentSet;
    }
}
