import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

/**
 * Write a description of class Intro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroImage extends Actor
{
    public IntroImage(){
        setImage("introStory.png");
    }
    
    public void switchImg(){
        setImage("Intro.png");
    }
}
