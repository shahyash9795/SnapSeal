package com.learn2crack.tab;



import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

import com.learn2crack.tab.ScalingUtilities.ScalingLogic;








//import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.os.Build;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;

public class Hide extends Fragment {
	////////////DECLARATIONS/////////////////
	private static final int SELECT_PICTURE = 1;
	private Bitmap bmp,bmpnew,operation,bmp1;
	private String selectedImagePath;
	int bitmapHeight,bitmapWidth,len_of_text,n,ascii,inc,blue,p,imgh,imgw,fin,red,green,alpha,value,blueb;
    private ImageView img;
	private TextView t1;
	private Button clickit,revActivity,open,share;
	private EditText editbox,passwordeditbox;
    String val_result_string,text2;
	private int flag=0;
	char result;
	int val_result[],texbin[][],lenbin[],password[];
	static int i;
	BitmapDrawable  abmp,abmp1;
	Uri SelectedImageURI;
	private int mDstWidth;
	private int mDstHeight;
	 boolean success=false;
	 int len;
	int passwd,lenpass;
	int sumpass=0;
	
	int limit_for_loop;
	Save obj;
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
	//	Hide.context=getActivity().getApplicationContext();

	}
	
	public Hide(){
		
	}
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		
		View rootView = inflater.inflate(R.layout.hide_activity, container,false);
          ////////ALLOCATION MEMORY TO ANDROID WIDGETS////////////////
          t1= (TextView) rootView.findViewById(R.id.op);
          editbox= (EditText)rootView.findViewById(R.id.et1);
          passwordeditbox= (EditText)rootView.findViewById(R.id.et2);
          img = (ImageView)rootView.findViewById(R.id.image4);
          open=(Button)rootView.findViewById(R.id.open);
          clickit = (Button)rootView.findViewById(R.id.tgb1);
          clickit.setVisibility(View.INVISIBLE);
         obj = new Save();
        
          DisplayMetrics displaymetrics = new DisplayMetrics();
          getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
          int height = displaymetrics.heightPixels;
          int width = displaymetrics.widthPixels;
          editbox.getLayoutParams().width=width/2;
          passwordeditbox.getLayoutParams().width=width/2;
          mDstWidth = getResources().getDimensionPixelSize(R.dimen.destination_width);
	          mDstHeight = getResources().getDimensionPixelSize(R.dimen.destination_height);

          
          //////////////OPENS THE REVEAL ACTIVITY/////////////////////
          /*revActivity.setOnClickListener(new View.OnClickListener() 
          {		
            @Override
  			public void onClick(View view) {
            	FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.layout., arg1)
  				
  	            
  			}
          });*/
          
         
          //////////////BUTTON WHICH HIDES THE TEXT INTO IMAGE///////////////



	        
	          clickit.setOnClickListener(new View.OnClickListener() 
	          {		
	        	
	        	
	  			@Override
	  			public void onClick(View view) {
	  			///////INITIALIZE ARRAY AND VARS///////////////
	  				
	  				if(editbox.getText().toString().equals(""))
	  				{
	  					Toast.makeText(getActivity(), "Please enter the message",Toast.LENGTH_SHORT).show();
	  				}
	  				else if(passwordeditbox.getText().toString().equals(""))
	  				{
	  					Toast.makeText(getActivity(), "Please enter the password",Toast.LENGTH_SHORT).show();
	  				}
	  				
	  				else
	  				{
	  				String passwdstring =passwordeditbox.getText().toString();
	  				
	  				int lenpass=passwdstring.length();
	      			
	      			password=new int[lenpass];
	      			//////////Stores ascii of password string///////////
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
	              	  i=passwd%100;
	              	  break;
	                case 2:
	              	  i=passwd;
	              	  break;
	                case 4:
	              	  i=passwd%100;
	              	  break;
	                }
	      			
	  				 
	      			text2 = editbox.getText().toString();
	      		  len=text2.length();
	      	//	t1.setText("sumpass "+sumpass+"len_passwd "+len_passwd+"i "+i+"len"+len);
	  				
		        	// text2=editbox.getText().toString();  				
		  				int k,h;
		  				limit_for_loop = i + 7;
		  			texbin = new int[len][7];
		  			val_result = new int[len];
		  		    int[] l=new int[7];
					int[] m=new int[7];
					int[] lenbin = new int[7];
					int z,p1;
					abmp = (BitmapDrawable)img.getDrawable();
			         bmp = abmp.getBitmap(); 
			         operation = Bitmap.createBitmap(bmp.getWidth(),bmp.getHeight(), bmp.getConfig());
			         for(int kabir=0;kabir<bmp.getWidth();kabir++)//loop to initialize the operation BITMAP
			         {
			       	  for(int mona=0;mona<bmp.getHeight();mona++)
			       	  {
			       		  int p=bmp.getPixel(kabir,mona);
			       		  operation.setPixel(kabir,mona, Color.argb(Color.alpha(p), Color.red(p), Color.green(p), Color.blue(p)));
			       	  }
			         }
				lenbin = decbin(len);//CONVERTS THE LENGTH INTO BINARY 
	  			
	  			inc=0;
	  			
	  			////////////////////SETS THE LENGTH OF THE TEXTVIEW INTO FIRST 7 PIXELS///////////////////
	  			for(int no=i;no<limit_for_loop;no++)
	  			{
	  			    	p = bmp.getPixel(no,no);
	  			    	blue=Color.blue(p);
	  			    	alpha=Color.alpha(p);
	  			    	red=Color.red(p);
	  			    	green=Color.green(p);
	  			    	blueb=countret(blue);
	  			    	if((blueb % 2)==0)
			  			{
			  				if(lenbin[inc]==0)
			  				{
			  					value=blue;
			  				}
			  				else
			  				{
			  					if(chklasbit(blue)==0)
			  					{
			  						blue++;
			  						value=blue;
			  					}
			  					else
			  					{
			  						blue--;
			  						value=blue;
			  					}
			  				}
			  			}
			  			else
			  			{
			  				if(lenbin[inc]==1)
			  				{
			  					value=blue;
			  				}
			  				else
			  				{
			  					if(chklasbit(blue)==0)
			  					{
			  						blue++;
			  						value=blue;
			  					}
			  					else
			  					{
			  						blue--;
			  						value=blue;
			  					}
			  				}
			  			}
			  			  			
	  					operation.setPixel(no, no, Color.argb(alpha, red, green,value));
	  					inc++;
	  					
	  				}
	  				
	 		/*	t1.setText("Hey"+Color.blue(operation.getPixel(0,0))+Color.blue(operation.getPixel(1,1))
	  					+Color.blue(operation.getPixel(2,2))
	  					+Color.blue(operation.getPixel(3,3))
	  					+Color.blue(operation.getPixel(4,4))
	  					+Color.blue(operation.getPixel(5,5))
	  					+Color.blue(operation.getPixel(6,6)));*/
	  		/*	t1.setText("Hey"+Color.blue(bmp.getPixel(0,0))+Color.blue(bmp.getPixel(1,1))
	  					+Color.blue(bmp.getPixel(2,2))
	  					+Color.blue(bmp.getPixel(3,3))
	  					+Color.blue(bmp.getPixel(4,4))
	  					+Color.blue(bmp.getPixel(5,5))
	  					+Color.blue(bmp.getPixel(6,6)));*/
	  			//t1.setText("height"+len);
	          
	  		
	  		
	  			
	  			
	  			///////////GETS ASCII VALUE OF LETTERS OF TEXT AND PUTS EM INTO ARRAY//////////////////
	  			for(n=0;n<len;n++)
	  				{
	  					ascii = (int) text2.charAt(n);
	  			
	  					val_result[n] = ascii;
	  			
	  				}
	  			
	  			
	  			///////////CONVERTS THE ASCII INTO BINS AND STORES THEM INTO A 2-D ARRAY///////////////
	  			for(int x=0;x<len;x++)
	  			{
	  				l= decbin(val_result[x]);
	  				
	  				for(int y=0;y<7;y++)
	  				{
	  						
	  				texbin[x][y]=l[y];
	  				
	  				}
	  				
	  			}
	  			i=i+7;
	  			///////////LOOP FOR STORING TEXT INTO PIXEL VALUES////////////////
	  			for(int x=0;x<len;x++)
	  			{
	  			  for(int num1=0;num1<7;num1++)
	  				{
	  					m[num1]=texbin[x][num1];
	  					p = bmp.getPixel(i+num1,i+num1);
	  		            blue=Color.blue(p);
	  		            alpha=Color.alpha(p);
				    	red=Color.red(p);
				    	green=Color.green(p);
	  		  			blueb=countret(blue);
	  					
	  		  		if((blueb % 2)==0)
		  			{
		  				if(m[num1]==0)
		  				{
		  					value=blue;
		  				}
		  				else
		  				{
		  					if(chklasbit(blue)==0)
		  					{
		  						blue++;
		  						value=blue;
		  					}
		  					else
		  					{
		  						blue--;
		  						value=blue;
		  					}
		  				}
		  			}
		  			else
		  			{
		  				if(m[num1]==1)
		  				{
		  					value=blue;
		  				}
		  				else
		  				{
		  					if(chklasbit(blue)==0)
		  					{
		  						blue++;
		  						value=blue;
		  					}
		  					else
		  					{
		  						blue--;
		  						value=blue;
		  					}
		  				}
		  			}
	  		  		
	  					k=h=i+num1;
	  					operation.setPixel(k, k, Color.argb(alpha, red, green, value));
	  					
	  				}
	  				
	  				i=i+7;
	  				
	  			}
  		
  			
  		
  	img.setImageBitmap(operation);
  	obj.SaveImage(getActivity().getApplicationContext(), operation);	

	        }
  			}
  	//////////////STORES THE NEW IMAGE INTO out.png/////////////////////////		
/*
  			File sdCardDirectory = Environment.getExternalStorageDirectory();
  			//String url = SelectedImageURI.toString();
  			File image = new File(sdCardDirectory,"out.png");
  			FileOutputStream fout;
  			try {
				fout=new FileOutputStream(image);
				operation.compress(Bitmap.CompressFormat.PNG, 100, fout);
				fout.flush();
				fout.close();
				success=true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
  	
  			
  			
  			
  			
  			
  		});
          
	//}
          ////////////FILE BROWSER IS OPENED/////////////////////////
        open.setOnClickListener(new OnClickListener() {
              public void onClick(View arg0) {
                  Intent intent = new Intent();
                  intent.setType("image/*");
                  intent.setAction(Intent.ACTION_GET_CONTENT);
                  startActivityForResult(Intent.createChooser(intent,"Select Picture"), SELECT_PICTURE);
                  
                  
                  
              }
          });
          return rootView;

      }
//////////////////COUNTS THE NUMBER OF 1S IN A BINARY NUMBER/////////////////
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
//////////////////CONVERTS DECIMAL NUMBER INTO A BINARY ARRAY////////////////////      
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
          return ubin;
      }
//////////////////CHECKS THE LAST BIT OF A BINARY NUMBER//////////////////////////      
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
  /*    private boolean SaveImage(Bitmap finalBitmap) {

    	  File sdCardDirectory = Environment.getExternalStorageDirectory();
			//String url = SelectedImageURI.toString();
			File image = new File(sdCardDirectory,"out.png");
			FileOutputStream fout;
			try {
				fout=new FileOutputStream(image);
				finalBitmap.compress(Bitmap.CompressFormat.PNG, 100, fout);
				fout.flush();
				fout.close();
				success=true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	    return success;
    	}*/

      
     
   
      


public void onActivityResult(int requestCode, int resultCode, Intent data) {
if (resultCode == Activity.RESULT_OK) {
  if (requestCode == SELECT_PICTURE) {
	  
      Uri selectedImageURI = data.getData();
      selectedImagePath = getPath(selectedImageURI);
    //  System.out.println("Image Path : " + selectedImagePath);
      img.setImageURI(selectedImageURI);
      
      BitmapDrawable abmpac = (BitmapDrawable)img.getDrawable();
      Bitmap bmpac = abmpac.getBitmap();
      
      bitmapHeight= bmpac.getHeight();
      bitmapWidth = bmpac.getWidth();
      //img.getLayoutParams().height=bitmapHeight;
      //img.getLayoutParams().width=bitmapWidth;
   //   Bitmap unscaledBitmap = ScalingUtilities.decodeResource(getResources(), mSourceId,
   //           mDstWidth, mDstHeight, ScalingLogic.FIT);

      // Part 2: Scale image
      Bitmap scaledBitmap = ScalingUtilities.createScaledBitmap(bmpac,mDstHeight,
              mDstWidth, ScalingLogic.FIT);
      

      // Calculate memory usage and performance statistics
      //final int memUsageKb = (unscaledBitmap.getRowBytes() * unscaledBitmap.getHeight()) / 1024;
      img.setImageBitmap(scaledBitmap);
    //  clickit.setText("Write Something");
      clickit.setVisibility(View.VISIBLE);
      
 
      
     
      
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


}


