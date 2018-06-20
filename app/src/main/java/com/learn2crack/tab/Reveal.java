package com.learn2crack.tab;

import java.io.File;
import java.math.BigInteger;
import java.util.Arrays;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



public class Reveal extends Fragment {
	 private static final int SELECT_PICTURE = 1;
	Bitmap bmp,operation;
	ImageView img;
	TextView msg;
	Button rev,browse;
	EditText password;
	File file;
	File[] listFile;
	private String selectedImagePath;
	BitmapDrawable abmp;
	int bitmapHeight,bitmapWidth;
	
	int p,diff,ascii;
	int len,lenpas;
	int lenarray[],decarray[],dualarr[][];
	int lasbit,blue,bluecount;
	String s2 = "";   
	char nextChar;
	int passwd;
	static int stat=0;
	int sumpass=0;
	int limit_for_loop=0;
	 private TextView t;
	 Context context;
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static Hide newInstance(int sectionNumber) {
			Hide fragment = new Hide();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}
		@Override
		public void onViewCreated(View view, Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onViewCreated(view, savedInstanceState); 

		}
	//BitmapDrawable abmp;
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			super.onCreateView(inflater, container, savedInstanceState);
			View rootView = inflater.inflate(R.layout.reveal_activity, container,false);
         img= (ImageView)rootView.findViewById(R.id.pic);
         browse= (Button)rootView.findViewById(R.id.browse);
         password = (EditText)rootView.findViewById(R.id.passwd);
         rev= (Button)rootView.findViewById(R.id.rev);
         lenarray = new int[7];
         decarray = new int[7];
         msg= (TextView)rootView.findViewById(R.id.text);
         rev.setVisibility(View.INVISIBLE);
         browse.setVisibility(View.INVISIBLE);
   
        password.addTextChangedListener(new TextWatcher(){
        	
             public void onTextChanged(CharSequence s, int start, int before, int count) {

                 // TODO Auto-generated method stub
             }

          
             public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                 // TODO Auto-generated method stub
             }

          
             public void afterTextChanged(Editable s) {

                 // TODO Auto-generated method stub
            if(password.getText().toString().equals(""))
               { 
            	browse.setVisibility(View.INVISIBLE);
            	
                } 

        else
          {
        	browse.setVisibility(View.VISIBLE);
          }
             }
        });
        
        
        
        // msg.setText("height="+height+"width="+width);
    
         
        // abmp = (BitmapDrawable)img.getDrawable();

   /*      Intent fileintent = new Intent(Intent.ACTION_GET_CONTENT);
         fileintent.setType("image/*");
         try {
             startActivityForResult(fileintent, RESULT_OK);
         } catch (Exception e) {
             Log.e("tag", "No activity can handle picking a file. Showing alternatives.");
         }
 
         
	 */
        rev.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
           	 try{
           	 String passwdstring = password.getText().toString();
           	 //int sumpass=0;
           	 int lenpass=passwdstring.length();
           	 int password[]=new int[lenpass];
           	 for(int f=0;f<lenpass;f++)
   				{
   					ascii = (int) passwdstring.charAt(f);
   			
   					password[f] = ascii;
   			
   				}
      			/////////magic number////////////
      			for(int g=0;g<lenpass;g++)
      			{
      				sumpass=sumpass+password[g];
      				
      			}
      			passwd=sumpass;
      			int len_passwd=Integer.toString(passwd).length();
                
                switch(len_passwd)
                {
                case 3:
              	  stat=passwd%100;
              	  break;
                case 2:
              	  stat=passwd;
              	  break;
                case 4:
              	  stat=passwd%100;
              	  break;
                }
            	//stat=0;
                limit_for_loop = stat + 7;
           	 
           	 diff = 0;/////stat/////limit_for_loop
         	/*msg.setText("Hey"+Color.blue(bmp.getPixel(0,0))+Color.blue(bmp.getPixel(1,1))
  					+Color.blue(bmp.getPixel(2,2))
  					+Color.blue(bmp.getPixel(3,3))
  					+Color.blue(bmp.getPixel(4,4))
  					+Color.blue(bmp.getPixel(5,5))
  					+Color.blue(bmp.getPixel(6,6)));*/
          	 for(int lentake=stat;lentake<limit_for_loop;lentake++)
           	 {
           		
           		p=bmp.getPixel(lentake,lentake);
           		//msg.setText("value"+String.valueOf(p));
           		blue=Color.blue(p);
           		bluecount = countret(blue);
           		lasbit=(bluecount%2);
           	    //lasbit = chklasbit(blue); 
           	    
           	    lenarray[diff]=lasbit;
           	    diff++;
           	 }
           	 len = bindec(lenarray);
           //	 msg.setText("hello"+len);
           
           	 //i=i+7;
           	 //msg.setText("length of string"+lenarray[0]+lenarray[1]+lenarray[2]+lenarray[3]+lenarray[4]+lenarray[5]+lenarray[6]);
           	/*	msg.setText("output"+ chklasbit(Color.blue(bmp.getPixel(100,100)))+chklasbit( Color.blue(bmp.getPixel(101,101)))
         					+ chklasbit(Color.blue(bmp.getPixel(102,102)))
         					+ Color.blue(bmp.getPixel(103,103))
         					+ Color.blue(bmp.getPixel(104,104))
         					+ Color.blue(bmp.getPixel(105,105))
         					+ Color.blue(bmp.getPixel(106,106)));*/
           	 //	 msg.setText("gey"+decarray[0]+decarray[1]+decarray[2]+decarray[3]+decarray[4]+decarray[5]+decarray[6]);
           	//msg.setText(String.valueOf(len));
           	 dualarr = new int[len][7];
           	int var = (len * 7),dusra;
           	int info=stat;
           	for(int t=0;t<len;t++)
       		{
           		dusra=0;
           		info=info+7;
           	for (int infy=info;infy<(info+7);infy++)
           	{
           		
           	//	diff = infy-107;
           		p=bmp.getPixel(infy,infy);
           		blue=Color.blue(p);
           		bluecount = countret(blue);
           		lasbit=(bluecount%2);
           		//lasbit = chklasbit(blue);
           		//decarray[diff]=lasbit;
           		
           		dualarr[t][dusra]=lasbit;
           		dusra++;
           		
           	}
       		}
           	/*
           	String datastr=Arrays.toString(lenarray);


           	byte[] bytes = datastr.getBytes();
           	BigInteger bi = new BigInteger(bytes);
           	String s = bi.toString(2); 
           	

           	

           	for(int i = 0; i <= s.length()-8; i += 8) //this is a little tricky.  we want [0, 7], [9, 16], etc
           	{
           	     nextChar = (char)Integer.parseInt(s.substring(i, i+8), 2);
           	     s2 += nextChar;
           	}
           	msg.setText(s2);*/
           	
           	int anotherarr[],y,w,x=0,ans=0,finalvalue;
           	String str1=null,str2=null;
           	anotherarr= new int[7];
           	char c = 0;
           	char chararray[];
           	chararray = new char[len];
           	
           	for(int l=0;l<len;l++)
           	{
           		
           		
           		for(int m=0;m<7;m++)
           		{
           			anotherarr[m]=dualarr[l][m];
           			finalvalue = bindec(anotherarr);
           			c = (char) finalvalue;
           			
           			
           		}
           		chararray[l]=c;
           		str2= new String(chararray);
           		
           		
           	}
           	msg.setText(str2);
           	 }
           	 catch(Exception e)
           	 {
           		 e.printStackTrace();
           	 }
         finally
         {
        	// msg.setError("Incorrect message", getResources().getDrawable( R.drawable.seal2 ));
        	
         }
           	
           	
           		//String datastr = Arrays.toString(anotherarr);
           		
           		
           		
           		
           	
           	

       		//str1 = Character.toString(c);
       		
           	
           	
           	
           	
            }
        });
         
	    browse.setOnClickListener(new OnClickListener() {
	                    public void onClick(View arg0) {
	                        Intent intent = new Intent();
	                        intent.setType("image/*");
	                        intent.setAction(Intent.ACTION_GET_CONTENT);
	                        startActivityForResult(Intent.createChooser(intent,"Select Picture"), SELECT_PICTURE);
	                       
	                    }
	     
	    });
	    
	    return rootView;
	    }
	 
	    public void onActivityResult(int requestCode, int resultCode, Intent data) {
	        if (resultCode == Activity.RESULT_OK) {
	            if (requestCode == SELECT_PICTURE) {
	                Uri selectedImageUri = data.getData();
	                selectedImagePath = getPath(selectedImageUri);
	                System.out.println("Image Path : " + selectedImagePath);
	                img.setImageURI(selectedImageUri);
	                
	                abmp = (BitmapDrawable)img.getDrawable();
	                bmp = abmp.getBitmap();
	                bitmapHeight= bmp.getHeight();
	                bitmapWidth = bmp.getWidth();
	                img.getLayoutParams().height=bitmapHeight;
	                img.getLayoutParams().width=bitmapWidth;
	                img.setImageBitmap(bmp);
	                rev.setVisibility(View.VISIBLE);
	                //msg.setText("in if");
	            }
	           	
	        }
	    }
	 
	    public String getPath(Uri uri) {
	        /*String[] projection = { MediaStore.Images.Media.DATA };
	        Cursor cursor = managedQuery(uri, projection, null, null, null);
	        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
	        cursor.moveToFirst();
	        return cursor.getString(column_index);*/
	    	String res = null;
	        String[] proj = { MediaStore.Images.Media.DATA };
	        Cursor cursor = getActivity().getContentResolver().query(uri, proj, null, null, null);
	        if(cursor.moveToFirst()){;
	           int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
	           res = cursor.getString(column_index);
	        }
	        cursor.close();
	        return res;
	        
	        
	    }
	    

	    
	    public int bindec(int arr[])
	     {
	        double a=0;
	        int i,num;
	        for(int j=0;j<7;j++)
	        {
	            a=a+((double)arr[j] * Math.pow(2,j));
	        }
	     num=(int)a;
	        
	     return num;
	     }
	    public int chklasbit(int a)
	      {
	          int ubin[],bin[],temp= a,len=7,j=7;
	          bin = new int[len];
	          ubin = new int[len];
	          int count=0;
	          for(int i=0;i<len;i++)
	          {
	        	  j--;
	            ubin[i]=(temp%2);
	              temp=temp/2;
	             bin[j]=ubin[i];
	            
	             
	              //System.out.println(" "+temp+bin[i]); 
	          }
	          return ubin[0];
	      }
	    public int[] decbin(int a)
	      {
	          int ubin[],bin[],temp= a,len=7,j=7;
	          bin = new int[len];
	          ubin = new int[len];
	          int count=0;
	          for(int i=0;i<len;i++)
	          {
	        	  j--;
	            ubin[i]=(temp%2);
	              temp=temp/2;
	             bin[j]=ubin[i];
	            
	             
	              //System.out.println(" "+temp+bin[i]); 
	          }
	          return bin;
	      }
	    public int countret(int a)
	      {
	          int ubin[],bin[],temp= a,len=7,j=7;
	          bin = new int[len];
	          ubin = new int[len];
	          int count=0;
	          for(int i=0;i<len;i++)
	          {
	        	  j--;
	            ubin[i]=(temp%2);
	              temp=temp/2;
	             bin[j]=ubin[i];
	             if(bin[j]==1)
	             {
	            	 count++;
	             }
	             
	              //System.out.println(" "+temp+bin[i]); 
	          }
	          return count;
	      }
	    }




