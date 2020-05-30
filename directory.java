package directory;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Scanner;

public class directory
{
 void listfolder(File direct)
 {
  File[] subdirs=direct.listFiles(new FileFilter()
  {
	public boolean accept(File pathname)
	{
	 return pathname.isDirectory();                                       //returning the directory given by user
	}
  });
  System.out.println("\nDirectory of " +direct.getPath());                    //printing current path of the file inputed by user
  listfile(direct);
  for(File folder:subdirs)
  {
	listfolder(folder);  
  }
 }
 private void listfile(File direct)
 {
  File[] files =direct.listFiles();
  @SuppressWarnings("unused")
  String ans="";
  java.util.Date myDate = new java.util.Date(direct.lastModified());          //checking for last modified date of each file
  System.out.println("  name                                          length                  modified             code");
	   
	   for(int i = 0; i < files.length; i++)                              //iterating upto no of files in the current directory
	   { 
		  String code = "";                                           //for every iteration the string code is initialised as an empty string
	      if(files[i].canRead()&&files[i].canWrite())
	          code +="rw";                                                //push rw to string code if file is both readable and writable
	      else if(files[i].canRead()&&!(files[i].canWrite()))
	    	  code+="r-";                                                 //push r- to string code if file is readable and not writable
	      else if(!(files[i].canRead())&& files[i].canWrite())
	    	  code+="w-";                                                 //push w- to string code if file is not readable and but writable
	      else
	    	  code+="--";                                                 //push -- to string code if file is neither readable nor writable
	      
	       //printing all the file attributes such as :name ,length,last modified date,readable,writable,both or neither 	
           System.out.printf("%-46s  %-10d "+"  "+myDate+"    "+" %-1s ",files[i].getName(),files[i].length(),code);
           System.out.println("\n");
       }
   }
public static void main(String args[]) throws IOException
 {
  String ans="";
  Scanner sc=new Scanner(System.in);
  System.out.println("Hello ,Please enter your name\n");                     //Ask the user for his/her name
  String name=sc.nextLine();
  name.toUpperCase(); 
  while(!ans.equals("N"))                                                    //If answer equals "N" then terminate the while loop
  {
   System.out.println("Hi "+name+" please enter the directory path\n");      //ask the user for the directory name 
   String x="c:\\cswendterm\\";                                              //my project's folder is currently in c:\cswendterm\directory
   String z=sc.nextLine();
   String direct=x+z;                                                        //String direct is the final path to look files in the directory
   if(new File(direct).exists())
   {
    new directory().listfolder(new File(direct));                            //if the directory exists then show all the files and subfolders in it
   }	
   else
   {
	  System.out.println("Sorry "+name+" directory not exist");          //if directory doesn't exist then prompt the user that directory doesn't exist
   }
   System.out.println("Do you want to look for another directory(Y/N) \n");  // check if the user wants to search another directory or not,If yes then process starts again from line 55.
   ans=sc.nextLine();
   ans.toUpperCase();
   if(ans.equals("N"))
   {  
	  System.out.println("\nThanks for trying this UI "+name);          //if user enters "N" then a thank you message for him/her
   }
  }
 }
}
