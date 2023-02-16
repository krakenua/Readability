package com.example.dimlom;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;


public class Controller {

    @FXML
    private Text CountLTT;

    @FXML
    private Text CountPar;

    @FXML
    private Text CountSKL;

    @FXML
    private Text CountSMB;

    @FXML
    private Text CountST;

    @FXML
    private Text CountWrd;

    @FXML
    private MenuItem MenuAbout;

    @FXML
    private MenuBar MenuBar;

    @FXML
    private Menu MenuBarChange;

    @FXML
    private Menu MenuBarFile;

    @FXML
    private Menu MenuBarHelp;

    @FXML
    private MenuItem MenuClear;

    @FXML
    private MenuItem MenuInform;

    @FXML
    private MenuItem MenuOpen;

    @FXML
    private MenuItem MenuSave;

    @FXML
    private TextArea TextArea;

    @FXML
    private TextField autoindex;

    @FXML
    private Button btnStart;

    @FXML
    private Button btnlng;

    @FXML
    private TextField indexFL;

    @FXML
    private TextField indexKL;

    @FXML
    private TextField indexKL1;

    @FXML
    private Text txtindexAuto;

    @FXML
    private Text txtindexFK;

    @FXML
    private Text txtindexFlesh;

    @FXML
    private Text txtindexKL;

    public boolean lng = false;


    FileChooser fileChooser = new FileChooser();

    @FXML
    void initialize() {


        MenuOpen.setOnAction(event -> {
            File file = fileChooser.showOpenDialog(new Stage());
            System.out.println("OPENING");

            if(file != null){
                try {
                    Scanner scanner = new Scanner(file);
                    while(scanner.hasNextLine()){
                        TextArea.appendText(scanner.nextLine() + "\n");
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        MenuSave.setOnAction(event -> {

            File file = fileChooser.showSaveDialog(new Stage());
            if(file != null) {
                saveSystem(file, TextArea.getText());
            }

            System.out.println("Save");
        });



        MenuClear.setOnAction(event -> {

            if (lng == false) {


                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Видалити текст");
                alert.setHeaderText("Чи Ви впевнені?");
                alert.setContentText("Натисніть ОК, якщо хочете видалити текст");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get() == null || option.get() == ButtonType.CANCEL) {
                    // close my window
                } else if (option.get() == ButtonType.OK) {
                    TextArea.setText("");
                    indexKL.setText("");
                    indexFL.setText("");
                    indexKL1.setText("");
                    CountPar.setText("");
                    CountST.setText("");
                    CountWrd.setText("");
                    CountLTT.setText("");
                    CountSMB.setText("");
                    CountSKL.setText("");
                }
            }

            if (lng == true) {


                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Delete all text");
                alert.setHeaderText("Are you sure?");
                alert.setContentText("Click OK if you want to delete the all text");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get() == null || option.get() == ButtonType.CANCEL) {
                    // close my window
                } else if (option.get() == ButtonType.OK) {
                    TextArea.setText("");
                    indexKL.setText("");
                    indexFL.setText("");
                    indexKL1.setText("");
                    CountPar.setText("");
                    CountST.setText("");
                    CountWrd.setText("");
                    CountLTT.setText("");
                    CountSMB.setText("");
                    CountSKL.setText("");
                }
            }


            System.out.println("DELETE");
        });



        btnlng.setOnAction(event -> {
            if (lng == false){
            MenuBarFile.setText("File");
            MenuOpen.setText("Open file");
            MenuSave.setText("Save file");
            MenuBarChange.setText("Change");
            MenuClear.setText("Clear text area");
            btnStart.setText("Press me to start");
            MenuAbout.setText("About program");
            MenuInform.setText("Help about index");
            MenuBarHelp.setText("Help");
            txtindexFlesh.setText("Index Flesch");
            txtindexKL.setText("Index Coleman-Liau");
            txtindexFK.setText("Index Flesch-Kincaid");
            txtindexAuto.setText("Automated index");
            btnlng.setText("Мова");
            lng = true;
            }

            else if (lng == true){
                MenuBarFile.setText("Файл");
                MenuOpen.setText("Відкрити файл");
                MenuSave.setText("Зберегти файл");
                MenuBarChange.setText("Змінити");
                MenuClear.setText("Видалити текст");
                btnStart.setText("Тицяй");
                MenuAbout.setText("О програмі");
                MenuInform.setText("Інформація щодо індексів");
                MenuBarHelp.setText("Допомога");
                txtindexFlesh.setText("Індекс Флеша");
                txtindexKL.setText("Індекс Колман-Ліау");
                txtindexFK.setText("Індекс Флеша-Кінкейда");
                txtindexAuto.setText("Автоматичний індекс");
                btnlng.setText("Launguage");
                lng = false;
            }
        });

        MenuInform.setOnAction(event -> {
            if (lng == false) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Інфомарція о індексах");
                alert.setHeaderText("Індекс Флеша: \n 100: Дуже легкий текст. \n 65: Легкий текст. \n 30: Трошки складно читати. \n 0: Дуже складний текст. \n \n" +
                        "Індекс Колман-Ліау: \n Якщо індекс дорівнює 1 - текст є дуже легким для розуміння дітей 6-7 років. \n Якщо текст дорівнює 12 - його легко сприймати підліткам 17-18 років.\n \n" +
                        "Індекс Флеша-Кінкейда: \n Чим нижче показник - тим текст легче для читання та сприйняття. \n \n" +
                        "Автоматичний індекс : (Бал/Вік) \n 1: 5-6;\n 2: 6-7 \n ...  \n 13: 17-18  \n 14: 18-22 \n  \n" + "Більше інформації щодо індексів у Google ;)");
                alert.setContentText("Це є демо-версія додатку.");
                Optional<ButtonType> option = alert.showAndWait();
                System.out.println("ABOUT");
            }

            if (lng == true){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Information about indexes");
                alert.setHeaderText("Index Flesch: \n 100: Very easy text. \n 65: Easy text. \n 30: Difficult to read. \n 0: Vary Hard text. \n \n" +
                        "Index Coleman-Liau: \n If the index is 1, the text is very easy for children 6-7 years old to understand. \n If the text is 12, it is easy for 17-18-year-olds to understand.\n \n" +
                        "Index Flesch-Kincaid: \n he lower the index, the easier the text is to read and understand. Like index Flesch.\n \n" +
                        "Automated Index : (Score/Age) \n 1: 5-6;\n 2: 6-7 \n ...  \n 13: 17-18  \n 14: 18-22 \n  \n" + "More information about indexes in Google ;)" );
                alert.setContentText("It`s demo version.");
                Optional<ButtonType> option = alert.showAndWait();
                System.out.println("ABOUT");
            }
        });

        MenuAbout.setOnAction(event -> {
            if (lng == false) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("О програмі");
                alert.setHeaderText("Програма була написана студентом Соботовичем А.О.");
                alert.setContentText("Це є демо-версія додатку. Функціонал додатку можна розширити у будь-який час.");
                Optional<ButtonType> option = alert.showAndWait();
                System.out.println("ABOUT");
            }

            if (lng == true){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("About program");
                alert.setHeaderText("The program was written by a student Sobotovych A.O.");
                alert.setContentText("This is a demo version of the application. The functionality of the application can be expanded at any time.");
                Optional<ButtonType> option = alert.showAndWait();
                System.out.println("ABOUT");
            }

        });

        btnStart.setOnAction(event -> {
            System.out.println("BTN1");

            String text;
            text = TextArea.getText();

            int abzac = 0;
            int countofsentence = 0;
            int count = 0;

            //--------------------------------------------------------------------------------відкриття word,excel тощо
//            XSSFWorkBook xssfWorkBook= new XSSFworkbook(fileInputStream);



            //--------------------------------------------------------------------------------------------запис в массив
            char[] txtArray = text.toCharArray();
            ArrayList<Character> txt = new ArrayList<Character>();
            for (int i=0; i < txtArray.length; i++)
            {
                txt.add(txtArray[i]);
                System.out.print(txtArray[i]);
            }

            //--------------------------------------------------------------------------------------------------100 слів

            int r = 0;
            char k;
            int c=0;
            String hundredword;
            StringBuilder sb = new StringBuilder();
            char[] tArray = new char [txtArray.length];
            for (int i=0; i < txtArray.length; i++)
            {
                k=txtArray[i];
                sb.append(txtArray[i]);
                if (k == ' '){
                    r++;
                    c++;
                    if(c == 100){
                        break;
                    }
                }

            }
            hundredword = sb.toString();
            System.out.println("100 SLIV: "+ "\n" +hundredword + "\n");

            //-------------------------------------------------------------------------------Рахування індекса Коулмана!-----//

            //------------------------------------------------------------------------------------------кількість речень
            char[] hundredArray = hundredword.toCharArray();
            ArrayList<Character> hda = new ArrayList<Character>();
            int CS = CountSentence(hundredArray,1);
            System.out.println("KOLVO PRED : "+ CS);

            //--------------------------------------------------------------------------------------------кількість букв


            //---------------------------------------------------------------------------------------------------Формула

            double CLI;
            int charCount = CountLetter(hundredArray, 0);
            System.out.println("KOLVO CHAR COUNT: " + charCount);
            CLI = (0.0588 * charCount) - (0.296 * CS) - 15.8;
            System.out.println("Index Coulam Liau: " + CLI);
            String result = String.format("%8.2f", CLI);
            if (lng == false){
            if (charCount <100){
                indexKL.setText("У тексті менше 100 слів!");
            }
            if(charCount >99){
                indexKL.setText(result);
            }
            }

            if (lng == true){


                if (charCount <100){
                    indexKL.setText("This text don`t have 100 words");
                }
                if(charCount >99){
                    indexKL.setText(result);
                }
            }







            //--------------------------------------------------------------------------------рахування речень в тексті
            int CoS= CountSentence(txtArray,0);
            System.out.println("KOLVO PRED ALL : "+ CoS);




            // --------------------------------------------------------------------створення та записа в char табуляціії
            String tabulation = "\t";
            char[] tab = tabulation.toCharArray();
            ArrayList<Character> tb = new ArrayList<>();
            tb.add(tab[0]);
            char tabu = tab[0];

            //-----------------------------------------------------------------------------чисельність символів в тексті
            int lenghtwithsymbols = txtArray.length;
            for(int i = 0; i<text.length(); i++) {
                count++;
            }
            System.out.println("Number characters in the given string (including spaces) "+count +" =? " + lenghtwithsymbols);


            //!!!
            // ---------------------------------------------------------------------------------Рахування кількості слів
                    System.out.println("Кол-во слов:= " + text.split("[-#$%^&!?,\t\n.0-9\\s()]+").length);
            int words = text.split("[-#$%^&!?,\t\n.0-9\\s()]+").length;
            System.out.println("Кол-во words:= " + words);


            //-----------------------------------------------------------Підрахування кількості абзаців з урахуванням, що два пробіла - це абзац також!
            int fs=0;
            int ss=1;
            for(int i=0; i<txtArray.length - 1;i++){
                char firstsybmol = txtArray[fs];
                if (firstsybmol == tabu){
                    abzac++;
                }
                char secondsybmol = txtArray[ss];
                if(Character.isWhitespace(secondsybmol)){
                    if(secondsybmol == firstsybmol){
                        abzac++;
                    }

                }
                fs++;
                ss++;
            }
            System.out.println("Абзацев = " + abzac);


            //------------------------------------------------------------------------рахуємо кількість складів в тексті
            int sklad = 0;
            for(int i=0; i<txtArray.length;i++){

                char gl = txtArray[i];
                if(gl == 'а'|| gl == 'у'|| gl == 'і'|| gl == 'и'|| gl == 'ю'|| gl == 'я'|| gl == 'о' || gl == 'е'|| gl == 'є'|| gl == 'ї'
                || gl == 'А'|| gl == 'У'|| gl == 'І'|| gl == 'И'|| gl == 'Ю'|| gl == 'Я'|| gl == 'О' || gl == 'У'|| gl == 'Є'|| gl == 'Ї'
                || gl =='A'|| gl =='a'|| gl =='E'|| gl =='e'|| gl =='I'|| gl =='I'|| gl =='O'|| gl =='o'|| gl =='U'|| gl =='u'|| gl =='Y'|| gl =='y'){
                    sklad++;
                }
            }
            System.out.println("КОЛ-во слогов :" + sklad);



            //--------------------------------------------------------------------------------------Рахуємо індекс Флеша--//
            double FRE;
            int charLetter = CountLetter(txtArray, 0);

            FRE = 206.835 - (1.015 * (words / CoS)) - (84.6 * (sklad / words));
            System.out.println("Index Flesh : " + FRE);
            String rslt = String.format("%8.2f", FRE);



            //--------------------------------------------------------------------------------------Рахуємо індекс Флешка-Кінкейда--//

            double FK;
            FK = 0.39 *(words/CoS) + 11.8 * (sklad/words) - 15.59;
            System.out.println("Index Flesh - Kinkeyd: " + FK);
            String rst = String.format("%8.2f", FK);


            //--------------------------------------------------------------------------------------------------Автоматичний індекс
            long countnum = text.codePoints().filter(Character::isDigit)
                    .count();
            System.out.println("KOLVO CIFR - " + countnum);
            long countSaN = countnum + charLetter;
            double ARI;
            ARI = 4.71* (countSaN / words) + 0.5 * (words / CoS) - 21.43;
            System.out.println("ARI = " + ARI);
            String rsltARI = String.format("%8.2f", ARI);


            //--------------------------------------------------------------------------------------------------Вивід даних
            autoindex.setText(rsltARI);
            indexKL1.setText(rst);
            indexFL.setText(rslt);

            if (lng == false){
            CountSKL.setText("  Складів: " + sklad);
            CountLTT.setText("  Літер: " + charLetter);
            CountPar.setText("  Абзаців: "+abzac);
            CountWrd.setText("  Слів: " + words);
            CountSMB.setText("  Символів: " + count);
            CountST.setText("  Речень: " + CoS);
            }

            if (lng == true){
                CountSKL.setText("  Syllables: " + sklad);
                CountLTT.setText("  Letters: " + charLetter);
                CountPar.setText("  Paragraphs: "+abzac);
                CountWrd.setText("  Words: " + words);
                CountSMB.setText("  Symbols: " + count);
                CountST.setText("  Sentences: " + CoS);
            }
        });

        }



    public void saveSystem(File file, String content){
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(content);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static int CountSentence(char[] hundredArray,int countofsentence){
        for(int i=0; i<hundredArray.length-1;i++){
            char check= hundredArray[i];
            char check2= hundredArray[i+1];
            if(check2 == '.' || check2 == '!' || check2 == '?'){
                if(check2 == check){
                    //нічого\\
                }
                else{
                    if(check == '.' || check == '!' || check == '?'){

                    }
                    else {
                        countofsentence++;
                    }
                }
            }
        }
        System.out.println("Кол-во предложений: " + countofsentence);
        return countofsentence;
    }

    public static int CountLetter(char[] Array,int charCount){
        int charCounts = 0;
        char ltt;
        char UAl = 'Ґ';
        char UAL = 'ґ';
        for( int i = 0; i < Array.length; i++ )
        {
            ltt = Array[i];
            if(Character.isLetter(ltt)){
                charCounts++;
            }
            if(ltt == UAl || ltt == UAL){
                charCounts++;
            }
        }
        System.out.println("Count of letter: " + charCounts);
        return charCounts;
    }


}




