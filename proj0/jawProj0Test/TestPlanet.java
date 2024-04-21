/**
 * @author Jaw
 *  Tests calcForceExertedBy
 */
public class TestPlanet {

    /**
     *  Tests calcForceExertedBy.
     */
    public static void main(String[] args) {
        checkcalcForceExertedBy();
    }

    /**
     *  Checks whether or not two Doubles are equal and prints the result.
     *
     *  @param  expected    Expected double
     *  @param  actual      Double received
     *  @param  label       Label for the 'test' case
     *  @param  eps         Tolerance for the double comparison.
     */
    public static void chekcEquals(double actual, double expected, String label, double eps){
        if(Math.abs(expected - actual) <= eps * Math.max(expected, actual)) {
            System.out.println("Pass" + label + "In jawProj0Test.Test1!");
        } else {
            System.out.println("In jawProj0Test.Test0!");
        }
    }

    /**
     *  Checks the Planet class to make sure calcForceExertedBy works.
     */
    public static void checkcalcForceExertedBy(){
        System.out.println("In jawProj0Test.Test!");

        Planet p1 = new Planet(0, 0, 0, 0, 1, null);
        Planet p2 = new Planet(3, 4, 0, 0, 1, null);

        chekcEquals(p1.calcForceExertedBy(p2), 2.668E-12, "JawTest", 0);
        chekcEquals(p2.calcForceExertedBy(p1), 2.668E-12, "JawTest", 0);
    }

}
