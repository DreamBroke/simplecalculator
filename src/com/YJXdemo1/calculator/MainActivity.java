package com.YJXdemo1.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity implements OnClickListener{
	Button button_0;
	Button button_1;
	Button button_2;
	Button button_3;
	Button button_4;
	Button button_5;
	Button button_6;
	Button button_7;
	Button button_8;
	Button button_9;
	Button button_point;
	Button button_C;
	Button button_DEL;
	Button button_divide;
	Button button_multiply;
	Button button_minus;
	Button button_add;
	Button button_equal;
	EditText edittext_input;
	boolean clear_flag;//清空标识
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_0 = (Button) findViewById(R.id.button_0);
        button_1 = (Button) findViewById(R.id.button_1);
        button_2 = (Button) findViewById(R.id.button_2);
        button_3 = (Button) findViewById(R.id.button_3);
        button_4 = (Button) findViewById(R.id.button_4);
        button_5 = (Button) findViewById(R.id.button_5);
        button_6 = (Button) findViewById(R.id.button_6);
        button_7 = (Button) findViewById(R.id.button_7);
        button_8 = (Button) findViewById(R.id.button_8);
        button_9 = (Button) findViewById(R.id.button_9);
        button_point = (Button) findViewById(R.id.button_point);
        button_C = (Button) findViewById(R.id.button_C);
        button_DEL = (Button) findViewById(R.id.button_DEL);
        button_divide = (Button) findViewById(R.id.button_divide);
        button_multiply = (Button) findViewById(R.id.button_multiply);
        button_minus = (Button) findViewById(R.id.button_minus);
        button_add = (Button) findViewById(R.id.button_add);
        button_equal = (Button) findViewById(R.id.button_equal);
        edittext_input = (EditText) findViewById(R.id.edittext_input);        
        button_0.setOnClickListener(this);
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);
        button_7.setOnClickListener(this);
        button_8.setOnClickListener(this);
        button_9.setOnClickListener(this);
        button_point.setOnClickListener(this);
        button_C.setOnClickListener(this);
        button_DEL.setOnClickListener(this);
        button_divide.setOnClickListener(this);
        button_multiply.setOnClickListener(this);
        button_minus.setOnClickListener(this);
        button_add.setOnClickListener(this);
        button_equal.setOnClickListener(this);
    }
    //点击事件设定
	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		String str = edittext_input.getText().toString();
		//不同按钮点击事件
		switch (v.getId()) {
		case R.id.button_point:
			if(str.equals("")||str == ""){
				edittext_input.setText("0.");
				break;
			}else if(str.contains(".")&&!str.contains(" ")){
				break;
			}else if(str.contains(" ")){
				String s21 = str.substring(str.indexOf(" ")+3,str.length());
				if(s21.equals("")||s21 == ""){
					edittext_input.setText(str + "0.");
					break;
				}else if(s21.contains(".")){
					break;
				}else{
					edittext_input.setText(str+".");			
					break;
				}
			}else{
			edittext_input.setText(str+".");			
			break;
			}
		case R.id.button_0:
			if(str.equals("0")){
				break;
			}else if(str.contains(" ")){
				String s22 = str.substring(str.indexOf(" ")+3,str.length());
				if(s22.equals("0")||s22 == "0"){
					break;
				}
			}
		case R.id.button_1:
		case R.id.button_2:
		case R.id.button_3:
		case R.id.button_4:
		case R.id.button_5:
		case R.id.button_6:
		case R.id.button_7:
		case R.id.button_8:
		case R.id.button_9:
			if(clear_flag){
				clear_flag = false;
				str = "";
				edittext_input.setText("");
			}
			if(str.equals("0")){
				str = "";
				edittext_input.setText("");
			}
			edittext_input.setText(str+((Button) v).getText());			
			break;
		case R.id.button_divide:
		case R.id.button_multiply:
		case R.id.button_minus:
		case R.id.button_add:
			if(str.contains(" "))
			{
				getResult();
				str = edittext_input.getText().toString();
			}
			edittext_input.setText(str+" "+((Button)v).getText()+" ");
			clear_flag = false;
			break;
		case R.id.button_C:
			clear_flag = false;
			str = "";
			edittext_input.setText("");
			break;
		case R.id.button_DEL:
			if(clear_flag){
				clear_flag = false;
				str = "";
				edittext_input.setText("");
			}else if(str != null&&!str.equals("")){
				String exp = str.substring(str.length()-1, str.length());
				if(exp.equals(" ")){
					edittext_input.setText(str.subSequence(0, str.length()-3));
				}else{
					edittext_input.setText(str.subSequence(0, str.length()-1));
				}
			}			
			break;
		case R.id.button_equal:
			getResult();
			break;
		}
	}
	private void getResult(){
		String exp = edittext_input.getText().toString();
		if(exp==null||exp.equals("")){
			return;
		}
		if(!exp.contains(" ")){
			return;
		}
		if(clear_flag){
			clear_flag = false;
			return;
		}
		clear_flag = true;
		double result = 0;
		String s1 = exp.substring(0, exp.indexOf(" "));
		String op = exp.substring(exp.indexOf(" ")+1, exp.indexOf(" ")+2);
		String s2 = exp.substring(exp.indexOf(" ")+3,exp.length());
		if(!s1.equals("")&&!s2.equals("")){
			double d1 = Double.parseDouble(s1);
			double d2 = Double.parseDouble(s2);
			if(op.equals("+")){
				result = d1 + d2 ;
			}else if(op.equals("-")){
				result = d1 - d2 ;
			}else if(op.equals("×")){
				result = d1 * d2 ;
			}else if(op.equals("÷")){
				if(d2 == 0){
					result = 0;
				}else{
					result = d1 / d2 ;
				}				
			}
		}else if(!s1.equals("")&&s2.equals("")){
			result = Double.valueOf(s1);
		}else if(s1.equals("")&&!s2.equals("")){
			double d2 = Double.parseDouble(s2);
			if(op.equals("+")){
				result = d2 ;
			}else if(op.equals("-")){
				result = -d2 ;
			}else if(op.equals("×")||op.equals("÷")){
				result = 0 ;
			}
		}else{
		edittext_input.setText("");
		}
		if(!s1.contains(".")&&!s2.contains(".")&&!op.equals("÷")){
			int r = (int)result;
			edittext_input.setText(r+"");
		}
		else{
		Double d=(double)(Math.round(result*100000000)/100000000.0); 
		edittext_input.setText(d+"");
		}
	}
}
