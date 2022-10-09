// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at http://www.site.uottawa.ca/school/research/lloseng/

/**
 * This class contains instances of coordinates in either polar or
 * cartesian format.  It also provides the utilities to convert
 * them into the other type. It is not an optimal design, it is used
 * only to illustrate some design issues.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @version July 2000
 */
public abstract class PointCP5
{
  abstract double getX();
  abstract double getY();
  abstract double getRho();
  abstract double getTheta();
  abstract void computeCartesian();
  abstract double getDistance(PointCP2 pointB);
  abstract double getDistance(PointCP3 pointB);
  abstract PointCP2 rotatePoint(double rotation);
  abstract PointCP3 rotatePointCartesian(double rotation);

}
