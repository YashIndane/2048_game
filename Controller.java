package com.internshala;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


import javafx.geometry.Point2D;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class Controller implements Initializable{

    @FXML
    public Pane p1;

    @FXML
    public Rectangle base_sq;



    public final double h = 91;
    public final double w = 91;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        int m=589;
        int c=368;

        int g=283;
        int p=266;

        base_sq.setSmooth(true);
        base_sq.setArcHeight(17);
        base_sq.setArcWidth(17);

        int[] Location_store_X={283,385,487,589};
        int[] Location_store_Y={62,164,266,368};


        Rectangle[] platform_tiles=new Rectangle[16];
        for (int y=0;y<=15;y++){



                Rectangle r1 = new Rectangle();
                r1.setFill(Color.LIGHTGRAY);
                r1.setHeight(h);
                r1.setWidth(w);
                r1.setArcWidth(9);
                r1.setArcHeight(9);

                platform_tiles[y] = r1;


        }//SETTING PROPERTIES OF BASE TILES!

        int u=-1;

        for (int i=0;i<=3;i++) {
            for (int n=0;n<=3;n++) {
                u++;

                platform_tiles[u].setX(Location_store_X[n]);
                platform_tiles[u].setY(Location_store_Y[i]);
            }
        } //GENERATING BASE PLATFORM!







        Text[] value_tile=new Text [3000];
        String[] tile_value={"2","4"};

        for (int v=0;v<=2999;v++){
            Text temp=new Text();
            Random ran_value=new Random();
            int s= ran_value.nextInt((2));
            temp.setText(tile_value[s]);
            temp.setFont(Font.font("Calibri",52));
            temp.setFill(Color.DIMGRAY);
            temp.setX(-200);
            temp.setY(-200);
            value_tile[v]=temp;

        } //SETTING PROPERTIES OF ALL TILE VALUES!


        Rectangle[] tiles=new Rectangle[3000];

        for (int q=0;q<=2999;q++){

            Rectangle temp=new Rectangle();
            Color color=(value_tile[q].getText().equals("2"))? Color.ANTIQUEWHITE:Color.NAVAJOWHITE;
            temp.setFill(color);
            temp.setHeight(h);
            temp.setWidth(w);
            temp.setArcWidth(9);
            temp.setArcHeight(9);
            temp.setX(-200);
            temp.setY(-200);

            tiles[q]=temp;

        } //SETTING PROPERTIES OF ALL THE TILES!


        AtomicInteger tile_index= new AtomicInteger();
        tile_index.set(0);



        p1.addEventHandler(KeyEvent.KEY_PRESSED,event -> {



            Point2D[] all_values_position=new Point2D[3000];
            for(int b=0;b<=2999;b++){
                Point2D temp=value_tile[b].localToParent(value_tile[b].getX(),value_tile[b].getY());
                all_values_position[b]=temp;
            } //ABOVE CODE UPDATES THE REAL TIME POSITION OF TILE VALUES!


            Text[] values_in=new Text[3000];
            for (int e=0;e<=2999;e++){
                if ((all_values_position[e].getX()>=317)&&(all_values_position[e].getX()<=623)&&
                        (all_values_position[e].getY()>=123)&&(all_values_position[e].getY()<=429)){
                    Text temp=new Text();
                    temp=value_tile[e];
                    values_in[e]=temp;

                }
            }  //IN ABOVE values_in REPRESENTS THE VALUES THAT ARE IN THE GRID!

            Point2D[] all_tiles_position=new Point2D[3000];
            for (int y=0;y<=2999;y++){
                Point2D temp=tiles[y].localToParent(tiles[y].getX(),tiles[y].getY());
                all_tiles_position[y]=temp;
            }//ABOVE CODE UPDATES THE REAL TIME POSITIONS OF THE TILES!

            Rectangle[] tiles_in=new Rectangle[3000];
            for (int t=0;t<=2999;t++){
                if ((all_tiles_position[t].getX()>=283)&&(all_tiles_position[t].getX()<=589)
                        &&(all_tiles_position[t].getY()>=62)&&(all_tiles_position[t].getY()<=368)){
                    Rectangle temp=new Rectangle();
                    temp=tiles[t];
                    tiles_in[t]=temp;

                }
            }//IN ABOVE tiles_in ARRAY WE ARE STORING THE TILES THAT ARE IN THE GRID!




            Random random_X = new Random();
            Random random_Y = new Random();
            int r_x = random_X.nextInt((4));
            int r_y = random_Y.nextInt((4));

            tiles[tile_index.intValue()].setX(Location_store_X[r_x]);
            tiles[tile_index.intValue()].setY(Location_store_Y[r_y]);

            value_tile[tile_index.intValue()].setX(Location_store_X[r_x] + 34);
            value_tile[tile_index.intValue()].setY(Location_store_Y[r_y] + 61);

            tile_index.getAndIncrement();
            // ABOVE CODE IS USED FOR THE RANDOM GENERATION OF TILES WITH VALUES ON THE GRID!



            switch (event.getCode()) {
                case A:

                  Point2D[] new_in=new Point2D[3000];



                      try {

                          for (int h = 0; h <= 2999; h++) {


                              if (tiles_in[h].getTranslateX() > -(tiles_in[h].getX() - 283)) {
                                  TranslateTransition t9 = new TranslateTransition();
                                  t9.setNode(tiles_in[h]); //tiles[h]
                                  t9.setDuration(Duration.millis(80));
                                  t9.setToX(tiles_in[h].getTranslateX() - (all_tiles_position[h].getX() - 283));
                                  t9.play();


                                  TranslateTransition v = new TranslateTransition();
                                  v.setToX(values_in[h].getTranslateX() - (all_values_position[h].getX() - 317));
                                  v.setDuration(Duration.millis(80));
                                  v.setNode(values_in[h]);//value_tile
                                  v.play();


                              } else if (tiles_in[h].getTranslateX() == -(tiles_in[h].getX() - 283)) {
                              } //do nothing


                          }
                      }catch (Exception e){}




                      break;


                      case D:


                   try{

                    for (int f=0;f<=2999;f++) {


                        if (tiles_in[f].getTranslateX() < (589 - tiles_in[f].getX())) {
                            TranslateTransition t8 = new TranslateTransition();
                            t8.setToX(tiles_in[f].getTranslateX() + (589 - all_tiles_position[f].getX()));
                            t8.setDuration(Duration.millis(80));
                            t8.setNode(tiles_in[f]);
                            t8.play();

                            TranslateTransition b = new TranslateTransition();
                            b.setToX(values_in[f].getTranslateX() + (623 - all_values_position[f].getX()));
                            b.setDuration(Duration.millis(80));
                            b.setNode(values_in[f]);
                            b.play();


                        } else if (tiles_in[f].getTranslateX() > (589 - tiles_in[f].getX())) {
                        }


                    }}catch (Exception e){}
                   break;


                   case W:

                           try {

                for (int i = 0; i <= 2999; i++) {

                    if (tiles_in[i].getTranslateY() > (62 - tiles_in[i].getY())) {

                        TranslateTransition t5 = new TranslateTransition();
                        t5.setToY(tiles_in[i].getTranslateY() - (all_tiles_position[i].getY() - 62));
                        t5.setDuration(Duration.millis(80));
                        t5.setNode(tiles_in[i]);
                        t5.play();

                        TranslateTransition n = new TranslateTransition();
                        n.setToY(values_in[i].getTranslateY() - (all_values_position[i].getY() - 123));
                        n.setDuration(Duration.millis(80));
                        n.setNode(values_in[i]);
                        n.play();


                    } else if (tiles_in[i].getTranslateY() == (62 - tiles_in[i].getY())) {
                    }


                }
            }catch (Exception e){}


                    break;



                case S:


               try {
                   for (int n = 0; n <= 2999; n++) {

                       if (tiles_in[n].getTranslateY() < (368 - tiles_in[n].getY())) {

                           TranslateTransition t10 = new TranslateTransition();
                           t10.setToY(tiles_in[n].getTranslateY() + (368 - all_tiles_position[n].getY()));
                           t10.setDuration(Duration.millis(80));
                           t10.setNode(tiles_in[n]);
                           t10.play();

                           TranslateTransition s = new TranslateTransition();
                           s.setToY(values_in[n].getTranslateY() + (429 - all_values_position[n].getY())); //61+368=429
                           s.setDuration(Duration.millis(80));
                           s.setNode(values_in[n]);
                           s.play();


                       } else if (tiles_in[n].getTranslateY() == (386 - tiles_in[n].getY())) {
                       }

                   }
               }catch (Exception e){}


                        break;

            }


        });



        for (int s=0;s<=15;s++){
            p1.getChildren().addAll(platform_tiles[s]);
        }
        for (int w=0;w<=2999;w++){
            p1.getChildren().addAll(tiles[w],value_tile[w]);
        }

    }

}
