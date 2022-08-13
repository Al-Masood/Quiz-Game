import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class quiz implements ActionListener{
    String[] questions = new String[1000];
    String[][] options = new String[1000][4];
    int [] answers = new int[1000];
    public void datain() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("questions.txt"));
            for(int i=0; i<40; i++){
                questions[i]=reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader("options.txt"));
            for(int i=0; i<40; i++){
                for(int j=0; j<4; j++){
                    options[i][j]=reader.readLine();
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader("answers.txt"));
            for(int i=0; i<40; i++){
                answers[i]=Integer.parseInt(reader.readLine());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    int curr_ques=10;
    int no_ques=20;
    int score=0;
    int sec;
    JFrame frame = new JFrame();
    JTextField title = new JTextField();
    JButton history = new JButton();
    JButton geography = new JButton();
    JButton science = new JButton();
    JButton sports = new JButton();
    JTextField questionarea = new JTextField();
    JButton A = new JButton();
    JButton B = new JButton();
    JButton C = new JButton();
    JButton D = new JButton();

    JTextField result = new JTextField();
    JButton N = new JButton();

    JButton restart = new JButton();
    JButton quit = new JButton();
    JTextField end = new JTextField();
    JTextField final_score = new JTextField();
    JTextField points = new JTextField();
    JTextField quesno = new JTextField();
    JTextField countdown = new JTextField();


    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            sec--;
            countdown.setText(String.valueOf(sec));
            if(sec==0){
                timer.stop();
                timesup();
            }

        }
    });

    public quiz(){
        datain();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 900);
        frame.getContentPane().setBackground(new Color(239, 245, 219));
        frame.setLayout(null);
        frame.setVisible(true);

        frame.add(title);
        title.setBounds(612,100,300, 80);
        title.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        title.setBackground(new Color(239, 245, 219));
        title.setForeground(new Color(64,64,64));
        title.setFont(new Font("Century",Font.BOLD,40));
        title.setText("Quiz Yourself");
        title.setHorizontalAlignment(JTextField.CENTER);

        frame.add(history);
        history.setBounds(100,300,293,200);
        history.setBackground(new Color(64, 64, 64));
        history.setForeground(new Color(255,255,255));
        history.setFont(new Font("Century",Font.BOLD,20));
        history.setText("History");
        history.setFocusable(false);
        history.addActionListener(this);

        frame.add(geography);
        geography.setBounds(442,300,293,200);
        geography.setBackground(new Color(64, 64, 64));
        geography.setForeground(new Color(255,255,255));
        geography.setFont(new Font("Century",Font.BOLD,20));
        geography.setText("Geography");
        geography.setFocusable(false);
        geography.addActionListener(this);

        frame.add(science);
        science.setBounds(786,300,293,200);
        science.setBackground(new Color(64, 64, 64));
        science.setForeground(new Color(255,255,255));
        science.setFont(new Font("Century",Font.BOLD,20));
        science.setText("Science");
        science.setFocusable(false);
        science.addActionListener(this);

        frame.add(sports);
        sports.setBounds(1128,300,293,200);
        sports.setBackground(new Color(64, 64, 64));
        sports.setForeground(new Color(255,255,255));
        sports.setFont(new Font("Century",Font.BOLD,20));
        sports.setText("Sports");
        sports.setFocusable(false);
        sports.addActionListener(this);

        frame.add(points);
        points.setVisible(false);
        points.setBounds(100,10,300, 80);
        points.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        points.setBackground(new Color(239, 245, 219));
        points.setForeground(new Color(64,64,64));
        points.setFont(new Font("Century",Font.BOLD,30));
        points.setText("Score: "+String.valueOf(score));
        points.setHorizontalAlignment(JTextField.CENTER);

        frame.add(quesno);
        quesno.setVisible(false);
        quesno.setBounds(1125,10,300, 80);
        quesno.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        quesno.setBackground(new Color(239, 245, 219));
        quesno.setForeground(new Color(64,64,64));
        quesno.setFont(new Font("Century",Font.BOLD,30));
        quesno.setHorizontalAlignment(JTextField.CENTER);

        frame.add(questionarea);
        questionarea.setVisible(false);
        questionarea.setBounds(100,100,1325,100);
        questionarea.setBackground(new Color(64, 64, 64));
        questionarea.setForeground(new Color(255,255,255));
        questionarea.setFont(new Font("Century",Font.BOLD,20));
        questionarea.setHorizontalAlignment(JTextField.CENTER);

        frame.add(A);
        A.setEnabled(false);
        A.setVisible(false);
        A.setBounds(100,250,637,95);
        A.setBackground(new Color(64, 64, 64));
        A.setForeground(new Color(255,255,255));
        A.setFont(new Font("Century",Font.BOLD,20));
        A.setFocusable(false);
        A.addActionListener(this);

        frame.add(B);
        B.setEnabled(false);
        B.setVisible(false);
        B.setBounds(787,250,637,95);
        B.setBackground(new Color(64, 64, 64));
        B.setForeground(new Color(255,255,255));
        B.setFont(new Font("Century",Font.BOLD,20));
        B.setFocusable(false);
        B.addActionListener(this);

        frame.add(C);
        C.setEnabled(false);
        C.setVisible(false);
        C.setBounds(100,355,637,95);
        C.setBackground(new Color(64, 64, 64));
        C.setForeground(new Color(255,255,255));
        C.setFont(new Font("Century",Font.BOLD,20));
        C.setFocusable(false);
        C.addActionListener(this);

        frame.add(D);
        D.setEnabled(false);
        D.setVisible(false);
        D.setBounds(787,355,637,95);
        D.setBackground(new Color(64, 64, 64));
        D.setForeground(new Color(255,255,255));
        D.setFont(new Font("Century",Font.BOLD,20));
        D.setFocusable(false);
        D.addActionListener(this);

        frame.add(N);
        N.setEnabled(false);
        N.setVisible(false);
        N.setBounds(612,685,300,95);
        N.setBackground(new Color(64, 64, 64));
        N.setForeground(new Color(255,255,255));
        N.setFont(new Font("Century",Font.BOLD,20));
        N.setFocusable(false);
        N.addActionListener(this);
        N.setText("Next Question");

        frame.add(restart);
        restart.setEnabled(false);
        restart.setVisible(false);
        restart.setBounds(437,600,300,95);
        restart.setBackground(new Color(64, 64, 64));
        restart.setForeground(new Color(255,255,255));
        restart.setFont(new Font("Century",Font.BOLD,20));
        restart.setFocusable(false);
        restart.addActionListener(this);
        restart.setText("Play Again");

        frame.add(quit);
        quit.setEnabled(false);
        quit.setVisible(false);
        quit.setBounds(787,600,300,95);
        quit.setBackground(new Color(64, 64, 64));
        quit.setForeground(new Color(255,255,255));
        quit.setFont(new Font("Century",Font.BOLD,20));
        quit.setFocusable(false);
        quit.addActionListener(this);
        quit.setText("Quit");

        frame.add(countdown);
        countdown.setVisible(false);
        countdown.setBounds(612,530,300,95);
        countdown.setBackground(new Color(64, 64, 64));
        countdown.setForeground(new Color(255,255,255));
        countdown.setFont(new Font("Century",Font.BOLD,40));
        countdown.setHorizontalAlignment(JTextField.CENTER);

        frame.add(result);

        frame.add(final_score);

        frame.add(end);
        end.setVisible(false);
        end.setBounds(612,200,300,95);
        end.setBackground(new Color(64, 64, 64));
        end.setForeground(new Color(255,255,255));
        end.setFont(new Font("Century",Font.BOLD,20));
        end.setHorizontalAlignment(JTextField.CENTER);
        end.setText("Game Ended");
    }

    public void question(){
        if(curr_ques>=no_ques){
            game_end();
        }
        else{
            sec = 30;

            points.setVisible(true);

            quesno.setVisible(true);
            quesno.setText("Question - "+ String.valueOf(curr_ques%10+1)+" of 10");

            questionarea.setVisible(true);
            questionarea.setText(questions[curr_ques]);

            A.setText("A. " + options[curr_ques][0]);
            B.setText("B. " + options[curr_ques][1]);
            C.setText("C. " + options[curr_ques][2]);
            D.setText("D. " + options[curr_ques][3]);

            A.setEnabled(true);
            A.setVisible(true);
            B.setEnabled(true);
            B.setVisible(true);
            C.setEnabled(true);
            C.setVisible(true);
            D.setEnabled(true);
            D.setVisible(true);

            A.setBackground(new Color(64, 64, 64));
            B.setBackground(new Color(64, 64, 64));
            C.setBackground(new Color(64, 64, 64));
            D.setBackground(new Color(64, 64, 64));

            result.setVisible(false);
            countdown.setVisible(true);
            timer.start();
        }
    }

    public void actionPerformed(ActionEvent e) {
        title.setVisible(false);
        A.setEnabled(false);
        B.setEnabled(false);
        C.setEnabled(false);
        D.setEnabled(false);
        N.setEnabled(false);
        history.setEnabled(false);
        history.setVisible(false);
        geography.setEnabled(false);
        geography.setVisible(false);
        science.setEnabled(false);
        science.setVisible(false);
        sports.setEnabled(false);
        sports.setVisible(false);
        countdown.setVisible(false);
        timer.stop();
        if(e.getSource()==A){
            coloring();
            if(answers[curr_ques]==0){
                right_answer();
            }
            else{
                A.setBackground(new Color(220, 20, 60));
                wrong_answer();
            }
            N.setEnabled(true);
            N.setVisible(true);
        }
        else if(e.getSource()==B){
            sec=-1;
            coloring();
            if(answers[curr_ques]==1) right_answer();
            else{
                B.setBackground(new Color(220, 20, 60));
                wrong_answer();
            }
            N.setEnabled(true);
            N.setVisible(true);
        }
        else if(e.getSource()==C){
            sec=-1;
            coloring();
            if(answers[curr_ques]==2) right_answer();
            else{
                C.setBackground(new Color(220, 20, 60));
                wrong_answer();
            }
            N.setEnabled(true);
            N.setVisible(true);
        }
        else if(e.getSource()==D){
            sec=-1;
            coloring();
            if (answers[curr_ques] == 3) right_answer();
            else{
                D.setBackground(new Color(220, 20, 60));
                wrong_answer();
            }
            N.setEnabled(true);
            N.setVisible(true);
        }
        else if(e.getSource()==N) {
            curr_ques++;
            N.setEnabled(false);
            N.setVisible(false);
            question();
        }
        else if(e.getSource()==restart){
            frame.dispose();
            new quiz();
        }
        else if(e.getSource()==quit){
            System.exit(0);
        }
        else if(e.getSource()==history){
            curr_ques=0;
            no_ques=10;
            question();
        }
        else if(e.getSource()==geography){
            curr_ques=10;
            no_ques=20;
            question();
        }
        else if(e.getSource()==science){
            curr_ques=20;
            no_ques=30;
            question();
        }
        else if(e.getSource()==sports){
            curr_ques=30;
            no_ques=40;
            question();
        }

    }
    public void right_answer(){
        result.setVisible(true);
        result.setBounds(612,530,300,95);
        result.setBackground(new Color(102, 255, 102));
        result.setForeground(new Color(255,255,255));
        result.setFont(new Font("Century",Font.BOLD,20));
        result.setHorizontalAlignment(JTextField.CENTER);
        result.setText("Right Answer");
        score+=10;
        points.setText("Score: "+String.valueOf(score));
    }
    public void wrong_answer(){
        result.setVisible(true);
        result.setBounds(612,530,300,95);
        result.setBackground(new Color(220, 20, 60));
        result.setForeground(new Color(255,255,255));
        result.setFont(new Font("Century",Font.BOLD,20));
        result.setHorizontalAlignment(JTextField.CENTER);
        result.setText("Wrong Answer");
        points.setText("Score: "+String.valueOf(score));
    }

    public void timesup(){
        countdown.setVisible(false);
        timer.stop();
        coloring();
        result.setVisible(true);
        result.setBounds(612,530,300,95);
        result.setBackground(new Color(220, 20, 60));
        result.setForeground(new Color(255,255,255));
        result.setFont(new Font("Century",Font.BOLD,20));
        result.setHorizontalAlignment(JTextField.CENTER);
        result.setText("TIMES UP");
        N.setEnabled(true);
        N.setVisible(true);
    }

    public void coloring(){
        if(answers[curr_ques]==0){
            A.setBackground(new Color(102, 255, 102));
        }
        else if(answers[curr_ques]==1){
            B.setBackground(new Color(102, 255, 102));
        }
        else if(answers[curr_ques]==2){
            C.setBackground(new Color(102, 255, 102));
        }
        else if(answers[curr_ques]==3){
            D.setBackground(new Color(102, 255, 102));
        }
    }
    public void game_end(){
        questionarea.setVisible(false);
        A.setVisible(false);
        B.setVisible(false);
        C.setVisible(false);
        D.setVisible(false);
        result.setVisible(false);
        countdown.setVisible(false);
        points.setVisible(false);
        quesno.setVisible(false);
        end.setVisible(true);
        final_score.setVisible(true);
        final_score.setBounds(612,360,300,95);
        final_score.setBackground(new Color(64, 64, 64));
        final_score.setForeground(new Color(255,255,255));
        final_score.setFont(new Font("Century",Font.BOLD,20));
        final_score.setHorizontalAlignment(JTextField.CENTER);
        final_score.setText("Final Score: "+String.valueOf(score)+"/100");

        restart.setEnabled(true);
        restart.setVisible(true);
        quit.setEnabled(true);
        quit.setVisible(true);
    }
}
