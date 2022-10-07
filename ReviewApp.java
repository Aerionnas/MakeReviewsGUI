import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class ReviewApp {
  static int numberOfReviews = 0;

public static void main(String [] args){
  ArrayList<Review> reviewList = new ArrayList<Review>();
  
  
  JFrame window= new JFrame("ReviewApp");
  JPanel main= new JPanel();
  JPanel bottom= new JPanel();
  JPanel top= new JPanel();
  JPanel veryBottom= new JPanel();
  JPanel bottomRight= new JPanel();
  
  top.setLayout(new GridLayout(4,4));
  bottom.setLayout( new GridLayout(4,0));


  JLabel reviewer= new JLabel("reviewer:");
  top.add(reviewer);
  JTextField review= new JTextField("Lilly");
  top.add(review);
  JLabel teamNumber= new JLabel("team number:");
  top.add(teamNumber);
  JTextField teamNum= new JTextField("3");
  top.add(teamNum);
  JLabel rating= new JLabel("rating:");
  top.add(rating);
  JTextField rat= new JTextField("10");
  top.add(rat);
  JLabel comments= new JLabel("comments:");
  top.add(comments);
  JTextField com= new JTextField("Great Job");
  top.add(com);

  JTextArea open= new JTextArea("Hi, why do you try writing a review?",10,50);
  bottomRight.add(open);
  
  JLabel numOfReviews= new JLabel("Number of Reviews: 0");
  JButton add =new JButton("Add Review");

  main.setLayout(new BorderLayout());
  main.add(top, BorderLayout.PAGE_START);
  main.add(bottom, BorderLayout.LINE_START);
  main.add(bottomRight, BorderLayout.LINE_END);
  main.add(veryBottom, BorderLayout.PAGE_END);
  window.setResizable(false);
  window.setContentPane(main);
  window.setSize(650,300);
  window.setLocation(100,100);
  window.setVisible(true);


  veryBottom.add(numOfReviews);
  
  bottom.add(add);
  add.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     
      
      try{
        Review s= new Review (Integer.parseInt(teamNum.getText()), Integer.parseInt(rat.getText()),review.getText(), com.getText());
        reviewList.add(s);
        System.out.println(s);
        numberOfReviews++;
        open.setText(review.getText() +" added a review to the Review List");
      
        numOfReviews.setText("Number of Reviews:"+ numberOfReviews);
        

      }

      catch(NumberFormatException fe){
        numOfReviews.setText("error");
      }
      

    }

  });

  JButton show= new JButton("Show Reviews");
  bottom.add(show);
  show.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
      open.setText(" ");
      for(Review val : reviewList){
        open.append(val.toString() + "\n");
        System.out.println(val.toString());
      }

      }

  });

  JButton save= new JButton("Save Reviews");
  bottom.add(save);
  save.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
      open.setText(" ");
      for(Review val : reviewList){
        open.append(val.toString() + "\n");
        
      }

      try{
        PrintWriter writer = new PrintWriter("Review.txt");
        writer.print(open.getText());
        writer.close();
      }
      catch(FileNotFoundException l){
        System.out.println("error");
      }
    }

  });

  // I do not remember what I was using this code for
  // JButton load= new JButton("Load Reviews");
  // bottom.add(load);
  // save.addActionListener(new ActionListener(){
  //   public void actionPerformed(ActionEvent e){

        
  //       try{
  //         File file = new File("Review.txt");
  //         Scanner scanner = new Scanner(file);
  //         String line = scanner.nextLine();
  //         int delimiter = line.indexOf("*");
  //         String name = line.substring(0,delimiter);
  //       }
  //       catch(FileNotFoundException f){
  //         System.out.print("File Not found");
  //       }
  			
        
  //       for(Review val: reviewList){
  //             // Review s = new Review(Integer.parseInt(val.getText()), Integer.parseInt(rat.getText()),review.getText(), com.getText());
  //       // reviewList.add(s);
  //       }

    

  //   }

  // });





}
}
