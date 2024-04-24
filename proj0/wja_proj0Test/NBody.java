public class NBody {

    public static double readRadius(String txtFileName) {
        In in = new In(txtFileName);
        int num = in.readInt();
        double r = in.readDouble();
        return r;
    }

    public static Planet[] readPlanets(String txtFileName) {
        In in = new In(txtFileName);
        int num = in.readInt();
        in.readDouble();

        double xxPos;
        double yyPos;
        double xxVel;
        double yyVel;
        double mass;
        String imgFileName;

        Planet[] ps = new Planet[num];
        for (int i = 0; i < num; i++) {
            xxPos = in.readDouble();
            yyPos = in.readDouble();
            xxVel = in.readDouble();
            yyVel = in.readDouble();
            mass = in.readDouble();
            imgFileName = in.readString();
            ps[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }
        return ps;
    }

    public static int readNum(String txtFileName){
        In in = new In(txtFileName);
        int num = in.readInt();
        return num;
    }

    public static void main(String[] args) {
        // 157788000.0 25000.0
        String[] args1 = {"157788000.0", "25000.0", "../data/planets.txt"}; // for test
        double T = Double.parseDouble(args1[0]);
        double dt = Double.parseDouble(args1[1]);// 0th and 1st command line
        String filename = args1[2]; //  2nd command line
        Planet[] ps = readPlanets(filename); // new?
        double universeR = readRadius(filename);

        StdDraw.enableDoubleBuffering();
        /* draw background */
        String imageToDraw = "../images/starfield.jpg";
        // StdDraw.setCanvasSize((int)universeR, (int)universeR);
        StdDraw.setScale(-universeR, universeR);
        StdDraw.clear();
        StdDraw.picture(0, 0, imageToDraw);
        StdDraw.show();
        // StdDraw.pause(2000);

        /* draw planet */
        for(Planet p: ps) {
            p.draw();
        }


        double t = 0;
        int num = readNum(filename);
        double[] xForces = new double[num];
        double[] yForces = new double[num];
        for(; t < T; t += dt){
            int i = 0;
            for(Planet p: ps) {
                xForces[i] = p.calcNetForceExertedByX(ps);
                yForces[i] = p.calcNetForceExertedByY(ps);
                i++;
            }
            i = 0;
            for(Planet p: ps) {
                p.update(dt, xForces[i], yForces[i]);
            }
            // StdDraw.clear();
            StdDraw.picture(0, 0, imageToDraw);
            for(Planet p: ps) {
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }
    }
}
