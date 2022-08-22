package calculatorbytanvir;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {
    @FXML
    private TextField input;
    @FXML
    private TextField output;
    @FXML
    private Button convertbtn;
    @FXML
    private Button ClearBTN;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    static double math(double num1, double num2, int op){
        switch(op){
            case 1: return num1/num2;
            case 2: return num1*num2;
            case 3: return num1-num2;       
            case 4: return num1+num2;
        }        
        return 0;
    }
    
    static String calculate(String inp){
        String op = "/*-+";
        double a=0,b=0;
        double ans[] = new double[500];
        int operator[] = new int[500];
        int ptr = 0,idx=0;
        for(int i=1;i<inp.length();i++){
            for(int j=0;j<op.length();j++){
                if(op.charAt(j)==inp.charAt(i)){
                    ans[idx] = Double.parseDouble(inp.substring(ptr,i));
                    operator[idx+1] = j+1;
                    idx++;
                    ptr=i+1;
                }
            }
        }
        ans[idx] = Double.parseDouble(inp.substring(ptr));
        idx++;      
        for(int j=1;j<=4;j++){
            boolean tanvir = false;
            for(int i=0;i<idx;i++){
                if(operator[i]==j){
                    tanvir = true;
                    ans[i-1]=math(ans[i-1],ans[i],j);
                    for(int k=i;k<idx-1;k++){
                        double temp = ans[k];
                        ans[k] = ans[k+1];
                        ans[k+1] = temp;
                        
                        int t = operator[k];
                        operator[k]=operator[k+1];
                        operator[k+1]=t;
                    }
                    idx--;
                    i=0;
                    if(idx<0) break;
                }
            }
            if(tanvir) j--;
        }
       
        return String.valueOf(ans[0]);
    }
    
    // Separating the String inside brackets and calculating them first using the cal function
    static String calculateWithBrackets(String inp ){
        
        inp = "("+inp+")";
        
        while(inp.contains("(")){
            String ans = "";
            int ptr1=0,ptr2=0;
            for(int i=0;i<inp.length();i++){
                if(inp.charAt(i)=='('){
                    ptr1=i+1;
                }
                if(inp.charAt(i)==')'){
                    ptr2=i; break;
                }
            }
            String temp = calculate(inp.substring(ptr1,ptr2));
            ans = inp.substring(0,ptr1-1) + temp + inp.substring(ptr2+1);           
            inp = ans;     
        }
        return inp;
    }
    
    @FXML
    private void convert(ActionEvent event) {
        
        String inp = input.getText();
        String valid ="0123456789+-/*()";
        String dataInput = inp;
        String answer = "";
        boolean f = false,v =true,c=true;
        
        try{
            for(int i=0;i<inp.length();i++){
                f = false;
                for(int j=0;j<valid.length();j++){
                    if(inp.charAt(i)==valid.charAt(j)) f = true;
                }
                if(!f){
                    v=false; break;
                }
            }    
            answer =  calculateWithBrackets(inp);
        }
        catch(Exception e){
            c = false;
            System.out.println(e);
            System.out.println("Errors");
        }
        finally{
            if(inp.equals("id")) output.setText("20203036");
            else if(v && c) output.setText(answer);
            else output.setText("Invalid String");
        } 
    }
    @FXML
    private void clearbtn(ActionEvent event) {
        input.setText(null);
        output.setText(null);
    }
}
