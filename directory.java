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
	 return pathname.isDirectory();
	}
  });
  System.out.println("\nDirectory of " +direct.getPath());
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
  java.util.Date myDate = new java.util.Date(direct.lastModified());
  System.out.println("  name                                          length                  modified             code");
	   String code = "";
	   for(int i = 0; i < files.length; i++)
	   { 
		  code="";
	      if(files[i].canRead()&&files[i].canWrite())
	          code += "rw";
	      else if(files[i].canRead()&&!(files[i].canWrite()))
	    	  code+="r-";
	      else if(!(files[i].canRead())&& files[i].canWrite())
	    	  code+="w-";
	      else
	    	  code+="--";
           System.out.printf("%-46s  %-10d "+"  "+myDate+"    "+" %-1s ",files[i].getName(),files[i].length(),code);	
           System.out.println("\n");
       }
   }
public static void main(String args[]) throws IOException
 {
  String ans="";
  Scanner sc=new Scanner(System.in);
  System.out.println("Hello ,Please enter your name\n");
  String name=sc.nextLine();
  while(!ans.equals("N"))
  {
   System.out.println("Hi "+name+" please enter the directory path\n");
   String x="c:\\";
   String direct=x+sc.nextLine();
   if(new File(direct).exists())
   {
    new directory().listfolder(new File(direct));
   }	
   else
   {
	  System.out.println("Sorry "+name+" directory not exist");
   }
   System.out.println("Do you want to look for another directory(Y/N) \n");
   ans=sc.nextLine();
   ans.toUpperCase();
   if(ans.equals("N"))
   {  
	  System.out.println("\nThanks for trying this UI "+name);
   }
  }
 }
}