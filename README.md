GROUP 15 RUNNER GAME 

Description: Endless runner game created in JavaFX. Game contains an integrated menu and game interface. Players will earn score by jumping over obstacles and surviving as long as possible without colliding with an enemy. 

Getting Started:
*Java Runtime Environment 8; the following link will guide you to the Oracle's download site:
  https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html 

*The Graphical User Interface implemented is JavaFx which will be required to run this game. The game was developed using the Eclipse IDE along with e(fx)clipse 3.4.1 which can be found on Eclipse's Marketplace.

*TO DOWNLOAD AND PLAY THE GAME: 

1) Make sure Java IDE 1.8, eclipse, and JavaFX is installed.

To install JavaFX, refer to this helpful tutorial via youtube.com/ProgrammingKnowledge: https://www.youtube.com/watch?v=ejx3VxuIc8w

2) From inside eclipse, right click on the package explorer to create a new Java project. 
  
 (Right click in package explorer -> New -> Java Project (name can be whatever you like))

2) Download all files from the folder RunnerFinal/src/... available through the main page of this repository.

3) Set up your Java Project by importing the project folder from this GitHub. Create three packages in the Java Project (right click on the project name in package explorer -> new -> package) named "application", "main", and "view". **PACKAGE NAMES ARE CASE SENSITIVE**. Inside the "view" package, create another package called "resources". Inside the new "resources" package, create two additional packages named "characters" and "enemies". Create an additional "resources" package inside the "model" package"

4) Import the correct files into each package as shown below.

5) The game implements two sound files, both are required to be in the eclipse workplace folder you are working on:
a.) The first one is located in T03Group15/RunnerFINAL/src/view/ where it will be under the name "JumpSoundEffect.wav"
b.) Due to the restrictions of file size uploads on Github, the second sound file will not be directly available in this repository. However, the sound file may be obtained from: https://www.youtube.com/watch?v=XDmczii5-R0 by using an online converter that returns a .wav file.
    

**IF THERE IS ANY CONFUSION, REFER TO THE SETUP OF FOLDERS(PACKAGES) AND FILES OF THE SOURCE FOLDER FOUND IN THIS GITHUB**

  
    -application
    
      *Main.java
      
      
    -model
    
      -resources
      
        *kenvector_future.ttf
        
        *red_button_pressed.png
        
        *red_button.png
        
        *red_panel.png
        
      *CHARACTER.java
      
      *CharacterPicker.java
      
      *InfoLabel.java
      
      *RunnerButton.java
      
      *RunnerSubScene.java
      
      *SmallInfoLabel.java
      
    -view
    
      -resources
      
        -characters
        
          *adventurer_walk1.png
          
          *adventurer_walk2.png
          
          *zombie_walk1.png
          
          *zombie_walk2.png
          
          *female_walk1.png
          
          *female_walk2.png
          
          *soldier_walk1.png
          
          *soldier_walk2.png
          
        -enemies
        
          *slime.png
          
          slime1.png
          
        *background.png
        
        *ground.png
        
        *logo.png
        
        *red_small_panel.png
        
      *GameViewManager.java
      
      *ViewManager.java
    

Authors: Jake M, Robin S., Matt L., Carlos V.

References and Credits:

-https://youtube.com/javacraving - (JavaFX game Tutorial [SpaceRunner] [Lessons 0-14] 

-https://github.com/almasB

-https://stackoverflow.com/questions/46570494/javafx-changing-the-image-of-an-imageview-using-timeline-doesnt-work

-https://youtube.com/sheetmusicboss

