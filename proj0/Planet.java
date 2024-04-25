public class Planet {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    
    private double G = 6.67e-11;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        double dis;
        double dx = p.xxPos - xxPos;
        double dy = p.yyPos - yyPos;
        dis = Math.sqrt(dx * dx + dy * dy);
        return dis;
    }

    public double calcForceExertedBy(Planet p){
        double m1 = mass;
        double m2 = p.mass;
        double r = calcDistance(p);
        double F = G * m1 * m2 / (r * r);
        return F;
    }

    public double calcForceExertedByX(Planet p){
        double F = calcForceExertedBy(p);
        double dx = p.xxPos - xxPos;
        double r = calcDistance(p);
        double Fx = F * dx / r;
        return Fx;
    }

    public double calcForceExertedByY(Planet p){
        double F = calcForceExertedBy(p);
        double dy = p.yyPos - yyPos;
        double r = calcDistance(p);
        double Fy = F * dy / r;
        return Fy;
    }

    public double calcNetForceExertedByX(Planet[] ps){
        double Fx = 0;
        for(Planet p: ps){
            if (this.equals(p)) {
                continue;
            }
            Fx = Fx + calcForceExertedByX(p);
        }
        return Fx;
    }

    public double calcNetForceExertedByY(Planet[] ps){
        double Fy = 0;
        for(Planet p: ps){
            if (this.equals(p)) {
                continue;
            }
            Fy = Fy + calcForceExertedByY(p);
        }
        return Fy;
    }

    /** For example, samh.update(0.005, 10, 3) would adjust the velocity and position
     * if an x-force of 10 Newtons and a y-force of 3 Newtons were applied for 0.005 seconds.
     */
    public void update(double dt, double fX, double fY){
        double aX = fX / mass;
        double aY = fY / mass;
        xxVel = xxVel + aX * dt;
        yyVel = yyVel + aY * dt;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }

    public void draw() {
        String path = "images/" + imgFileName;
        StdDraw.picture(xxPos, yyPos, path);
    }
}
