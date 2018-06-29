import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class TestDriver {


    public static void main(String []args) {

      JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

      int returnValue = jfc.showOpenDialog(null);
      // int returnValue = jfc.showSaveDialog(null);

      if (returnValue == JFileChooser.APPROVE_OPTION) {
          File selectedFile = jfc.getSelectedFile();

          FILENAME = (selectedFile.getAbsolutePath());


      }
      else
      {
          FILENAME = "";
      }

        try {
          fr = new FileReader(FILENAME);
          br = new BufferedReader(fr);
          String sCurrentLine;
          int tracker = 0;

          if ((sCurrentLine = br.readLine()) != null)
          {
            System.out.println(sCurrentLine);
          }
          else {
            System.out.println("FASTA SUCESSFULLY IMPORTED");
          }

        }
        catch(IOException e){
          System.out.println("Failed to read FASTA file");
          printStackTrace();
        }



    }

}
