/*
Stephanie Liu
Homework 1 if I were in CSS142 but I'm not
This is definitely not over-programmed at all
3/6/2021

Make a song without redundancy using only println, print, and calling void methods without arguments.
https://courses.cs.washington.edu/courses/cse142/21wi/handouts/02.pdf
*/


class Song {
    public static void main(String[] args) {

        verse1();
        verse2();
        verse3();
        verse4();
        verse5();
        verse6();
        verse7();

    }

    public static void verse1() {
        oldWomanSwallowed();
        fly();
        comma();
        flyOutro();
    }

    public static void verse2() {
        oldWomanSwallowed();
        spider();
        comma();
        System.out.println("That wriggled and iggled and jiggled inside her.");
        spiderOutro();
    }

    public static void verse3() {
        oldWomanSwallowed();
        bird();
        comma();
        System.out.println("How absurd to swallow a bird.");
        birdOutro();
    }

    public static void verse4() {
        oldWomanSwallowed();
        cat();
        comma();
        System.out.println("Imagine that to swallow a cat.");
        catOutro();
    }

    public static void verse5() {
        oldWomanSwallowed();
        dog();
        comma();
        System.out.println("What a hog to swallow a dog.");
        dogOutro();
    }

    public static void verse6(){
        oldWomanSwallowed();
        llama();
        comma();
        System.out.println("So much drama to swallow a llama.");
        llamaOutro();
    }

    public static void verse7() {
        oldWomanSwallowed();
        System.out.println("horse,");
        System.out.println("She died of course.");
    }

    public static void llamaOutro() {
        sheSwallowed();
        llama();
        toCatchThe();
        dog();
        comma();
        dogOutro();
    }

    public static void dogOutro() {
        sheSwallowed();
        dog();
        toCatchThe();
        cat();
        comma();
        catOutro();
    }

    public static void catOutro(){
        sheSwallowed();
        cat();
        toCatchThe();
        bird();
        comma();
        birdOutro();
    }

    public static void birdOutro() {
        sheSwallowed();
        bird();
        toCatchThe();
        spider();
        comma();
        spiderOutro();
    }

    public static void spiderOutro() {
        sheSwallowed();
        spider();
        toCatchThe();
        fly();
        comma();
        flyOutro();
    }

    public static void flyOutro() {
        dontKnowWhy();
        perhapsDoom();
    }

    public static void oldWomanSwallowed () {

        System.out.print("There was an old woman who swallowed a ");

    }

    public static void dontKnowWhy () {
        System.out.println("I don't know why she swallowed that fly,");
    }

    public static void perhapsDoom() {
        System.out.println("Perhaps she'll die.");
        System.out.println();
    }

    public static void sheSwallowed() {
        System.out.print("She swallowed the ");
    }

    public static void toCatchThe() {
        System.out.print(" to catch the ");
    }

    public static void comma() {
        System.out.println(",");
    }


    public static void fly() {
        System.out.print("fly");
    }

    public static void spider() {
        System.out.print("spider");
    }


    public static void bird() {
        System.out.print("bird");
    }

    public static void cat() {
        System.out.print("cat");
    }

    public static void dog() {
        System.out.print("dog");
    }

    public static void llama() {
        System.out.print("llama");
    }
}
