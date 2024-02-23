import java.util.Scanner;

class Line {
    float slope;
    float y_intercept;
    float x_coordinate;
    float y_coordinate;
    float x1_coordinate;
    float y1_coordinate;
    float x2_coordinate;
    float y2_coordinate;

    Line (float slope, float y_intercept) {
        this.slope = slope;
        this.y_intercept = y_intercept;

        System.out.println("y = " + slope + "x + " + y_intercept);
    }

    Line (float slope, float x_coordinate, float y_coordinate) {
        this.slope = slope;
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;

        System.out.println("(y - " + y_coordinate + ") = " + slope + "( x - " + x_coordinate + " )");
    }

    Line (float x1_coordinate, float y1_coordinate, float x2_coordinate, float y2_coordinate) {
        this.x1_coordinate = x1_coordinate;
        this.y1_coordinate = y1_coordinate;
        this.x2_coordinate = x2_coordinate;
        this.y2_coordinate = y2_coordinate;
        float m = (x2_coordinate - x1_coordinate) / (y2_coordinate - y1_coordinate); 

        System.out.println("(y - " + y1_coordinate + ") / (" + y1_coordinate + " - " + y2_coordinate + ") = " + m + "(x - " + x1_coordinate + ") / (" + x1_coordinate + " - " + x2_coordinate + ")");
    }
}

class Lines {

    static Scanner input = new Scanner(System.in);

    public static void postExecution(){
        System.out.println(" 1. Print another form \n 2. Exit");
        int option = input.nextInt();

        if(option == 1){
            start();
        }
        else if(option == 2){
            System.out.println("Code terminated");
        }
        else {
            System.out.println("Please enter valid input");
        }
    }

    public static void start(){
        System.out.println(" 1. Slope Intercept Form \n 2. Slope Point Form \n 3. Two Points Form \n 4. Exit");
        System.out.print("Choose type of line to print: ");
        int option = input.nextInt();
    
        if (option == 1){
            System.out.print("Enter slope: ");
            float slope = input.nextInt();
            System.out.print("Enter y-intercept: ");
            float y_intercept = input.nextInt();
            new Line(slope, y_intercept);
            postExecution();
        }
        else if (option == 2){
            System.out.print("Enter slope: ");
            float slope = input.nextFloat();
            System.out.print("Enter x-coordinate: ");
            float x_coordinate = input.nextFloat();
            System.out.print("Enter y-coordinate: ");
            float y_coordinate = input.nextFloat();
            new Line(slope, x_coordinate, y_coordinate);
            postExecution();
        }
        else if (option == 3){
            System.out.print("Enter x-coordinate of first point: ");
            float x1_coordinate = input.nextFloat();
            System.out.print("Enter y-coordinate of first point: ");
            float y1_coordinate = input.nextFloat();
            System.out.print("Enter x-coordinate of second point: ");
            float x2_coordinate = input.nextFloat();
            System.out.print("Enter y-coordinate of second point: ");
            float y2_coordinate = input.nextFloat();
            new Line(x1_coordinate, y1_coordinate, x2_coordinate, y2_coordinate);
            postExecution();
        }
        else if (option == 3){
            System.out.println("Code terminated");
        }
        else {
            System.out.println("Please enter valid input");
            postExecution();
        }
    }

    public static void main(String[] args) {
        start();
        input.close();
    }
}