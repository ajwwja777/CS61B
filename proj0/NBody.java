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

    /* wja_extraFn */
    public static int readNum(String txtFileName){
        In in = new In(txtFileName);
        int num = in.readInt();
        return num;
    }

    /* wja_extraFn */
    public static void drawBackground(String imageToDraw, double universeR) {
        StdDraw.setScale(-universeR, universeR);
        StdDraw.picture(0, 0, imageToDraw);
    }

    /* wja_extraFn */
    public static void drawPlants(Planet[] ps) {
        for(Planet p: ps) {
            p.draw();
        }
    }

    /* txtFileName */
    // 3body.txt
    // 8star-rotation.txt
    // antimatter.txt
    // armageddon.txt
    // atom.txt
    // awesome.txt
    // binary.txt
    // binaryStars.txt
    // bowling.txt
    // chaosblossom.txt
    // dance10.txt
    // entropy-universe.txt
    // fourellipses.txt
    // galaxy.txt
    // hypnosis.txt
    // illusion.txt
    // its-a-trap.txt
    // kaleidoscope.txt
    // kevin.txt
    // massive-squirrel-battle.txt
    // planets-elliptical.txt
    // planets.txt
    // planetsparty.txt
    // pluto.txt
    // quad-stars.txt
    public static void main(String[] args) {
        /* command line */
        // cannot javac (some Chinese words appear)
        // command line input: 157788000.0 25000.0 ./data/planets.txt
        // double T = Double.parseDouble(args[0]);
        // double dt = Double.parseDouble(args[1]); // 0th and 1st command line
        // String filename = args[2]; // 2nd command line

        /* test */
        String[] args1 = {"157788000.0", "25000.0", "data/uniform100.txt"};
        double T = Double.parseDouble(args1[0]);
        double dt = Double.parseDouble(args1[1]); // 0th and 1st command line
        String filename = args1[2]; // 2nd command line

        //Load Planets and so on
        Planet[] ps = readPlanets(filename); // new? I think both could work.
        double universeR = readRadius(filename);
        String imageToDraw = "images/starfield.jpg";

        //Draw Background and Plants test
        drawBackground(imageToDraw, universeR);
        drawPlants(ps);

        //Draw all
        StdDraw.enableDoubleBuffering();
        int num = readNum(filename);
        double[] xForces = new double[num];
        double[] yForces = new double[num];

        for(double t = 0; t < T; t += dt){
            int i = 0;
            //Calculate Force
            for(Planet p: ps) {
                xForces[i] = p.calcNetForceExertedByX(ps);
                yForces[i] = p.calcNetForceExertedByY(ps);
                i++;
            }
            //Update
            i = 0;
            for(Planet p: ps) {
                p.update(dt, xForces[i], yForces[i]);
                i++;
            }
            //Draw
            drawBackground(imageToDraw, universeR);
            drawPlants(ps);
            StdDraw.show();
            StdDraw.pause(10);
        }
        
        // Printing the Universe
        StdOut.printf("%d\n", ps.length);
        StdOut.printf("%.2e\n", universeR);
        for (Planet p: ps) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        p.xxPos, p.yyPos, p.xxVel,
                        p.yyVel, p.mass, p.imgFileName);   
            }
    }
}
