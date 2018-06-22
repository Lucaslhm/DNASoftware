
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;

public class Driver {

    public static void main(String [] args) {

        BufferedReader br = null;
        FileReader fr = null;
        String FILENAME,rawName;
        String rawData = "";
        double gcHigh;
        int indexSave;
        ArrayList<DNA> AllStrands;
        AllStrands = new ArrayList<DNA>();


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

        try
        {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            String sCurrentLine;
            int tracker =0;

            if ((sCurrentLine = br.readLine()) != null && sCurrentLine.charAt(0) == '>')
                AllStrands.add(tracker, (new DNA(br.readLine())));

            while ((sCurrentLine = br.readLine()) != null) {
                if(sCurrentLine.charAt(0) == '>')
                {
                    tracker++;
                    rawName = sCurrentLine;
                    AllStrands.add(tracker,new DNA(rawName));
                }
                else
                {
                    rawData = sCurrentLine;
                    AllStrands.get(tracker).amendPairs(rawData);
                }
            }

        }

        catch(IOException e)
        {
            printStackTrace();
        }

            gcHigh = AllStrands.get(AllStrands.size()-1).gcContent();
            indexSave = AllStrands.size();
        for (int i = AllStrands.size()-1; i>=0;i--)
        {
            if (AllStrands.get(i).gcContent() > gcHigh)
            {
                gcHigh = AllStrands.get(i).gcContent();
                indexSave = i;
            }

        }

        System.out.println(AllStrands.get(indexSave-1).GCreturn());
        System.out.println(AllStrands.get(indexSave-1).toString());
    }
}
