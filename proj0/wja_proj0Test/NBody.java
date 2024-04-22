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
}
